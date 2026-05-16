package com.umfrancisco.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.model.User;
import com.umfrancisco.service.JwtService;
import com.umfrancisco.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	private AuthenticationManager authenticationManager;
	private JwtService jwtService;
	
	public UserController(UserService userService, AuthenticationManager authenticationManager, JwtService jwtService) {
		this.userService = userService;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}
	
	@PostMapping("register")
	public User register(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PostMapping("login")
	public String login(@RequestBody User user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		} else {
			return "failure";
		}
	}
}
