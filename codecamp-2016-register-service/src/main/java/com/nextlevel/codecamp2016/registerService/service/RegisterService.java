package com.nextlevel.codecamp2016.registerService.service;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.model.user.DogUser;

public interface RegisterService {

	public Dog convertToDog(Register reg);

	public DogUser convertToUser(Register reg);

	public String addDog(Dog dog);

	public String addUser(DogUser user);

}
