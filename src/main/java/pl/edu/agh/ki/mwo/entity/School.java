package pl.edu.agh.ki.mwo.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "schools")
public class School implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;

	@Column
	private String address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private Set<SchoolClass> schoolClasses;

	public School() {
		schoolClasses = new HashSet<SchoolClass>();
	}

	public void addClass(SchoolClass newClass) {
		schoolClasses.add(newClass);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setClasses(Set<SchoolClass> classes) {
		this.schoolClasses = classes;
	}

	public Set<SchoolClass> getClasses() {
		return schoolClasses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void addSchoolClass(SchoolClass schoolClass) {
		if (this.schoolClasses == null) {
			this.schoolClasses = new HashSet<SchoolClass>();
		}
		this.schoolClasses.add(schoolClass);
		schoolClass.setSchool(this);
	}

	public String toString() {
		return "School: " + getName() + " (" + getAddress() + ", " + getClasses().size() + " classes)";
	}

}
