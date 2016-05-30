package com.universityHelper.services;

import java.util.HashSet;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.bson.types.ObjectId;

import com.universityHelper.models.Apartment;
import com.universityHelper.models.ApartmentKey;
import com.universityHelper.models.LandLord;
import com.universityHelper.models.University;

/**
 * Session Bean implementation class ApartmentService
 */

@Stateless
@LocalBean
public class ApartmentService implements ApartmentServiceLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ApartmentService() {
		// TODO Auto-generated constructor stub
	}

	//adding apartment to database
	@Override
	public boolean addApartment(Apartment apartment) {
		
		try{
			//find landlord from db and create landLord object
			LandLord landLord = em.find(LandLord.class, "574af8936325f63db11697e7");
			
			University university = em.find(University.class, "574bb2e36325e37a6882cf2c");
			
			//set landLord to apartment
			apartment.setLandLordId(landLord);
			
			//set University for apartment
			if(apartment.getUniversity()==null){
				
				apartment.setUniversity(new HashSet<University>());
				
			};
			apartment.getUniversity().add(university);
			
			//set apartment for university
			if(university.getApartmentList()==null){
				university.setApartmentList(new HashSet<Apartment>());
			}
			
			university.getApartmentList().add(apartment);
			//persists the apartment object to db
			em.persist(apartment);
			return true;

			//TypedQuery<Apartment> query = em.createQuery("SELECT c FROM Apartment c", Apartment.class);
			//Apartment a = query.getSingleResult();
//			ApartmentKey gg = new ApartmentKey();
//			gg.setApartmentId(322);
//			gg.setOwnerId(landLord.getLandLordId());
			/*
			 * if (apt != null) {
			 * apartment.getApartmentKey().setApartmentId(apt.getApartmentKey().
			 * getApartmentId() + 1); } else {
			 * apartment.getApartmentKey().setApartmentId(0); }
			 */

			
			//apartment.getApartmentKey().setOwnerId(landLord.getLandLordId());
			//apartment.getApartmentKey().setApartmentId(321);

			
		}catch(Exception e){
			return false;
		}

	

	}
	
	//get registerd apartments
	public List<Apartment> getApartmentList(){
		//create query to fetch apartment objects
		TypedQuery<Apartment> query = em.createQuery("SELECT c FROM Apartment c", Apartment.class);
		return query.getResultList();		//fetch apartments
	}

	@Override
	public Apartment getApartmentDetails(String apartmentKey) {
		
		Apartment apartment=em.find(Apartment.class, apartmentKey);
		return apartment;
		
	}
	
	
	
	
}
