package project;

public class Application {
	public static void main(String[] args) {
		Company comp1 = new Company(101, "Hello World");
		comp1.add(1, "John", "Programmer", 1500);
		comp1.add(2, "Joe", "Lawyer", 1200);
		System.out.println(comp1);
	}
}
