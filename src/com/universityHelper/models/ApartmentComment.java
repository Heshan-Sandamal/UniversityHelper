package com.universityHelper.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Entity implementation class for Entity: ApartmentComment
 *
 */
@Entity

public class ApartmentComment implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public ApartmentComment() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "objectid")
	private String id;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Apartment apartment;
	
	private String description;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	private Date dateAndTime;
	
	
   
}
