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
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}

	public double getWage() {
		return wage;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", name=" + name + ", ocupation=" + occupation + ", wage=" + wage + "}";
	}
}
