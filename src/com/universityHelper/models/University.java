package com.universityHelper.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.sun.istack.internal.Nullable;

@Entity
public class University implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "objectid")
	private String universityId;

	@Column(nullable = false,unique=true)
	private String name;

	@Column(nullable = false)
	private double longitude;

	@Column(nullable = false)
	private double lattitude;

	@Column(nullable = false)
	private String address;

	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Apartment> apartmentList = new HashSet<>();

	public String getUniversityId() {
		return universityId;
	}

	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLattitude() {
		return lattitude;
	}

	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Apartment> getApartmentList() {
		return apartmentList;
	}

	public void setApartmentList(Set<Apartment> apartmentList) {
		this.apartmentList = apartmentList;
	}

	@Override
	public boolean equals(Object university) {
		if (this.name.equals(((University) university).name)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
