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

	
	public HashMap<Przedmiot,Oceny> displayResults() {
		return null;
	}
	
	public HashMap<Source,HashMap<Calendar,Boolean>> displayPresences() {
		return null;
	}
}
