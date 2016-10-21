package com.nextlevel.codecamp.webapp.dog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nextlevel.codecamp.model.dog.Dog;

@Service
public class DogService {
	
	private static String DOG_SERVICE_URL = "http://localhost:8084/dogs";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Dog> getDogs() {
		Dog dog = new Dog();
		dog.setDescription("good dog");
		dog.setName("Wuffi");
		dog.setFavoriteToy("ball");
		dog.setGoodDog(true);
		List<Dog> dogs = new ArrayList<Dog>();
		dogs.add(dog);
		return dogs;
	}
	
	public Dog createDog(Dog dog) {
		return restTemplate.postForObject(DOG_SERVICE_URL, dog, Dog.class);
	}

}
