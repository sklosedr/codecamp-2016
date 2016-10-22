package com.nextlevel.codecamp2016.registerService.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nextlevel.codecamp.model.dog.Dog;

@FeignClient("dog-service")
public interface DogClient {

	@RequestMapping(method = RequestMethod.POST, value = "/dogs")
	Dog addDog(Dog dog);

}
