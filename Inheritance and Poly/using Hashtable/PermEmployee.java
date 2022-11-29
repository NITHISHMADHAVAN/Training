package models;

public class PermEmployee extends Employees{
	public PermEmployee() {

	}

	private double incentives;

	public PermEmployee(String empname, int empid, double salary, int age, double incentives) {

		this.incentives = incentives;
	}

public double getIncentives() {
	return incentives;
}

public void setIncentives(double incentives) {
	this.incentives = incentives;
}
}

