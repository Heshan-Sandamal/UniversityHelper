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
import com.universityHelper.other.Encrypt;

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
	public boolean addLandLord(LandLord landLord, LandLordProfile landLordProfile) {

		LandLordProfile lp = em.find(LandLordProfile.class, landLordProfile.getUserName());

		if (lp == null) {
			em.persist(landLordProfile);
			em.persist(landLord);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String logIn(LandLordProfile landLordProfile) {

		LandLordProfile exitstingLLOb = em.find(LandLordProfile.class, landLordProfile.getUserName());
		if (exitstingLLOb == null) {
			return null;
		}
		if (landLordProfile.getPassword().equals(Encrypt.readEncrypt(exitstingLLOb.getPassword()))) {
			return exitstingLLOb.getLandLord().getLandLordId();
		} else {
			return "WP"; // wrong password
		}

	}

	@Override
	public LandLord getLandLord(String apartmentOwnerId) {
		LandLord landLord = em.find(LandLord.class, apartmentOwnerId);
		return landLord;
	}

	@Override
	public boolean updateLandLord(LandLord ld, LandLordProfile llp) {

		System.out.println("user name" + llp.getUserName() + "ds");

		LandLordProfile lardLordProfile = em.find(LandLordProfile.class, llp.getUserName());
		LandLord landLord = em.find(LandLord.class, ld.getLandLordId());

		System.out.println(lardLordProfile);

		lardLordProfile.setPassword(llp.getPassword());

		landLord.setFirstName(ld.getFirstName());
		landLord.setLastName(ld.getLastName());
		landLord.setAddress(ld.getAddress());
		landLord.setEmail(ld.getEmail());
		landLord.setContactNoList(ld.getContactNoList());

		em.merge(landLord);
		em.merge(lardLordProfile);

		return true;

	}

	@Override
	public LandLord getLandLordfromUserName(String userName) {
		LandLordProfile lardLordProfile = em.find(LandLordProfile.class, userName);
		return lardLordProfile.getLandLord();
	}

	@Override
	public boolean updateAboutMe(String ownerId, String content) {
		LandLord landLord = em.find(LandLord.class, ownerId);
		landLord.setAboutMe(content);
		return true;
	}

}
