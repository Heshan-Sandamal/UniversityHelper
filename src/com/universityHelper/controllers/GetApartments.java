package com.universityHelper.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.services.ApartmentServiceLocal;

/**
 * Servlet implementation class GetApartments
 */
@WebServlet("/GetApartments")
public class GetApartments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	// Inject ApartmentService to servlet
	@EJB
	private ApartmentServiceLocal apartmentService;

	public GetApartments() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get apartments list from apartment service bean

		if (request.getParameter("university") != null) {
			String universityName = request.getParameter("university");

			JsonObject jsonObject = apartmentService.getApartmentList(universityName);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("Json i" + jsonObject);
			// send Json object to front end view
			PrintWriter pr = response.getWriter();
			pr.print(jsonObject);
			pr.flush();
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
