package com.nni.service.dancemeup.controllers;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nni.service.dancemeup.entities.User;
import com.nni.service.dancemeup.exceptions.UserNotFoundException;
import com.nni.service.dancemeup.repositories.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

	private final UserRepository userRepository;

	@Autowired
	UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user")
	User getUser(@PathVariable String userId) {
		this.validateUser(userId);
		return this.userRepository.findByUsername(userId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	Collection<User> getUsers() {
		return this.userRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user")
	ResponseEntity<User> add(@RequestBody User user) {

		User result = userRepository.save(new User(user));

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	private void validateUser(String userId) {
        if(this.userRepository.findByUsername(userId) == null) {
            try {
                throw new UserNotFoundException(userId);
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}