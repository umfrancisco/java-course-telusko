package com.telusko.springbootrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telusko.springbootrest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
