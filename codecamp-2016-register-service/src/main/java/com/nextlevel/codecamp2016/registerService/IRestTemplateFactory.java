package com.nextlevel.codecamp2016.registerService;

import org.springframework.web.client.RestTemplate;

public interface IRestTemplateFactory {
	
	public RestTemplate getRestTemplate();

}
