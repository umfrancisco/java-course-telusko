package com.umfrancisco.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umfrancisco.model.User;
import com.umfrancisco.service.UserService;

@RestController
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping("register")
	public User register(@RequestBody User user) {
		return service.saveUser(user);
	}
}
