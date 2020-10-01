package org.se.lab.model;

import java.util.ArrayList;
import java.util.List;

import org.se.lab.annotation.JsonSequence;

public class Student {
	@JsonSequence(sequence = 3)
	private String firstname;
	@JsonSequence(sequence = 2)
	private String lastname;
	@JsonSequence(sequence = 1)
	private List<Grade> grades = new ArrayList<>();

	public String publicAttribute;

	public Student(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	private void doNothing() {

	}

}
