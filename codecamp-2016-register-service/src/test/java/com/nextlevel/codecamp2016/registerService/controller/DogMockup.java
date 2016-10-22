package com.nextlevel.codecamp2016.registerService.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp2016.registerService.client.DogClient;

@Service
@Primary
public class DogMockup implements DogClient{

	public Dog addDog(Dog dog) {
		dog.setId(1l);
		return dog;
	}

}
