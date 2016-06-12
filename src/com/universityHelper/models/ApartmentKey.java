package com.universityHelper.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

public class ApartmentKey implements Serializable {

	private Integer apartmentId;

	@Type(type="objectid")
	@Column(name = "landLordId")
	private String ownerId;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ApartmentKey) {
			ApartmentKey apt = (ApartmentKey) obj;
			if (this.apartmentId == apt.getApartmentId() && this.ownerId.equals(apt.getOwnerId())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return apartmentId.hashCode() + ownerId.hashCode();
	}

	public Integer getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return this.ownerId + String.valueOf(this.apartmentId);
	}
}
