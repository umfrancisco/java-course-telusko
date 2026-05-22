package project;


public class Worker {

	private int id;
	private String name;
	private String occupation;
	private double wage;
	
	public Worker(int id, String name, String occupation, double wage) {
		this.id = id;
		this.name = name;
		this.occupation = occupation;
		this.wage = wage;
	}
	
	@Override
	public String toString() {
		return "{id=" + id + ", name=" + name + ", ocupation=" + occupation + ", wage=" + wage + "}";
	}
}
