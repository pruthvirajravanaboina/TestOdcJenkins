package com.odc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // used to mark a configuration class that declares one or more @Bean methods
public class OnlineDryCleaningApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineDryCleaningApplication.class, args);
		System.out.println("Hello!, Port is activated!");
	}

}
