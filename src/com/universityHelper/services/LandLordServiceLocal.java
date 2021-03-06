package com.universityHelper.services;

import javax.ejb.Local;

import com.universityHelper.models.LandLord;
import com.universityHelper.models.LandLordProfile;

@Local
public interface LandLordServiceLocal {
	
	public boolean addLandLord(LandLord landLord,LandLordProfile landLordProfile);
	public String logIn(LandLordProfile landLordProfile);
	public LandLord getLandLord(String apartmentOwnerId);
	public boolean updateLandLord(LandLord landLord, LandLordProfile llp);
	public LandLord getLandLordfromUserName(String userName);
	public boolean updateAboutMe(String ownerId, String content);
}
