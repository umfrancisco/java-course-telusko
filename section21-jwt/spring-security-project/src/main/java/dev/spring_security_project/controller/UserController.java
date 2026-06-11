package dev.spring_security_project.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.spring_security_project.model.User;
import dev.spring_security_project.service.JwtService;
import dev.spring_security_project.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {
	
	private UserService service;
	private JwtService jwtService;
	private AuthenticationManager authenticationManager;
	
	public UserController(UserService service, JwtService jwtService, AuthenticationManager authenticationManager) {
		this.service = service;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/signup")
	public User register(@RequestBody User user) {
		return service.save(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());			
		}
		return "user not found";
	}
	
}
