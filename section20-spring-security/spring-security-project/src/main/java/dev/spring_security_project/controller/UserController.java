package dev.spring_security_project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.spring_security_project.model.User;
import dev.spring_security_project.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping("/signup")
	public User register(@RequestBody User user) {
		return service.save(user);
	}
	
}
