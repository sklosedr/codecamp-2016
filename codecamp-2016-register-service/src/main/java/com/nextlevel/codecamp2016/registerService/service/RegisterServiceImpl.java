package com.nextlevel.codecamp2016.registerService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp2016.registerService.client.DogClient;
import com.nextlevel.codecamp2016.registerService.client.UserClient;

@Service
public class RegisterServiceImpl implements RegisterService {

	private final static Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);
	
	@Autowired
	private DogClient dogClient;

	@Autowired
	private UserClient userClient;

	@Override
	public Dog convertToDog(Register reg) {
		Dog dog = new Dog();
		dog.setDescription(reg.getDescription());
		dog.setFavoriteToy(reg.getFavoriteToy());
		dog.setGoodDog(reg.isGoodDog());
		dog.setId(reg.getId());
		dog.setName(reg.getName());
		return dog;
	}

	@Override
	public DogUser convertToUser(Register reg) {
		DogUser user = new DogUser();
		user.setUsername(reg.getUsername());
		user.setPassword(reg.getPassword());
		user.setUserRole(reg.getUserRole());
		user.setId(reg.getId());
		return user;
	}

	@Override
	public String addDog(Dog dog) throws IllegalArgumentException {
		Dog response = dogClient.addDog(dog);
		if (response == null || response.getId() == null) {
			LOGGER.error("Failed to add dog " + dog.getName());
			throw new IllegalArgumentException("Failed to add dog " + dog.getName());
		}
		LOGGER.info("Saved Dog with Id=" + response.getId());
		return "Saved Dog with Id=" + response.getId();
	}

	@Override
	public String addUser(DogUser user) throws IllegalArgumentException {
		DogUser response = userClient.addUser(user);
		if (response == null || response.getId() == null) {
			LOGGER.error("Failed to add user " + user.getUsername());
			throw new IllegalArgumentException("Failed to add DogUser " + user.getUsername());
		}
		LOGGER.info("Saved DogUser with Id=" + response.getId());
		return "Saved DogUser with Id=" + response.getId();
	}

}
