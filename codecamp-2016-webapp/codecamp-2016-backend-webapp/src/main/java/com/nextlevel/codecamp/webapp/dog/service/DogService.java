package com.nextlevel.codecamp.webapp.dog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.webapp.dog.client.DogClient;

@Service
public class DogService {

	@Autowired
	private DogClient dogClient;

	public List<Dog> getDogs() {
		return dogClient.listDogs();
	}

	public Dog addDog(Dog dog) {
		return dogClient.addDog(dog);
	}
	
	public Dog updateDog(Dog dog) {
		return dogClient.updateDog(dog);
	}

	public void deleteDog(int id) {
		dogClient.deleteDog(id);
	}
	
	public List<Dog> searchDogs(Dog dog) {
		return dogClient.findByName(dog.getName());
	}

	public List<Dog> findByName(String name) {
		return dogClient.findByName(name);
	}

}
