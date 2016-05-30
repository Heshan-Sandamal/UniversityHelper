package com.universityHelper.services;

import javax.ejb.Local;

import com.universityHelper.controllers.StudentSignUp;
import com.universityHelper.models.Student;
import com.universityHelper.models.StudentProfile;

@Local
public interface StudentServiceLocal {
	public boolean signUpStudent(StudentProfile studentProfile,Student student);
}
