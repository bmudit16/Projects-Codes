package com.converter.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${app.jsonurl}")
    private String inputJsonUrl;

    @Value("${app.outputJavaClassDirectory}")
    private String outputJavaClassDirectory;

    @Value("${app.packageName}")
    private String packageName;

    @Value("${app.javaClassName}")
    private String javaClassName;

    @Value("${app.sql.packageName}")
    private String sqlPackageName;

    @Value("${app.sql.tableName}")
    private String sqlTableName;

    @Value("${app.sql.inputFile}")
    private String inputFile;

    public String getSqlTableName() {
        return sqlTableName;
    }

    public void setSqlTableName(String sqlTableName) {
        this.sqlTableName = sqlTableName;
    }

    public String getSqlBasedClassName() {
        return sqlBasedClassName;
    }

    public void setSqlBasedClassName(String sqlBasedClassName) {
        this.sqlBasedClassName = sqlBasedClassName;
    }

    @Value("${app.sql.javaClassName}")
    private String sqlBasedClassName;

    public String getSqlPackageName() {
        return sqlPackageName;
    }

    public void setSqlPackageName(String sqlPackageName) {
        this.sqlPackageName = sqlPackageName;
    }

    public String getInputJsonUrl() {
        return inputJsonUrl;
    }

    public void setInputJsonUrl(String inputJsonUrl) {
        this.inputJsonUrl = inputJsonUrl;
    }

    public String getOutputJavaClassDirectory() {
        return outputJavaClassDirectory;
    }

    public void setOutputJavaClassDirectory(String outputJavaClassDirectory) {
        this.outputJavaClassDirectory = outputJavaClassDirectory;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getJavaClassName() {
        return javaClassName;
    }

    public void setJavaClassName(String javaClassName) {
        this.javaClassName = javaClassName;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

}
