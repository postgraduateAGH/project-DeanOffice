package pl.edu.agh.ki.mwo.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "schoolClasses")
public class SchoolClass implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private int startYear;

	@Column
	private int currentYear;

	@Column
	private String profile;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "school_id", referencedColumnName = "id")
	private School school;

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH  }, mappedBy = "schoolClass")
	private Set<Student> students;

	public SchoolClass() {
		students = new HashSet<Student>();
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String toString() {
		return "Class: " + profile + " (Started: " + getStartYear() + ", Current year: " + getCurrentYear() + ")";
	}
	@PreRemove
	private void removeAssociationsWithChilds() {
	   for (Student s : students) {
	        s.setSchoolClass(null);
	   }
	}
}