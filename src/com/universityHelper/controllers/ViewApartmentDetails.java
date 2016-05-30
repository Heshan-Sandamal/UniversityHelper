package com.universityHelper.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Apartment;
import com.universityHelper.services.ApartmentServiceLocal;

/**
 * Servlet implementation class ViewApartmentDetails
 */
@WebServlet("/ViewApartmentDetails")
public class ViewApartmentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@EJB
	private ApartmentServiceLocal apartmentService;

	public ViewApartmentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ApartmentDetails.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get apartment key from view
		String apartmentKey=request.getParameter("apartmentKey");
		
		//get specific apartment details
		Apartment apartment=apartmentService.getApartmentDetails(apartmentKey);
		
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/ApartmentDetails.jsp");
		
		//set apartment details as attributes of request
		request.setAttribute("apartmentKey", apartment.getName());
		request.setAttribute("lattitude", apartment.getLattitide());
		request.setAttribute("longitude", apartment.getLongitude());
		request.setAttribute("address", apartment.getAddress());
		request.setAttribute("availability",apartment.getAvilablePlaces());
		request.setAttribute("payment", apartment.getPayment());
		
		//forward request to view
		view.forward(request, response);
	}

}
