package pl.edu.agh.ki.mwo.SchoolWebApp.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "presences")
public class Presence implements java.io.Serializable {

	private Subjects subject;
	private Student student;
	/*@Column(name = "date")
	@Temporal(TemporalType.DATE)*/
	
	private Calendar dateField;

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

	public Calendar getDateField() {
		return dateField;
	}

	public void setDateField(Calendar dateField) {
		this.dateField = dateField;
	}
	
	
	
    
}
