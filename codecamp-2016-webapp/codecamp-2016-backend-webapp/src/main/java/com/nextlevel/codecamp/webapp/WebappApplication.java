package com.nextlevel.codecamp.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappApplication {

    public static void main(String[] args) {
    	System.setProperty("spring.config.name", "backend-webapp");
        SpringApplication.run(WebappApplication.class, args);
    }
	
}
