package dev.spring_security_project.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import dev.spring_security_project.model.User;
import dev.spring_security_project.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository repository;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
	}
	
}
