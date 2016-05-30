package com.universityHelper.services;

import javax.ejb.Local;

import com.universityHelper.models.University;

@Local
public interface UniversityServiceLocal {
	public boolean addUniversity(University university);
}
