package com.universityHelper.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Entity implementation class for Entity: LandLord
 *
 */
@Entity

public class LandLord implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public LandLord() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "objectid")
	private String landLordId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ElementCollection(fetch=FetchType.EAGER)
	private Set<String> contactNoList=new HashSet<>();;
	
	
	@OneToOne(mappedBy="landLord")
	private LandLordProfile landLordProfile;
	
	
	@OneToMany(mappedBy="landLordId")
	private Set<Apartment> apartmentList=new HashSet<>();
	
	
	public LandLordProfile getLandLordProfile() {
		return landLordProfile;
	}

	public void setLandLordProfile(LandLordProfile landLordProfile) {
		this.landLordProfile = landLordProfile;
	}

	

	public Set<Apartment> getApartmentList() {
		return apartmentList;
	}

	public void setApartmentList(Set<Apartment> apartmentList) {
		this.apartmentList = apartmentList;
	}

	public String getLandLordId() {
		return landLordId;
	}

	public void setLandLordId(String landLordId) {
		this.landLordId = landLordId;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getContactNoList() {
		return contactNoList;
	}

	public void setContactNoList(Set<String> contactNoList) {
		this.contactNoList = contactNoList;
	}
	
	public void addContactNo(String contactNo){
		this.contactNoList.add(contactNo);
	}
	
	public void addApartment(Apartment apartment){
		this.apartmentList.add(apartment);
	}
	
	@Override
	public String toString() {
		return this.landLordId;
	}
   
}
