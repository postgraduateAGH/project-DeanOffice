package com.mwo.group2;

import java.util.HashMap;

public class Student extends User {

	private short year;
	private String group;
	private String labGroup;
	private Status status;
	private List<Grades> oceny;

	public Student(short year, String group, String labGroup, Status status, List<Grades> oceny) {
		this.year = year;
		this.group = group;
		this.labGroup = labGroup;
		this.status = status;
		this.oceny = oceny;
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


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public List<Grades> getOceny() {
		return oceny;
	}


	public void setOceny(List<Grades> oceny) {
		this.oceny = oceny;
	}
	
	public HashMap<Przedmiot,Oceny> displayResults() {
		System.out.println("This is displayResults method");
		return null;
	}
	
	public HashMap<Source,HashMap<Calendar,Boolean>> displayPresences() {
		System.out.println("This is displayPresences method");
		return null;
	}
}
