package pl.edu.agh.ki.mwo.SchoolWebApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Grades;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Presence;

@Repository
public class StudentViewDAOImpl implements StudentViewDAO {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
	
	
	@Override
	@Transactional
	public List<Presence> getStudentPresences(int studentId) {
		// get current hibernate session
		Session currentSession=getSession();
		// create a query
		Query<Presence> theQuery=currentSession.createQuery("from Presence WHERE student_id="+studentId,Presence.class);
		// execute query and get results
		List<Presence> presences=theQuery.getResultList();
		// return the results
		return presences;
	}

	@Override
	@Transactional
	public List<Grades> getStudentGrades(int studentId) {
		// get current hibernate session
		Session currentSession=getSession();
		// create a query
		Query<Grades> theQuery=currentSession.createQuery("from Grades WHERE student_id="+studentId,Grades.class);
		// execute query and get results
		List<Grades> grades=theQuery.getResultList();
		// return the results
		return grades;
		
	}

}
