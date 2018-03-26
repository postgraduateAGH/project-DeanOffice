package com.mwo.group2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import some_package.Student;
import some_package.User;

public class Lecturer extends User {

	private List<Courses> courses;

	protected Lecturer(int id, String name, String surname, List<Courses> courses) {
		super(id, name, surname);
	}

	Map<Grade, Integer> grades = new TreeMap<>();
	Map<Presence, Boolean> presences = new TreeMap<>();

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	public Map<Grade, Integer> getGrades() {
		return grades;
	}

	public void setGrades(Map<Grade, Integer> grades) {
		this.grades = grades;
	}

	public Map<Presence, Boolean> getPresences() {
		return presences;
	}

	public void setPresences(Map<Presence, Boolean> presences) {
		this.presences = presences;
	}

	public boolean addGrade(Course course, Student student, Grade grade) {
		return grades.put(grade);
	}

	public boolean removeGrade(Course course, Student student, Grade grade) {
		return grades.remove(grade);
	}

	public boolean addPresence(Course course, Student student, Presence presence) {
		return presences.add(presence);
	}
}