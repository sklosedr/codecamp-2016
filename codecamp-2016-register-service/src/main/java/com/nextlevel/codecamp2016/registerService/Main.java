package com.nextlevel.codecamp2016.registerService;

import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws RestClientException, URISyntaxException {
		SpringApplication.run(Main.class, args);
	}

}
