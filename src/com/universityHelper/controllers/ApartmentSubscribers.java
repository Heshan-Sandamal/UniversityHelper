package com.universityHelper.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Apartment;
import com.universityHelper.models.Student;
import com.universityHelper.services.ApartmentServiceLocal;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class MyApartments
 */
@WebServlet("/ApartmentSubscribers")
public class ApartmentSubscribers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	ApartmentServiceLocal apartmentService;

	public ApartmentSubscribers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("ApartmentKey") != null) {

			String apartmentId = request.getParameter("ApartmentKey").toString();

			ArrayList<Student> studentList = apartmentService.getApartmentSubscribers(apartmentId);
			request.setAttribute("studentList", studentList);

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ApartmentSubscribers.jsp");
			view.forward(request, response);

			response.getWriter().append("Served at: ").append(request.getContextPath());
		}else{
			response.getWriter().write("Illegal apartment key");
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
