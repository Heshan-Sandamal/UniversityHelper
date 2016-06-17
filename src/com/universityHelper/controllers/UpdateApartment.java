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
import com.universityHelper.services.UniversityServiceLocal;

import sun.misc.FloatingDecimal;

/**
 * Servlet implementation class LLsignUp
 */
@WebServlet("/UpdateApartment")
public class UpdateApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	// Inject ApartmentService to servlet
	@EJB
	ApartmentServiceLocal apartmentService;

	@EJB
	UniversityServiceLocal universityService;

	public UpdateApartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("ApartmentId") != null) {
			String apartmentId = request.getParameter("ApartmentId");

			Apartment apartment = apartmentService.getApartmentDetailsForUpdate(apartmentId);

			// send AddApartment interface to view layer
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/UpdateApartment.jsp");

			request.setAttribute("UniversityList", universityService.getAllUniversities());
			request.setAttribute("apartment", apartment);

			view.forward(request, response);
		}else{
			response.getWriter().write("Illegal apartment id");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Object apartmentOwnerId = request.getSession().getAttribute("ApartmentOwnerId");

		if (apartmentOwnerId != null) {
			// get details from front end

			String apartmentKey = request.getParameter("apartmentKey");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			double lattitude = FloatingDecimal.parseDouble(request.getParameter("lattitude"));
			double longitude = FloatingDecimal.parseDouble(request.getParameter("longitude"));
			double payment = FloatingDecimal.parseDouble(request.getParameter("payment"));
			int avilablePlaces = Integer.parseInt(request.getParameter("availability"));
			String university = request.getParameter("university");
			String studentSex = request.getParameter("studentSex");
			String[] universityList = request.getParameterValues("univesities");

			System.out.println(studentSex);

			// create Apartment object using submitted details
			Apartment ap = new Apartment();

			// set longitude and lattitude
			ap.setLattitide(lattitude);
			ap.setLongitude(longitude);
			ap.setApartmentKey(apartmentKey);

			ap.setName(name); // set Apartment Name
			ap.setAvilablePlaces(avilablePlaces); // set availablePlaces
			ap.setAddress(address); // set address
			ap.setPayment(payment); // set payment
			ap.setRate(0.0);
			ap.setStudentSex(studentSex);

			// send apartment object to apartment service bean to persists
			boolean aptStatus = apartmentService.updateApartment(ap, universityList);
			// Assert.assertTrue(aptStatus);

			// ap.getUniversity().add(arg0)

			if (aptStatus) {
				response.sendRedirect("LLHome");
			} else {
				response.getWriter().println("Unable to update details");
			}
		}

	}

}
