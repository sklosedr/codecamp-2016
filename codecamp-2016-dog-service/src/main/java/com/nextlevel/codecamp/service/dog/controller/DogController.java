package com.nextlevel.codecamp.service.dog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.dog.Dog;

@RestController
@RequestMapping("/dogs")
public class DogController {

	@GetMapping
	public List<Dog> getDogs() {
		return Arrays.asList(createDummyDog());
	}
	
	@PostMapping
	public Dog createDog(@RequestBody Dog dog) {
		return dog;
	}
	
	@DeleteMapping
	public Dog deleteDog(@RequestBody Dog dog) {
		return dog;
	}
	
	@PutMapping
	public Dog updateDog(@RequestBody Dog dog) {
		return dog;
	}

	private Dog createDummyDog() {
		Dog dog = new Dog();
		dog.setName("HotDog");
		return dog;
	}
}
