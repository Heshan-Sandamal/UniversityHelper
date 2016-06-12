package com.universityHelper.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.universityHelper.models.Apartment;
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

	@Override
	//@RolesAllowed({"ApartmentOwner","Student"})
	public ArrayList<University> getAllUniversities() {
		TypedQuery<University> query = em.createQuery("SELECT c FROM University c", University.class);
		ArrayList<University> list = (ArrayList<University>) query.getResultList(); // fetch
																					// apartments
		return list;
	}

	@Override
	//@RolesAllowed({"Administrator"})
	public ArrayList<String> getAllUniversityNames() {
		TypedQuery<String> query = em.createQuery("SELECT c.name FROM University c", String.class);
		ArrayList<String> list = (ArrayList<String>) query.getResultList(); // fetch
																			// apartments
		System.out.println("this is univ list" + list.size());
		for (String s : list) {
			System.out.print(s);
		}

		return list;
	}

}
