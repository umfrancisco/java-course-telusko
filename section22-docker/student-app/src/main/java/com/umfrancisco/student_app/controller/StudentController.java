package com.umfrancisco.student_app.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.student_app.model.Student;
import com.umfrancisco.student_app.repository.StudentRepository;

@RestController
public class StudentController {
	
	private StudentRepository repository;
	
	public StudentController(StudentRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return repository.findAll();
	}
	
	@PostMapping("/student")
	public void addStudent(@RequestBody Student student) {
		repository.save(student);
	}
}
