package com.universityHelper.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.universityHelper.models.Apartment;
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
	
	//Inject ApartmentService to servlet
	@EJB
	private ApartmentServiceLocal apartmentService;
	
    public GetApartments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	    
		//get apartments list from apartment service bean
	    List<Apartment> apatmentList=apartmentService.getApartmentList();
	    
	    //convert java object to Json
	    //{{name:"apt1",address:"Moratuwa"},{},{},{}}
	    String json = new Gson().toJson(apatmentList);
	    
	    //set response's headers 
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    //send Json object to front end view
	    response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
