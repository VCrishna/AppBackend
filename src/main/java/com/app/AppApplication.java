package com.app;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.app, com.controller, com.service, com.dao, com.model,src/main/resources/application.properties")
public class AppApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(AppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		LOGGER.info("Application Started at "+new Date()+" !");
	}

}
