package com.nextlevel.codecamp.webapp.dog.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nextlevel.codecamp.model.dog.Dog;

@FeignClient("dog-service")
public interface DogClient {
	@RequestMapping(method = RequestMethod.GET, value = "/dogs")
	List<Dog> listDogs();
	
	@RequestMapping(method = RequestMethod.POST, value = "/dogs")
	Dog addDog(Dog dog);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/dogs")
	Dog updateDog(Dog dog);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/dogs/{id}")
	void deleteDog(@PathVariable(value = "id") int id);

	@RequestMapping(method = RequestMethod.GET, value = "/dogs/{name}")
	List<Dog> findByName(@PathVariable(value = "name") String name);
	
}
