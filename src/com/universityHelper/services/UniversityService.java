package com.universityHelper.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.universityHelper.models.University;

/**
 * Session Bean implementation class UniversityService
 */
@Stateless
@LocalBean
public class UniversityService implements UniversityServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
    public UniversityService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addUniversity(University university) {
		em.persist(university);
		return true;
	}

}
