package com.converter.app.service;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.net.ntp.TimeStamp;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.codemodel.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.converter.app.config.Config;

@Service
public class AppServiceImpl implements AppService {

    private static final Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

    @Autowired
    Config appConfig;

    @Override
    public void convertJsonToPojo() throws Exception {
        logger.info("Inside AppServiceImpl : convertJsonToPojo().......");
        URL inputJsonURL = new URL(appConfig.getInputJsonUrl());
        File outputJavaClassDirectory = new File(appConfig.getOutputJavaClassDirectory());
        String packageName = appConfig.getPackageName();
        String javaClassName = appConfig.getJavaClassName();

        JCodeModel jCodeModel = new JCodeModel();
        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };
        SchemaMapper mapper = new SchemaMapper(
                new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(jCodeModel, javaClassName, packageName, inputJsonURL);
        jCodeModel.build(outputJavaClassDirectory

        );
    }

    private LinkedHashMap<String, String> tableMap = new LinkedHashMap<>();

    private void readTableDesc() {
        logger.info("Inside AppServiceImpl : readTableDesc().......");
        Scanner sc = null;
        String path = appConfig.getInputFile();
        try {
            sc = new Scanner(new File(path));
        } catch (Exception e) {
            logger.error("Inside AppServiceImpl : readTableDesc(): while reading from Text file", e);
        }
        try {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String sentence[] = line.split(" ");
                String key = sentence[0].replace("/t", path);
                String value = sentence[1];
                tableMap.put(key, value);
            }
        } catch (Exception e) {
            logger.error("Inside AppServiceImpl : readTableDesc(): while mapping  data fromtext file to map", e);
        }
    }

    private String toCamelCase(String key) {
        logger.info("Inside AppServiceImpl : toCamelCase().......");
        String result = "";
        try {
            for (int i = 0; i < key.length(); i++) {
                if (key.charAt(i) == '_') {
                    i++;
                    if (i < key.length())
                        result += key.charAt(i);
                } else {
                    result += Character.toLowerCase(key.charAt(i));
                }
            }
        } catch (Exception e) {
            logger.error("Inside AppServiceImpl : convertSqlToPojo(): Error in Camel Case Conversion", e);
        }
        return result;
    }

    @Override
    public void convertSqlToPojo() throws Exception {
        logger.info("Inside AppServiceImpl : convertSqlToPojo().......");

        // Instantiate a new JCodeModel
        JCodeModel codeModel = new JCodeModel();
        readTableDesc();
        try {

            // Create a new Package
            JPackage jp = codeModel._package(appConfig.getSqlPackageName());
            // Create a new class
            JDefinedClass jc = jp._class(appConfig.getSqlBasedClassName());
            // Add Annotations
            JAnnotationUse entity = jc.annotate(Entity.class);
            entity.param("name", appConfig.getSqlTableName());
            JAnnotationUse table = jc.annotate(Table.class);
            JAnnotationUse data = jc.annotate(Data.class);
            JAnnotationUse noArgsConstructor = jc.annotate(NoArgsConstructor.class);

            Set<String> keys = tableMap.keySet();
            for (String key : keys) {
                String fieldName = toCamelCase(key);

                // Add Private Variable
                JFieldVar quantity;
                if (tableMap.get(key).startsWith("TimeStamp"))
                    quantity = jc.field(JMod.PRIVATE, TimeStamp.class, fieldName);
                else if (tableMap.get(key).startsWith("NUMBER"))
                    quantity = jc.field(JMod.PRIVATE, Integer.class, fieldName);
                else if (tableMap.get(key).startsWith("VARCHAR2"))
                    quantity = jc.field(JMod.PRIVATE, String.class, fieldName);
                else if (tableMap.get(key).startsWith("CLOB"))
                    quantity = jc.field(JMod.PRIVATE, String.class, fieldName);
                else if (tableMap.get(key).startsWith("DATE"))
                    quantity = jc.field(JMod.PRIVATE, Date.class, fieldName);
                else if (tableMap.get(key).startsWith("FLOAT"))
                    quantity = jc.field(JMod.PRIVATE, Double.class, fieldName);
                else {
                    quantity = null;
                    jc.javadoc().add(tableMap.get(key) + " is not defined, i.e need to ne Implemented Manually");
                }

                // Adding Column Annotation
                JAnnotationUse column = quantity.annotate(Column.class);
                column.param("name", key);
                if (tableMap.get(key).startsWith("CLOB")) {
                    JAnnotationUse lob = quantity.annotate(Lob.class);
                }
            }
        } catch (Exception e) {
            logger.error("Inside AppServiceImpl : convertSqlToPojo(): Error in Decleration", e);
        }
        // Genrate the Code
        try {
            codeModel.build(new File(appConfig.getOutputJavaClassDirectory()));
        } catch (Exception e) {
            logger.error("Inside AppServiceImpl : convertSqlToPojo(): Error in Code Build", e);
        }
    }

}
