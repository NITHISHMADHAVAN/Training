package Lib;

public class contractemp extends employee {
	private Double contperiod;

	public Double getContperiod() {
		return contperiod;
	}

	public void setContperiod(Double contperiod) {
		this.contperiod = contperiod;
	}

	public contractemp() {
	}

	public contractemp(int ID, String name, double salary, String type, double contperiod) {
		this.contperiod = contperiod;
	}
}


