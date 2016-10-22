package com.nextlevel.codecamp.user;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nextlevel.codecamp.model.user.DogUser;
import com.nextlevel.codecamp.user.data.UserCredentials;

@Configuration
@EnableDiscoveryClient
@EntityScan(basePackageClasses={DogUser.class,UserCredentials.class})
@EnableJpaRepositories
public class UserConfiguration {

}
