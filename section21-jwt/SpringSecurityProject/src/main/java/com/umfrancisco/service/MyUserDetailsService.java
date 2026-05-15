package com.umfrancisco.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.umfrancisco.model.User;
import com.umfrancisco.model.UserDetailsImpl;
import com.umfrancisco.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	private UserRepository repository;
	
	public MyUserDetailsService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		return new UserDetailsImpl(user);
	}
}
