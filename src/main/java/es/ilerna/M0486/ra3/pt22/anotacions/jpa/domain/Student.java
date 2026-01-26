package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person {

	private String studentCode;
	public Student() {
	}
	public Student(String name, String surname, Integer phoneNumber, String studentCode) {
		super(name, surname, phoneNumber);
		this.studentCode = studentCode;
	}
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
}
