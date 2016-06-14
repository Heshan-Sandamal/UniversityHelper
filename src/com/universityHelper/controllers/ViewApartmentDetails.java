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
import com.universityHelper.models.Student;
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get apartment key from view
		String apartmentKey = request.getParameter("apartmentKey");
		
		if(apartmentKey==null){
			apartmentKey=request.getSession().getAttribute("ApartmentKey").toString();
			request.getSession().removeAttribute("ApartmentKey");
		}

		// get specific apartment details
		Apartment apartment = apartmentService.getApartmentDetails(apartmentKey);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ApartmentDetails.jsp");

		request.setAttribute("apartment", apartment);

		if (request.getSession().getAttribute("StudentId") != null) {
			if (apartment.getStudentSubscribers().contains(new Student() {
				{
					setStudentId(request.getSession().getAttribute("StudentId").toString());
				}
			})) {
				request.setAttribute("subscribeStatus", "You are already subscribing");
			}else{
				request.setAttribute("subscribeStatus", "Subscribe");
			}
		}else{
			request.setAttribute("subscribeStatus", "Subscribe");
		}

		// set apartment details as attributes of request
		// request.setAttribute("apartmentName", apartment.getName());
		// request.setAttribute("lattitude", apartment.getLattitide());
		// request.setAttribute("longitude", apartment.getLongitude());
		// request.setAttribute("address", apartment.getAddress());
		// request.setAttribute("availability",apartment.getAvilablePlaces());
		// request.setAttribute("payment", apartment.getPayment());
		// request.setAttribute("apartmentKey", apartment.getApartmentKey());
		// request.setAttribute("rate", apartment.getRate());
		// request.setAttribute("apartmentOwnerId",
		// apartment.getLandLordId().getLandLordId());

		// forward request to view
		view.forward(request, response);
	}

}
