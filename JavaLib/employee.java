package Lib;

public class employee {
		private int ID;
		private String name;
		private Double salary;
		private String type;

		public employee() {
		}

		public employee(int ID, String name, double salary, String type) {
			this.name = name;
			this.ID = ID;
			this.salary = salary;
			this.type = type;
		}

		public int getEmpID() {
			return ID;
		}

		public void setEmpID(int ID) {
			this.ID = ID;
		}

		public String getempname() {
			return name;
		}

		public void setempname(String name) {
			this.name = name;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}


