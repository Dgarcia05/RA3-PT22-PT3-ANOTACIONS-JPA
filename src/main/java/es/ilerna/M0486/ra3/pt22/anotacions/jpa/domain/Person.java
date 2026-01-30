package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String surname;

	private Integer phoneNumber;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> vehicles = new ArrayList<>();

	public Person() {
	}

	public Person(String name, String surname, Integer phoneNumber) {
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}

	public void addVehicle(Vehicle vehicle) {
		if (vehicle == null)
			return;
		vehicles.add(vehicle);
		vehicle.setOwner(this);
	}

	public void removeVehicle(Vehicle vehicle) {
		if (vehicle == null)
			return;
		vehicles.remove(vehicle);
		vehicle.setOwner(null);
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}