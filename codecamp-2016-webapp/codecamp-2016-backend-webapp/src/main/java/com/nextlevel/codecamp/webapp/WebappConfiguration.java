package com.nextlevel.codecamp.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebappConfiguration {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
