package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.service.XMLValidatorService;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcsValidationProjectApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(TcsValidationProjectApplication.class);
    
    @Autowired
    XMLValidatorService xmlValidatorService;
	
	public static void main(String[] args) {
		SpringApplication.run(TcsValidationProjectApplication.class, args);
	}

    @Override
	public void run(String... args) throws Exception {
		File input = new File(System.getProperty("user.dir")+File.separator+"data"+File.separator+"input.xml");
		File XSD = new File(System.getProperty("user.dir")+File.separator+"data"+File.separator+"input.xsd");
		logger.info(String.valueOf(xmlValidatorService.validate(input,XSD)));
	}

}









