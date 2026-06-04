package com.telusko.springbootrest.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.telusko.springbootrest.model.User;
import com.telusko.springbootrest.repo.UserRepository;

@Service
public class UserService {
	
	private UserRepository repository;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println("Password -> "+user.getPassword());
		return repository.save(user);
	}
}
