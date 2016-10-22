package com.nextlevel.codecamp2016.registerService;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.model.user.DogUser;

@Service
public class RegisterServiceImpl implements RegisterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);

	private RestTemplate restTemplate = new RestTemplate();

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
		try {
			Dog response = restTemplate.postForObject(new URI("http://localhost:8084/dogs"), dog, Dog.class);
			return "Saved Dog with Id=" + response.getId();
		} catch (URISyntaxException | RuntimeException e) {
			LOGGER.error(e.getMessage(), e);
			return e.getMessage();
		}
	}

	@Override
	public String addUser(DogUser user) {
		try {
			DogUser response = restTemplate.postForObject(new URI("http://localhost:8083/addUser"), user,
					DogUser.class);
			return "Saved User with Id=" + response.getId();
		} catch (URISyntaxException | RuntimeException e) {
			LOGGER.error(e.getMessage(), e);
			return e.getMessage();
		}
	}

}
