package com.nextlevel.codecamp2016.registerService.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nextlevel.codecamp.model.user.DogUser;

@FeignClient("dog-service")
public interface UserClient {

	@RequestMapping(method = RequestMethod.POST, value = "/addUser")
	DogUser addUser(DogUser dog);

}
