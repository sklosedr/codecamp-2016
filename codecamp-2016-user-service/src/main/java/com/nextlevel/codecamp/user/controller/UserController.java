package com.nextlevel.codecamp.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.user.data.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;
import javax.transaction.Transactional;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	@RestController
	public class UserController {
		
		@Autowired
		private UserRepository userRepository;
		
	    @RequestMapping("/")
	    public String index() {
	        return "Greetings from Spring Boot!";
	    }
	    
	    @RequestMapping("/users")
	    public List<DogUser> getAllUsers() {
	    	return IterableUtils.toList(userRepository.findAll());
	    }
	    
	    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
	    @Transactional
	    public DogUser addUser(@RequestBody DogUser dogUser){
	    	Long id = dogUser.getId();
	    	
	    	if(id != null && userRepository.exists(id)){
	    		throw new IllegalArgumentException("Cannot create user. User with id " + id + " already exists");
	    	}
	    	
	    	userRepository.save(dogUser);
	    	return dogUser;
	    }
	}
