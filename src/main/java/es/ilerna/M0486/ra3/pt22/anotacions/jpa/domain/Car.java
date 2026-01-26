package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "car")
@PrimaryKeyJoinColumn(name = "id")
public class Car extends Vehicle {

	private Integer doors;
	private Integer seats;
	
	public Car() {
	}
	public Car(String brand, Integer year, Float price, Integer doors, Integer seats) {
		super(brand, year, price);
		this.doors = doors;
		this.seats = seats;
	}
	public Integer getDoors() {
		return doors;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setDoors(Integer doors) {
		this.doors = doors;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
}
