package com.borrow_code.version1.service;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.sun.codemodel.*;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borrow_code.version1.config.AppConfig;

@Service
public class AppServiceImpl implements AppService {

    Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

    private static String applicationName = "";
    private static LinkedHashMap<String, String> fields = new LinkedHashMap<>();
    private static String identity = "";

    @Autowired
    AppConfig appConfig;

    @Override
    public void createProject() throws Exception {

        logger.info("Inside AppServiceImpl: createProject()");

        String baseFolder = appConfig.getBaseFolder();
        String outputFolder = appConfig.getOutputFolder();
        File src = new File(baseFolder);
        File dest = new File(outputFolder);

        try {
            File[] listOfFiles = dest.listFiles();
            if (listOfFiles.length == 0)
                FileUtils.copyDirectory(src, dest);
            else
                throw new Exception("Application already Exists");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

    @Override
    public void addEntity() throws Exception {

        logger.info("Inside AppServiceImpl: addEntity()...");
        String txtPath = "F:\\git\\Projects\\BorrowCode\\version1\\inputs\\inputs.txt";
        String entityPath = "F:\\git\\Projects\\BorrowCode\\version1\\OutputFolder\\application\\src\\main\\java\\com\\application\\application\\Entity";
        File file = new File(txtPath);
        readInputs(file);

            //Instantiate a new JCodeModel
        JCodeModel codeModel = new JCodeModel();
        //create a New Package
    }

    public void readInputs(File file) throws Exception {
        logger.info("Inside AppServiceImpl: readInputs()....");
        Scanner sc = new Scanner(file);
        try {
            long count = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (count == 0) {
                    applicationName = line;
                    logger.info("Application Name = " + line);
                } else {
                    String sentence[] = line.split("=|(");
                    fields.put(sentence[0], sentence[1]);
                    if (sentence.length > 2)
                        identity = sentence[0];
                }
                count++;
            }
            logger.info("Identity is " + identity);
            logger.info("No of Fields in Entity = " + fields.size());
        } catch (Exception e) {
            e.printStackTrace(System.out);
            logger.error("Inside AppServiceImpl: readInputs() while reading from file", e);
        }
    }

    @Override
    public void addRepository() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRepository'");
    }

    @Override
    public void addDao() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDao'");
    }

    @Override
    public void addService() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addService'");
    }

    @Override
    public void addController() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addController'");
    }

    @Override
    public void addApplicationDotProperties() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addApplicationDotProperties'");
    }

}
