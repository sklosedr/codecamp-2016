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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	    
	    @RequestMapping("/user/")
	    public List<DogUser> getUser(Long id) {
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
	    
	    @RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	    @Transactional
	    public ResponseEntity<DogUser> authenticate(@RequestParam(value = "username") String username , @RequestParam(value = "password") String password){
	    	DogUser dogUser = userRepository.findByUsernameAndPassword(username, password);
	    	if(dogUser == null){
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    	}
	    	return ResponseEntity.status(HttpStatus.OK).body(dogUser);
	    }
	    
	    
	}
