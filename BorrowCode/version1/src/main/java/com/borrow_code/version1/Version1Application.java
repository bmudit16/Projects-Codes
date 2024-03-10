package com.borrow_code.version1;

import java.io.File;
import java.nio.file.Files;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;



@EnableScheduling
@SpringBootApplication
// @EnableJpaRepositories
public class Version1Application {



	public static void main(String[] args) {
	
		SpringApplication.run(Version1Application.class, args);
		
	}

}
