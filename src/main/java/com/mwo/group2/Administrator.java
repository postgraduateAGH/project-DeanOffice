package com.mwo.group2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Administrator extends User {

	protected Administrator(int id, String name, String surname) {
		super(id, name, surname);
	}

	Map<Student, Integer> students = new TreeMap<>();
	Map<Student, Integer> lecturers = new TreeMap<>();
	Set<String> courses = new TreeSet<>();

	public boolean addStudent(Student student) {
		return students.put(student, student.getId);
	}

	public boolean addLecturer(Lecturer lecturer) {
		return lecturers.put(lecturer, lecturer.getId);
	}

	public boolean deleteStudent(Student student) {
		return students.remove(student);
	}

	public boolean deleteLecturer(Lecturer lecturer) {
		return lecturer.remove(lecturer);
	}

	public void printReport(Report report) {
		System.out.println(report);
	}

	public boolean addCourse(Course course) {
		return courses.add(course);
	}

	public boolean deleteCourse(Course course) {
		return courses.remove(course);
	}
}
