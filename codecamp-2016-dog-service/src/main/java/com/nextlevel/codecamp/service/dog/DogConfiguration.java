package com.nextlevel.codecamp.service.dog;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nextlevel.codecamp.model.dog.Dog;

@Configuration
@EnableDiscoveryClient
@EntityScan(basePackageClasses=Dog.class)
@EnableJpaRepositories
public class DogConfiguration {

}
