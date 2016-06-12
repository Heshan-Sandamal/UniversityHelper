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
import com.universityHelper.services.UniversityServiceLocal;

/**
 * Servlet implementation class SearchApartment
 */
@WebServlet("/SearchApartment")
public class SearchApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	@EJB
	UniversityServiceLocal universitySerivce;
	
    public SearchApartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setAttribute("UniversityList",universitySerivce.getAllUniversityNames());
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/SearchApartment.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
