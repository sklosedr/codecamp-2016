package com.nextlevel.codecamp2016.registerService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DefaultRestTemplateFactory implements IRestTemplateFactory {
	
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
