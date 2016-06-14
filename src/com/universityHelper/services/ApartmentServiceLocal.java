package com.universityHelper.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.json.JsonObject;

import com.universityHelper.models.Apartment;
import com.universityHelper.models.ApartmentComment;


@Local
public interface ApartmentServiceLocal {
	public JsonObject getApartmentList(String universityName);
	public Apartment getApartmentDetails(String apartmentKey);
	public boolean addApartment(Apartment ap, String landLordId, String[] universityList);
	public ArrayList<Apartment> getApartmentListOfLandLord(String landLordId);
	public boolean addComment(ApartmentComment acm, String apartmentId, String studentId);
	public ArrayList<ApartmentComment> getApartmentComments(String apartmentId);
	public boolean addRatings(String studentId, String apartmentId, Double rating);
	public boolean deleteApartment(String apartmentId);
}
