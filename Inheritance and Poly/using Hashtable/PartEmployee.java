package models;

public class PartEmployee extends Employees{
	public PartEmployee() {
	}

	public double workinghours;

	public PartEmployee(String empname, int empid, double salary, int age, double workinghours) {
		this.workinghours = workinghours;
	}

	public double getWorkinghours() {
		return workinghours;
	}

	public void setWorkinghours(double workinghours) {
		this.workinghours = workinghours;
	}
}
