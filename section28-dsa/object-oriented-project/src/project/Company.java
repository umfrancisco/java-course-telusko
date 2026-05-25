package project;

import java.util.ArrayList;
import java.util.List;

public class Company {
	
	private int id;
	private String name;
	private List<Worker> workers;
	
	public Company(int id, String name) {
		this.id = id;
		this.name = name;
		workers = new ArrayList<Worker>();
	}
	
	public double wagesToPay() {
		double sum = 0;
		for (int i = 0; i < workers.size(); i++) {
			sum += workers.get(i).getWage();
		}
		return sum;
	}
	
	public void add(int id, String name, String occupation, double wage) {
		workers.add(new Worker(id, name, occupation, wage));
	}
	
	public void add(Worker worker) {
		workers.add(worker);
	}
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", workers=" + workers + "]";
	}
}
