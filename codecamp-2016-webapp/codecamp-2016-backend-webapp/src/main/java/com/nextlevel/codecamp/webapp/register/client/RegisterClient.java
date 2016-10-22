package com.nextlevel.codecamp.webapp.register.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nextlevel.codecamp.model.register.Register;

@FeignClient("register-service")
public interface RegisterClient {

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	ResponseEntity<String> register(Register register);

}
