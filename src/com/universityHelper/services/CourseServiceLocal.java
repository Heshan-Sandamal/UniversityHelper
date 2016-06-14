package com.universityHelper.services;

import java.util.ArrayList;

import javax.ejb.Local;

import com.universityHelper.models.Course;

@Local
public interface CourseServiceLocal {
	public boolean addCourse(Course course, String university);

	public ArrayList<Course> getAllCourses();
}
