package com.umfrancisco.spring_security_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umfrancisco.spring_security_test.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByEmail(String email);
}
