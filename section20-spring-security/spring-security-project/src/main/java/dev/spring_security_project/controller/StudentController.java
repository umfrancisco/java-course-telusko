package dev.spring_security_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.spring_security_project.model.Student;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	List<Student> students = new ArrayList<>(List.of(
			new Student(101, "Navin", "Java"),
			new Student(102, "Harsh", "Java")
	));
	
	@GetMapping("/token")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
	
	@GetMapping
	public List<Student> getStudents() {
		return students;
	}
	
	@PostMapping
	public void add(@RequestBody Student student) {
		students.add(student);
	}
}
