package project0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
	public static void main(String[] args) {
		
	}
	
	public static List<Student> random(int size) {
		Random rand = new Random();
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(new Student(rand.nextInt(100), "Bob", "Java"));
		}
		return list;
	}
}

record Student(int id, String name, String course) {
	
}
