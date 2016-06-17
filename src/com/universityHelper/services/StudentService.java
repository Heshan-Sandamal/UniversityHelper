package com.universityHelper.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.universityHelper.controllers.StudentSignUp;
import com.universityHelper.models.Apartment;
import com.universityHelper.models.Course;
import com.universityHelper.models.LandLord;
import com.universityHelper.models.Student;
import com.universityHelper.models.StudentProfile;
import com.universityHelper.models.University;
import com.universityHelper.other.Encrypt;

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
	public boolean signUpStudent(StudentProfile studentProfile, Student student, String courseName) {

		StudentProfile existingOb = em.find(StudentProfile.class, studentProfile.getUserName());

		if (existingOb == null) {
			String query = "Select c from Course c where c.name='" + courseName + "'";
			TypedQuery<Course> queryRes = em.createQuery(query, Course.class);

			Course course = queryRes.getSingleResult();
			if (course == null) {
				return false;
			}

			student.setCourse(course);

			em.persist(studentProfile);
			em.persist(student);
			return true;
		} else {
			return false;
		}


	}

	@Override
	public String logInStudent(String userName, String password) {
		try {
			StudentProfile studentProfile = em.find(StudentProfile.class, userName);

			if (studentProfile == null) {
				return null;
			}

			if (Encrypt.readEncrypt(studentProfile.getPassword()).equals(password)) {
				return studentProfile.getStudent().getStudentId();
			} else {
				return "WP"; // wrong password
			}
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@Override
	public Student getStudentDetails(String userId) {

		Student student = em.find(Student.class, userId);
		return student;
	}

	@Override
	public boolean subscribeToApartment(String studentId, String apartmentId) {

		Student student = em.find(Student.class, studentId);
		Apartment apartment = em.find(Apartment.class, apartmentId);

		if (apartment.getStudentSubscribers() == null) {
			apartment.setStudentSubscribers(new HashSet<Student>());
		}

		apartment.getStudentSubscribers().add(student);

		if (student.getSubscribedApartments() == null) {
			student.setSubscribedApartments(new HashSet<Apartment>());
		}

		student.getSubscribedApartments().add(apartment);

		em.merge(student);
		em.merge(apartment);

		return true;
	}

	@Override
	public ArrayList<Student> getOtherStudents(String studentId) {

		Student student = em.find(Student.class, studentId);
		return new ArrayList<>(student.getCourse().getStudentList());

	}

	@Override
	public Student getStudentProfileDetails(String userName) {
		StudentProfile studentProfile = em.find(StudentProfile.class, userName);
		return studentProfile.getStudent();
	}

	@Override
	public ArrayList<Apartment> getMyApartments(String studentId) {
		Student student = em.find(Student.class, studentId);
		return new ArrayList<Apartment>(student.getSubscribedApartments());
	}

	@Override
	public boolean updateStudentDetails(StudentProfile sp, Student s, String courseName) {

		StudentProfile studentProfile = em.find(StudentProfile.class, sp.getUserName());
		Student student = em.find(Student.class, s.getStudentId());

		System.out.println("cur" + courseName + "end");

		String query = "Select c from Course c where c.name='" + courseName + "'";
		TypedQuery<Course> queryRes = em.createQuery(query, Course.class);

		// query.setParameter(1, );
		Course course = queryRes.getSingleResult();
		if (course == null) {
			return false;
		}
		// Course course = em.find(Course.class, "574ae72f63250f370c624ed3");
		student.setCourse(course);

		student.setContactNo(s.getContactNo());
		student.setDob(s.getDob());
		student.setFburl(s.getFburl());
		student.setFirstName(s.getFirstName());
		student.setLastName(s.getLastName());
		student.setHomeTown(s.getHomeTown());
		student.setEmail(s.getEmail());
		student.setExamYear(s.getExamYear());

		studentProfile.setPassword(sp.getPassword());

		em.merge(student);
		em.merge(studentProfile);
		return true;

	}

	@Override
	public boolean unsubscribeApartment(String studentId, String apartmentId) {

		Student student = em.find(Student.class, studentId);
		Apartment apartment = em.find(Apartment.class, apartmentId);
		student.getSubscribedApartments().remove(apartment);
		apartment.getStudentSubscribers().remove(student);
		em.merge(student);
		em.merge(apartment);
		return true;

	}

	@Override
	public boolean updateAboutMe(String studentId, String content) {
		Student student = em.find(Student.class, studentId);
		student.setAboutMe(content);
		em.merge(student);
		return true;
	}

}
