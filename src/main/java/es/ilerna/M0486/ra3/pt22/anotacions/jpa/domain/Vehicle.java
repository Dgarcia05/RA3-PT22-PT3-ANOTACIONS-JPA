package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String brand;

	private Integer year;

	private Float price;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person owner;

	public Vehicle() {
	}

	public Vehicle(String brand, Integer year, Float price) {
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public Integer getYear() {
		return year;
	}

	public Float getPrice() {
		return price;
	}

	public Person getOwner() {
		return owner;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
}