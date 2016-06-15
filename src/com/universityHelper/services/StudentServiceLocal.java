package com.universityHelper.services;

import java.util.ArrayList;

import javax.ejb.Local;

import com.universityHelper.controllers.StudentSignUp;
import com.universityHelper.models.Apartment;
import com.universityHelper.models.Student;
import com.universityHelper.models.StudentProfile;

@Local
public interface StudentServiceLocal {
	public String logInStudent(String userName,String password);
	public Student getStudentDetails(String userId);
	public boolean subscribeToApartment(String studentId, String apartmentId);
	public ArrayList<Student> getOtherStudents(String studentId);
	public Student getStudentProfileDetails(String userName);
	public ArrayList<Apartment> getMyApartments(String studentId);
	public boolean updateStudentDetails(StudentProfile sp, Student s, String course);
	public boolean signUpStudent(StudentProfile sp, Student s, String course);
	public boolean unsubscribeApartment(String studentId, String apartmentId);
	public boolean updateAboutMe(String studentId, String content);
}
