package com.universityHelper.models;

import java.io.Serializable;
import javax.persistence.*;

import com.sun.istack.internal.NotNull;

/**
 * Entity implementation class for Entity: StudentProfile
 *
 */
@Entity

public class StudentProfile implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	private String userName;
	
	private String password;

	@OneToOne
	@JoinColumn(name = "studentFK",unique=true)
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public StudentProfile() {
		super();
	}
   
}



