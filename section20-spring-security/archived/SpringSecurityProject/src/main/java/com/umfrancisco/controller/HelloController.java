package com.umfrancisco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String greet(HttpServletRequest req) {
		return "hello "+req.getSession()+" "+req.getSession().getId();
	}
	
	@GetMapping("/about")
	public String about(HttpServletRequest req) {
		return "about "+req.getSession()+" "+req.getSession().getId();
	}
}
