package com.universityHelper.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Student;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class ViewStudentProfile
 */
@WebServlet("/ViewStudentProfile")
public class ViewStudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@EJB
	StudentServiceLocal studentService;

	public ViewStudentProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getParameter("userName") != null) {
			String userName = request.getParameter("userName").toString();
			Student student = studentService.getStudentProfileDetails(userName);
			if (student.getFburl() == null) {
				student.setFburl("not specified");
			}
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ViewProfile.jsp");
			request.setAttribute("Student", student);

			view.forward(request, response);
		}else{
			response.getWriter().write("Illegal userName requested");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
