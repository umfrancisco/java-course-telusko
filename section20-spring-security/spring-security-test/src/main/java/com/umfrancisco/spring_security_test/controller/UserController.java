package com.umfrancisco.spring_security_test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.spring_security_test.config.JwtProvider;
import com.umfrancisco.spring_security_test.model.AuthResponse;
import com.umfrancisco.spring_security_test.model.User;
import com.umfrancisco.spring_security_test.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	private UserRepository repository;
	private PasswordEncoder passwordEncoder;
	
	public UserController(UserRepository repository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) {
		User isExistingUser = repository.findByEmail(user.getEmail());
		if (isExistingUser != null) {
			return null;
		}
		User newUser = new User(
				user.getEmail(),
				passwordEncoder.encode(user.getPassword()), 
				user.getRole());
		User savedUser = repository.save(newUser);
		
		Authentication auth = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(auth);
		String token = JwtProvider.generateToken(auth);
		
		AuthResponse authResponse = new AuthResponse(token, "Register success", true);
		return ResponseEntity.status(HttpStatus.OK).body(authResponse);
	}
	
}
