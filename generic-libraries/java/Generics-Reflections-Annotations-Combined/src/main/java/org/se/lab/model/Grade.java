package org.se.lab.model;

public class Grade {
	private Lecture lecture;
	private int grade;

	public Grade(Lecture lecture, int grade) {
		super();
		this.lecture = lecture;
		this.grade = grade;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
