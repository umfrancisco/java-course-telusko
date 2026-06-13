package com.umfrancisco.spring_security_test.model;

public class AuthResponse {
	
	private String jwt;
	private String message;
	private Boolean status;
	
	public AuthResponse(String jwt, String message, Boolean status) {
		this.jwt = jwt;
		this.message = message;
		this.status = status;
	}
}
