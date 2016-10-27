package com.nextlevel.codecamp.webapp.dog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.webapp.dog.service.DogService;

@RestController
public class DogController {
	
	@Autowired
	private DogService dogService;
	
	@PostMapping(path="/api/dogs", produces="application/json")
	public Dog addDog(@RequestBody Dog dog) {
		return dogService.addDog(dog);
	}

	@PutMapping(path="/api/dogs", produces="application/json")
	public Dog updateDog(@RequestBody Dog dog) {
		return dogService.updateDog(dog);
	}
	
	@DeleteMapping("/api/dogs/{id}")
	public void deleteDog(@PathVariable(value = "id") int id) {
		dogService.deleteDog(id);
	}
	
	@GetMapping(path="/api/dogs", produces="application/json")
	public List<Dog> getDogs() {
		return dogService.getDogs();
	}
	
	@PostMapping(path="/api/searchDogs", produces="application/json")
	public List<Dog> searchDogs(@RequestBody Dog dog) {
		return dogService.searchDogs(dog);
	}
	
	@GetMapping(path="/api/dogs/{name}", produces="application/json")
	public List<Dog> findByName(@PathVariable(value = "name") String name) {
		return dogService.findByName(name);
	}
}
