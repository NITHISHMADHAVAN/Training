package Lib;

public class permanentemp extends  employee {
	private Double incentives;

	public Double getIncentives() {
		return incentives;
	}

	public void setIncentives(Double incentives) {
		this.incentives = incentives;
	}

	public permanentemp() {
	}

	public permanentemp(int ID, String name, double salary, String type, double incentives) {
		this.incentives = incentives;
	}
}


