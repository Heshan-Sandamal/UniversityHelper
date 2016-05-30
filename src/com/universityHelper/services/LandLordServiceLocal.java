package com.universityHelper.services;

import javax.ejb.Local;

import com.universityHelper.models.LandLord;
import com.universityHelper.models.LandLordProfile;

@Local
public interface LandLordServiceLocal {
	
	public boolean addLandLord(LandLord landLord,LandLordProfile landLordProfile);
	public boolean logIn(LandLordProfile landLordProfile);
}
