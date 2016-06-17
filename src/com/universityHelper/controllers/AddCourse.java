package com.universityHelper.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Course;
import com.universityHelper.services.CourseServiceLocal;
import com.universityHelper.services.UniversityServiceLocal;

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

	@EJB
	UniversityServiceLocal universityService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/AddCourse.jsp");

		request.setAttribute("universityList", universityService.getAllUniversities());

		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("a"+request.getParameter("universityName")+"v");
		if (!request.getParameter("universityName").isEmpty() && request.getParameter("courseName") != null) {

			Course course = new Course();

			String university = request.getParameter("universityName");

			course.setName(request.getParameter("courseName"));
			// course.setUniversity("Mora");

			boolean added = courseService.addCourse(course, university);

			if (added) {
				response.getWriter().write("added success");
			} else {
				response.getWriter().write("added faild");
			}

		} else {
			response.getWriter().write("You must specify university for course");
		}

	}

}
