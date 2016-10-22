package com.nextlevel.codecamp.user.data;

import org.springframework.data.repository.CrudRepository;

import com.nextlevel.codecamp.model.user.DogUser;

public interface UserRepository extends CrudRepository<DogUser, Long> {
	public DogUser findByUsername(String userName);
}
