package com.nextlevel.codecamp.webapp.dog.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Dog addDog(@RequestBody Dog dog) {
		return dogService.addDog(dog);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/dogs", method = RequestMethod.PUT, produces="application/json")
	public Dog updateDog(@RequestBody Dog dog) {
		return dogService.updateDog(dog);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/dogs/{id}", method = RequestMethod.DELETE)
	public void deleteDog(@PathVariable(value = "id") int id) {
		dogService.deleteDog(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/dogs", method = RequestMethod.GET, produces="application/json")
	public List<Dog> getDogs() {
		return dogService.getDogs();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/searchDogs", method = RequestMethod.POST, produces="application/json")
	public List<Dog> searchDogs(@RequestBody Dog dog) {
		return dogService.searchDogs(dog);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="/dogs/{name}", method = RequestMethod.GET, produces="application/json")
	public List<Dog> findByName(@PathVariable(value = "name") String name) {
		return dogService.findByName(name);
	}
	
}
