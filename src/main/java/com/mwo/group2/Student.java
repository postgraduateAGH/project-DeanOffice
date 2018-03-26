package com.mwo.group2;

import java.util.HashMap;

public class Student extends User {

	private short year;
	private String group;
	private String labGroup;
	private StudentStatus status;
	private List<Grades> grades;

	public Student() {
	}

	public Student(short year, String group, String labGroup, StudentStatus status, List<Grades> grades) {
		this.year = year;
		this.group = group;
		this.labGroup = labGroup;
		this.status = status;
		this.grades = grades;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getLabGroup() {
		return labGroup;
	}

	public void setLabGroup(String labGroup) {
		this.labGroup = labGroup;
	}

	public StudentStatus getStudentStatus() {
		return status;
	}

	public void setStudentStatus(StudentStatus status) {
		this.status = status;
	}

	public List<Grades> getGrades() {
		return grades;
	}

	public void setGrades(List<Grades> grades) {
		this.grades = grades;
	}

	/**
	 * This is displayResults method
	 * 
	 */
	public HashMap<Subject, Grades> displayResults() {
		return null;
	}

	/**
	 * This is displayPresences method
	 * 
	 */
	public HashMap<Course, HashMap<Calendar, Boolean>> displayPresences() {
		return null;
	}
}
