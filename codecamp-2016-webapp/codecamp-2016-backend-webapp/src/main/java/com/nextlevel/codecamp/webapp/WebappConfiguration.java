package com.nextlevel.codecamp.webapp;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableDiscoveryClient
@EnableFeignClients
public class WebappConfiguration {
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
