package com.nextlevel.codecamp.webapp.user.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nextlevel.codecamp.model.user.DogUser;

@FeignClient(value = "user-service", decode404 = true)
public interface UserClient {
	@RequestMapping(method = RequestMethod.POST, value = "/authenticateUser")
	DogUser findOneByLogin(@RequestParam("username") String userName , @RequestParam("password") String userPassword);
}
