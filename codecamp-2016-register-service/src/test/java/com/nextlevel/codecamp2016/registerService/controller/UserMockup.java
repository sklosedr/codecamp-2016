package com.nextlevel.codecamp2016.registerService.controller;

import org.springframework.stereotype.Service;

import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp2016.registerService.client.UserClient;

@Service
public class UserMockup implements UserClient{

	public DogUser addUser(DogUser dogUser) {
		dogUser.setId(1l);
		return dogUser;
	}

}
