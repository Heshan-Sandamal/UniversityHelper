package com.universityHelper.services;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.json.JsonObject;

import com.universityHelper.models.University;

@Local
public interface UniversityServiceLocal {
	public boolean addUniversity(University university);

	public ArrayList<University>  getAllUniversities();

	ArrayList<String> getAllUniversityNames();
}
