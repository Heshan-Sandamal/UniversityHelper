package com.universityHelper.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.universityHelper.models.Course;

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
	public boolean addCourse(Course course) {
		em.persist(course);
		return false;
	}

}
