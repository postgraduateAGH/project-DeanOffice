package pl.edu.agh.ki.mwo.SchoolWebApp.dao;

import java.util.List;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Grades;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Presence;

public interface StudentViewDAO {
	public List<Presence> getStudentPresences(int studentId);
	public List<Grades> getStudentGrades(int studentId);
}
