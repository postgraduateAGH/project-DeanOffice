package pl.edu.agh.ki.mwo.SchoolWebApp.dao;

import java.util.List;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Grades;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Presence;

public interface StudentViewDAO {
	public List<Presence> getStudentPresences(String email);
	public List<Grades> getStudentGrades(String email);
}
