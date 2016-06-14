package com.universityHelper.models;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Entity implementation class for Entity: Apartment
 *
 */
@Entity

public class Apartment implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "objectid")
	private String apartmentKey;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private LandLord landLordId;
	
	private double lattitude;
	private double longitude;
	private String name;
	private String address;
	private int capacity;
	
	
	private int avilablePlaces;
	private double payment;
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.MERGE)
	private Set<University> university;
	
	@OneToMany(mappedBy = "apartment",cascade=CascadeType.REMOVE)
	private Set<ApartmentComment> apartmentComment;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	private Set<Student> studentSubscribers;
	
	//studentId,rating
	@ElementCollection
	private Map<String,Double> ratings;
	
	private double rate;
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getLattitude() {
		return lattitude;
	}

	public Set<Student> getStudentSubscribers() {
		return studentSubscribers;
	}

	public void setStudentSubscribers(Set<Student> studentSubscribers) {
		this.studentSubscribers = studentSubscribers;
	}

	public Map<String, Double> getRatings() {
		return ratings;
	}

	public void setRatings(Map<String, Double> ratings) {
		this.ratings = ratings;
	}

	public Set<ApartmentComment> getApartmentComment() {
		return apartmentComment;
	}

	public void setApartmentComment(Set<ApartmentComment> apartmentComment) {
		this.apartmentComment = apartmentComment;
	}

	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAvilablePlaces() {
		return this.avilablePlaces;
	}

	public void setAvilablePlaces(int avilablePlaces) {
		this.avilablePlaces = avilablePlaces;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public Set<University> getUniversity() {
		return university;
	}

	public void setUniversity(Set<University> university) {
		this.university = university;
	}
	
	
	public Apartment() {
		super();
	}
	
	public String getApartmentKey() {
		return apartmentKey;
	}
	public void setApartmentKey(String apartmentKey) {
		this.apartmentKey = apartmentKey;
	}
	
	public double getLattitide() {
		return lattitude;
	}
	public void setLattitide(double lattitude) {
		this.lattitude = lattitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	

	public LandLord getLandLordId() {
		return landLordId;
	}
	public void setLandLordId(LandLord landLordId) {
		this.landLordId = landLordId;
	}
	
	
	
	
}


