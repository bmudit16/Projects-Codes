package com.bss.videoCall;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bss.videoCall.Service.UserServiceImpl;
import com.bss.videoCall.User.User;

@SpringBootApplication
public class VideoCallApplication {

	public static void main(String[] args) {

		SpringApplication.run(VideoCallApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(UserServiceImpl service) {
		return args -> {
			service.register(User.builder()
					.userName("Abdul")
					.email("abdul.kalam@gmail.com")
					.password("aaa")
					.build());

			service.register(User.builder()
					.userName("Varun")
					.email("varunGaur@gmail.com")
					.password("aaa")
					.build());

			service.register(User.builder()
					.userName("Ryan")
					.email("ryanReynolds@gmail.com")
					.password("aaa")
					.build());
		};
	}

}
