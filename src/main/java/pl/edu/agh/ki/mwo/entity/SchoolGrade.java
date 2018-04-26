package pl.edu.agh.ki.mwo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
@Entity
@Table(name = "students_grades")*/
public class SchoolGrade {

 /*   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "students_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grades_id")
    private Grade grade;

    private List<Grade> grades = new ArrayList<Grade>(0);
*/
}
