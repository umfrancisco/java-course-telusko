package com.umfrancisco.project1;

public class Application {
	public static void main(String[] args) {
		var user = new User(101, "Francisco", "francisco@email.com");
		user.print();
	}
}

record User(int id, String name, String email) {
	
	public void print() {
		System.out.println(this);
	}
}
