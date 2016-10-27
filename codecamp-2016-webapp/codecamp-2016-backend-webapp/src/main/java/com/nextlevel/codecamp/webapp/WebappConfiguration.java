package com.nextlevel.codecamp.webapp;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
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
			.allowCredentials(true)
			.allowedOrigins("http://localhost:4200")
			.allowedMethods("*")
			.allowedHeaders("*");
	}
}
