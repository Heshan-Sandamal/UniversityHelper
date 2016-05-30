package com.universityHelper.services;

import javax.ejb.Local;

import com.universityHelper.models.Course;

@Local
public interface CourseServiceLocal {
	public boolean addCourse(Course course);
}
