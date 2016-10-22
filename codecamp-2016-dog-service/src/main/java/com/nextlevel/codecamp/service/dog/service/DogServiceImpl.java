package com.nextlevel.codecamp.service.dog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nextlevel.codecamp.model.dog.Dog;
import com.nextlevel.codecamp.service.dog.repository.DogRepository;

@Service
public class DogServiceImpl implements DogService{
	private final static Logger LOGGER = LoggerFactory.getLogger(DogServiceImpl.class);
	
	@Autowired
	private DogRepository dogRepository;

	@Override
	public List<Dog> list() {
		return dogRepository.findAll(sortByIdDesc());
	}
	
	private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }

	@Override
	public Dog create(Dog dog) {
		return dogRepository.save(dog);
	}

	@Override
	public Dog update(Dog dog) {
		return dogRepository.save(dog);
	}

	@Override
	public boolean delete(Long id) {
		try {
			dogRepository.delete(id);
			return true;
		} catch (EmptyResultDataAccessException ex) {
			LOGGER.info("Could not delete dog: {}", ex.getMessage());
			return false;
		}
	}

	@Override
	public List<Dog> findByName(String name) {
		return dogRepository.findByName(name);
	}
}
