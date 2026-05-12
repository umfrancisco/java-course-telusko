package com.umfrancisco.service;

import org.springframework.stereotype.Service;

import com.umfrancisco.model.User;
import com.umfrancisco.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User saveUser(User user) {
		return repository.save(user);
	}
}
