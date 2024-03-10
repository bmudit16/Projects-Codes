package com.borrow_code.version1.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.borrow_code.version1.service.AppService;

@Component
public class AppScheduler {
    Logger logger = LoggerFactory.getLogger(AppScheduler.class);

    @Autowired
    AppService appService;

    @Bean
    void callCreateProject() {
        logger.info("Inside AppScheduler : callCreateProject()...");
        System.out.println("Inside Scheduler");
        try {
            appService.createProject();
        } catch (Exception e) {
            logger.error("Inside AppScheduler : callCreateProject() error", e);
        }
    }
}
