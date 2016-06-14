package com.universityHelper.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.services.ApartmentServiceLocal;

import sun.misc.FloatingDecimal;

/**
 * Servlet implementation class AddRatings
 */
@WebServlet("/AddRatings")
public class AddRatings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	private ApartmentServiceLocal apartmentService;
	
    public AddRatings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String studentId=request.getSession().getAttribute("StudentId").toString();
		String apartmentId=request.getParameter("apartmentKey");
		Double rating=FloatingDecimal.parseDouble(request.getParameter("rating"));
		
		boolean ratedSuccess=apartmentService.addRatings(studentId,apartmentId,rating);
		response.getWriter().write("You rated the apartment "+ratedSuccess);
//		
//		RequestDispatcher view=request.getRequestDispatcher("ViewApartmentDetails");
//		request.setAttribute("rateStatus", ratedSuccess);
//		view.forward(request, response);
		
	}

}
