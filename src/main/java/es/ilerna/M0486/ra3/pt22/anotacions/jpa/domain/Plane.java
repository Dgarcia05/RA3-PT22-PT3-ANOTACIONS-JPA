package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "plane")
@PrimaryKeyJoinColumn(name = "id")
public class Plane extends Vehicle {

	private Integer tailNumber;
	private boolean autopilot;
	
	public Plane() {
	}
	public Plane(String brand, Integer year, Float price, Integer tailNumber, boolean autopilot) {
		super(brand, year, price);
		this.tailNumber = tailNumber;
		this.autopilot = autopilot;
	}
	public Integer getTailNumber() {
		return tailNumber;
	}
	public boolean isAutopilot() {
		return autopilot;
	}
	public void setTailNumber(Integer tailNumber) {
		this.tailNumber = tailNumber;
	}
	public void setAutopilot(boolean autopilot) {
		this.autopilot = autopilot;
	}
}
