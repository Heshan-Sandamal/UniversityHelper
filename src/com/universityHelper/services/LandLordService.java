package com.universityHelper.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.exists_key_return;

import com.universityHelper.models.Apartment;
import com.universityHelper.models.LandLord;
import com.universityHelper.models.LandLordProfile;

/**
 * Session Bean implementation class LandLordService
 */
@Stateless
@LocalBean
public class LandLordService implements LandLordServiceLocal {

    /**
     * Default constructor. 
     */
     
	@PersistenceContext
	EntityManager em;
     
    public LandLordService() {
        
    }

	@Override
	public boolean addLandLord(LandLord landLord,LandLordProfile landLordProfile) {
//		LandLord ll=em.find(LandLord.class,"56fd975b416283e627c3402f" );
//		
//
//		TypedQuery<LandLord> query = em.createQuery(
//		        "SELECT c FROM LandLord c where c.name=:name", LandLord.class);
//		List<LandLord> a=query.setParameter("name", "heshan").getResultList();
//		
//		em.persist(landLord);
//		return a.get(0).getName();
		em.persist(landLordProfile);
		em.persist(landLord);
		return true;
		
	}

	@Override
	public String logIn(LandLordProfile landLordProfile) {
		
		LandLordProfile exitstingLLOb = em.find(LandLordProfile.class, landLordProfile.getUserName());
		if(exitstingLLOb==null){
			return null;
		}
		if(landLordProfile.getPassword().equals(exitstingLLOb.getPassword())){
			return exitstingLLOb.getLandLord().getLandLordId();
		}else{
			return "WP";	//wrong password
		}
		
		
	}

	@Override
	public LandLord getLandLord(String apartmentOwnerId) {
		LandLord landLord=em.find(LandLord.class, apartmentOwnerId);
		return landLord;
	}
	
	
	
	
    
    

}
