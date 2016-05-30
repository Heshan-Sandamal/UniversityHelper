package com.universityHelper.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: LandLordProfile
 *
 */
@Entity

public class LandLordProfile implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	private String userName;
	
	private String password;
	
	@OneToOne
	private LandLord landLord;
	
	
	
	public LandLord getLandLord() {
		return landLord;
	}

	public void setLandLord(LandLord landLord) {
		this.landLord = landLord;
	}

	public LandLordProfile() {
		super();
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
}
