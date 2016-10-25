package com.nextlevel.codecamp.webapp;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableDiscoveryClient
@EnableFeignClients
public class WebappConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:4200")
			.allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
			.allowedHeaders("*")
			//.exposedHeaders("header1", "header2")
			.allowCredentials(true).maxAge(1800);
	}

}
