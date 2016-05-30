package com.universityHelper.services;

import java.util.List;

import javax.ejb.Local;

import com.universityHelper.models.Apartment;

@Local
public interface ApartmentServiceLocal {
	public boolean addApartment(Apartment apartment);
	public List<Apartment> getApartmentList();
	public Apartment getApartmentDetails(String apartmentKey);
}
