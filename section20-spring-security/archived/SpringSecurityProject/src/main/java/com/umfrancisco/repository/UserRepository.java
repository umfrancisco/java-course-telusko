package com.umfrancisco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umfrancisco.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
