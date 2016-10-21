package com.nextlevel.codecamp.service.dog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextlevel.codecamp.model.dog.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long>{

	public Dog findByName(String name);
}
