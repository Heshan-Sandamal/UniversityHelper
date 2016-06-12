package com.universityHelper.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.University;
import com.universityHelper.services.UniversityServiceLocal;

import sun.misc.FloatingDecimal;

/**
 * Servlet implementation class AddUniversity
 */
@WebServlet("/AddUniversity")
public class AddUniversity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	UniversityServiceLocal universityService;

	public AddUniversity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// send AddApartment interface to view layer
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/AddUniversity.jsp");
		view.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String universityName=request.getParameter("university_name");
		String address=request.getParameter("address");
		double lattitude=FloatingDecimal.parseDouble(request.getParameter("lattitude"));
		double longitude=FloatingDecimal.parseDouble(request.getParameter("longitude"));

		University university = new University();
		university.setName(universityName);
		university.setAddress(address);
		university.setLattitude(lattitude);
		university.setLongitude(longitude);

		boolean added=universityService.addUniversity(university);
		
		if(added){
			response.getWriter().append("Added Successfully");
		}else{
			response.getWriter().append("Error occured during inserting");
		}
		
	//	doGet(request, response);
	}

}
