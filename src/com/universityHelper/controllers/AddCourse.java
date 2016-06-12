package com.universityHelper.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Course;
import com.universityHelper.services.CourseServiceLocal;

/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	@EJB
	CourseServiceLocal courseService;
	
	public AddCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	SessionContext ctx;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Course course = new Course();

		course.setName("TLM");
		course.setUniversity("Mora");
		
		courseService.addCourse(course);

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
