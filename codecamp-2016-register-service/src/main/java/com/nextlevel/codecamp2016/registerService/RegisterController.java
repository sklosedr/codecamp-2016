package com.nextlevel.codecamp2016.registerService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.model.user.UserRole;

@RestController
public class RegisterController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/registration")
	public String registrationGet(Model model) {
		model.addAttribute("register", new Register());
		return "registration";
	}

	@PostMapping("/registration")
	public String submitRegistration(@RequestBody Register register) {
		Dog dog = new Dog();
		convertToDog(dog, register);
		boolean addDog = addDog(dog);
		DogUser user = new DogUser();
		convertToUser(user, register);
		boolean addUser = addUser(user);
		return addDog && addUser ? "success" : "failure";
	}

	private boolean addDog(Dog dog) {
		try {
			String response = restTemplate.postForObject(new URI("http://localhost:8084/dogs"), dog, String.class);
			logger.debug(response);
			return true;
		} catch (RestClientException | URISyntaxException e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	private boolean addUser(DogUser user) {
		try {
			String response = restTemplate.postForObject(new URI("http://localhost:8083/users"), user, String.class);
			logger.debug(response);
			return true;
		} catch (RestClientException | URISyntaxException e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	private void convertToDog(Dog dog, Register reg) {
		dog.setDescription(reg.getDescription());
		dog.setFavoriteToy(reg.getFavoriteToy());
		dog.setGoodDog(reg.isGoodDog());
		dog.setId(reg.getId());
		dog.setName(reg.getName());
	}

	private void convertToUser(DogUser user, Register reg) {
		user.setUsername(reg.getUsername());
		user.setPassword(reg.getPassword());
		user.setUserRole(reg.getUserRole());
		user.setId(reg.getId());
	}

	// only testing
	@RequestMapping(value = "/getRegistrations", method = RequestMethod.GET)
	public List<Register> getRegistrations() {
		List<Register> list = new ArrayList<>();
		Register reg = new Register();
		reg.setId(1l);
		reg.setUsername("some_dog");
		reg.setPassword("test");
		reg.setUserRole(UserRole.USER);
		list.add(reg);
		return list;
	}
}
