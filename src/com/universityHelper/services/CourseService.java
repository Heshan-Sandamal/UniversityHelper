package com.universityHelper.services;

import java.util.ArrayList;
import java.util.HashSet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.universityHelper.models.Course;
import com.universityHelper.models.University;

/**
 * Session Bean implementation class CourseService
 */
@Stateless
@LocalBean
public class CourseService implements CourseServiceLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public CourseService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCourse(Course course,String universityName) {
		String query = "Select c from University c where c.name='" + universityName + "'";
		TypedQuery<University> queryRes = em.createQuery(query, University.class);

		// query.setParameter(1, );
		University university = queryRes.getSingleResult();
		
		course.setUniversity(university);
		if(university.getCourseList()==null){
			university.setCourseList(new HashSet<Course>());
		}
		
		university.getCourseList().add(course);
		em.persist(course);
		return true;
	}

	@Override
	public ArrayList<Course> getAllCourses() {
		String query = "SELECT c FROM Course c";
		TypedQuery<Course> queryRes = em.createQuery(query, Course.class);
		ArrayList<Course> list = (ArrayList<Course>) queryRes.getResultList();
		System.out.println(list.size()+list.toString());
		return list;
	}

}
