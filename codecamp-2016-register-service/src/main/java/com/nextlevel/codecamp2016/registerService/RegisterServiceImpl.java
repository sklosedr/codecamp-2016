package com.nextlevel.codecamp2016.registerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.model.user.DogUser;

@Service
public class RegisterServiceImpl implements RegisterService {

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
	public String addDog(Dog dog) {
		Dog response = dogClient.addDog(dog);
		if (response == null || response.getId() == null) {
			return "Failed to add dog " + dog.getName();
		}
		return "Saved Dog with Id=" + response.getId();
	}

	@Override
	public String addUser(DogUser user) {
		DogUser response = userClient.addUser(user);
		if (response == null || response.getId() == null) {
			return "Failed to add dog " + user.getUsername();
		}
		return "Saved Dog with Id=" + response.getId();
	}

}
