package models;
public class Employees {
	 protected String empname;
	  private int empid;
	   protected double salary;
	  public int age;
	  private double workingHours;
	  protected double incentives;
	
	public Employees() {

	}

	public Employees(String empname, int empid,  int age, double salary, int workingHours) {
		this.empname = empname;
		this.empid = empid;
		this.age = age;
		this.salary = salary;
		this.workingHours=workingHours;
	}

	public String getEmpName() {
		return empname;
	}

	public int getEmpid() {
		return empid;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	public void setName(String empname) {
		this.empname = empname;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

	public void setIncentives(double incentives) {
		this.incentives=incentives;	
	}
	
}