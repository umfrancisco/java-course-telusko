package dev.spring_security_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.spring_security_project.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
