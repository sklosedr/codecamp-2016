package com.nextlevel.codecamp2016.registerService.client;

import com.nextlevel.codecamp.model.dog.Dog;

public class DogClientMock implements DogClient {

	@Override
	public Dog addDog(Dog dog) {
		dog.setId(0L);
		return dog;
	}

}
