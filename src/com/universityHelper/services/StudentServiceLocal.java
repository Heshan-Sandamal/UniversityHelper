package com.universityHelper.services;

import java.util.ArrayList;

import javax.ejb.Local;

import com.universityHelper.controllers.StudentSignUp;
import com.universityHelper.models.Student;
import com.universityHelper.models.StudentProfile;

@Local
public interface StudentServiceLocal {
	public boolean signUpStudent(StudentProfile studentProfile,Student student);
	public String logInStudent(String userName,String password);
	public Student getStudentDetails(String userId);
	public boolean subscribeToApartment(String studentId, String apartmentId);
}
