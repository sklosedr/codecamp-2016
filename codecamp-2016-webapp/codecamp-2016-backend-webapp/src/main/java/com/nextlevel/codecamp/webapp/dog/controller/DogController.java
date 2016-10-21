package com.nextlevel.codecamp.webapp.dog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.webapp.dog.service.DogService;

@RestController
public class DogController {
	
	@Autowired
	private DogService dogService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/dogs", method = RequestMethod.POST, produces="application/json")
	public Dog createDog(@RequestBody Dog dog) {
		return dogService.createDog(dog);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/dogs", produces="application/json")
	public List<Dog> getDogs() {
		return dogService.getDogs();
	}

}
