package com.universityHelper.services;

import java.util.ArrayList;
import java.util.HashSet;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.universityHelper.controllers.StudentSignUp;
import com.universityHelper.models.Apartment;
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
		//em.getTransaction().rollback();

		return true;
	}

	@Override
	public String logInStudent(String userName, String password) {
		try {
			StudentProfile studentProfile = em.find(StudentProfile.class, userName);
			
			if(studentProfile==null){
				return null;
			}
			
			if (studentProfile.getPassword().equals(password)) {
				return studentProfile.getStudent().getStudentId();
			} else {
				return "WP";	//wrong password
			}
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@Override
	public Student getStudentDetails(String userId) {
		
		Student student=em.find(Student.class, userId);
		
		return student;
	}

	@Override
	public boolean subscribeToApartment(String studentId, String apartmentId) {
	
		Student student = em.find(Student.class, studentId);
		Apartment apartment=em.find(Apartment.class, apartmentId);
		
		if(apartment.getStudentSubscribers()==null){
			apartment.setStudentSubscribers(new HashSet<Student>());
		}
		
		apartment.getStudentSubscribers().add(student);
		
		if(student.getSubscribedApartments()==null){
			student.setSubscribedApartments(new HashSet<Apartment>());
		}
		
		student.getSubscribedApartments().add(apartment);
		
		em.merge(student);
		em.merge(apartment);
		
		return true;
	}
	
	

}
