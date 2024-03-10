package com.converter.app.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.converter.app.service.AppService;

@Component
public class AppScheduler {
    Logger logger = LoggerFactory.getLogger(AppScheduler.class);

    @Autowired
    AppService serviceImpl;

    @Bean
    public void callJsoNToPojoConverter() {
        logger.info("Inside AppScheduler : callJsoNToPojoConverter().......");
        try {
            serviceImpl.convertJsonToPojo();
            logger.info("Inside AppScheduler : callJsoNToPojoConverter() success!");
        } catch (Exception e) {
            logger.error("Inside AppScheduler : callJsoNToPojoConverter()", e);
        }
    }

    @Bean
    public void callConvertSqlToPojo() {
        logger.info("Inside AppScheduler : callConvertSqlToPojo().......");
        try {
            serviceImpl.convertSqlToPojo();
            logger.info("Inside AppScheduler : callConvertSqlToPojo() success!");
        } catch (Exception e) {
            logger.error("Inside AppScheduler : callConvertSqlToPojo()", e);
        }
    }
}
