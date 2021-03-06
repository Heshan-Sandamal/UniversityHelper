package com.universityHelper.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.services.ApartmentServiceLocal;
import com.universityHelper.services.PostServiceLocal;

/**
 * Servlet implementation class DeletePost
 */
@WebServlet("/DeleteApartment")
public class DeleteApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteApartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@EJB
	ApartmentServiceLocal apartmentService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String apartmentId = request.getParameter("ApartmentId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		boolean deleted = apartmentService.deleteApartment(apartmentId, userName, password);
		if (deleted) {
			response.sendRedirect("LLHome");
		} else {
			response.getWriter().write("Unable to Delete");
		}

	}

}
