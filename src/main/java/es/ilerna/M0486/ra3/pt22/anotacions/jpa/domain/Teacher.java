package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {
	
	private String teacherCode;
	
	public Teacher() {
	}
	
	public Teacher(String name, String surname, Integer phoneNumber, String teacherCode) {
		super(name, surname, phoneNumber);
		this.teacherCode = teacherCode;
	}
	
	public String getTeacherCode() {
		return teacherCode;
	}
	
	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}
}
