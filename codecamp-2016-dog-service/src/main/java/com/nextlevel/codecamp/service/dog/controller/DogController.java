package com.nextlevel.codecamp.service.dog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.service.dog.service.DogService;

@RestController
@RequestMapping("/dogs")
public class DogController {

	@Autowired
	private DogService dogService;
	
	@GetMapping
	public List<Dog> getDogs() {
		return dogService.list();
	}
	
	@PostMapping
	public Dog createDog(@RequestBody Dog dog) {
		return dogService.create(dog);
	}
	
	@PutMapping
	public Dog updateDog(@RequestBody Dog dog) {
		return dogService.update(dog);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
		boolean dogDeleted = dogService.delete(id);
		HttpStatus status = dogDeleted ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status).build();
	}
}
