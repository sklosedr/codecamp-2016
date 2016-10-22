package com.nextlevel.codecamp.service.dog.service;

import java.util.List;

import com.nextlevel.codecamp.model.dog.Dog;

public interface DogService {
	List<Dog> list();
	Dog create (Dog dog);
	Dog update (Dog dog);
	boolean delete (Long id);
	List<Dog> findByName (String name);
}
