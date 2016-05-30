package com.universityHelper.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.universityHelper.controllers.StudentSignUp;
import com.universityHelper.models.Course;
import com.universityHelper.models.LandLord;
import com.universityHelper.models.Student;
import com.universityHelper.models.StudentProfile;

/**
 * Session Bean implementation class StudentService
 */
@Stateless
public class StudentService implements StudentServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
    public StudentService() {
        // TODO Auto-generated constructor stub
    }

	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	
	public boolean signUpStudent(StudentProfile studentProfile, Student student) {
		
		Course course = em.find(Course.class, "574ae72f63250f370c624ed3");
		student.setCourse(course);
		
		em.persist(studentProfile);
		em.persist(student);
		em.getTransaction().rollback();
		
		
		
		return true;
	}

}
