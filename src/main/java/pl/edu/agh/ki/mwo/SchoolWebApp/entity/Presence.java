package pl.edu.agh.ki.mwo.SchoolWebApp.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "presences")
public class Presence implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "subject_id", nullable = true)
	private Subjects subject;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "student_id", nullable = true)
	private Student student;

	@Column(name = "date")
	private String dateField;

	@Column(name = "presence")
	private int presence;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPresence() {
		return presence;
	}

	public void setPresence(int presence) {
		this.presence = presence;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDateField() {
		return dateField;
	}

	public void setDateField(String dateField) {
		this.dateField = dateField;
	}

	public Presence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Presence(Subjects subject, Student student, String dateField) {
		super();
		this.subject = subject;
		this.student = student;
		this.dateField = dateField;
	}

}