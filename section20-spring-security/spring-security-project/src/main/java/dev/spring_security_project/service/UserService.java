package dev.spring_security_project.service;

import org.springframework.stereotype.Service;
import dev.spring_security_project.model.User;
import dev.spring_security_project.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository repository;
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User save(User user) {
		return repository.save(user);
	}
	
}
