package com.nextlevel.codecamp2016.registerService.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.model.register.Register;
import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.model.user.UserRole;
import com.nextlevel.codecamp2016.registerService.TestSubmitRegistration;
import com.nextlevel.codecamp2016.registerService.service.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	// only testing
	@GetMapping("/")
	public String index(Model model) {
		return "Register-Service is running.";
	}

	// only testing
	@GetMapping("/register")
	public String registrationGet(Model model) {
		model.addAttribute("register", new Register());
		return "registration";
	}

	@PostMapping("/register")
	public ResponseEntity<String> submitRegistration(@RequestBody Register register) {
		Dog dog = registerService.convertToDog(register);
		DogUser user = registerService.convertToUser(register);
		String addDog;
		String addUser;
		HttpStatus status = HttpStatus.CREATED;
		try {
			addDog = registerService.addDog(dog);
		} catch (IllegalArgumentException e) {
			status = HttpStatus.CONFLICT;
			addDog = e.getMessage();
		}
		try {
			addUser = registerService.addUser(user);
		} catch (IllegalArgumentException e) {
			status = HttpStatus.CONFLICT;
			addUser = e.getMessage();
		}
		return ResponseEntity.status(status).body(buildResponseJson(addDog, addUser));
	}

	private String buildResponseJson(String addDog, String addUser) {
		return new JSONObject().put("dog", addDog).put("user", addUser).toString();
	}

	// only testing
	@GetMapping("/test")
	public String test(Model model) {
		new TestSubmitRegistration().test();
		return "test executed";
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
