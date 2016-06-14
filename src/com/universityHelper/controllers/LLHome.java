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
import com.universityHelper.models.LandLord;
import com.universityHelper.models.Student;
import com.universityHelper.services.ApartmentServiceLocal;
import com.universityHelper.services.LandLordService;
import com.universityHelper.services.LandLordServiceLocal;
import com.universityHelper.services.StudentServiceLocal;

import jdk.nashorn.internal.runtime.Context;

/**
 * Servlet implementation class LLHome
 */
@WebServlet("/LLHome")
public class LLHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	LandLordServiceLocal landLordService;

	@EJB
	StudentServiceLocal studentService;

	public LLHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("ApartmentOwnerId") != null) {
			
			String apartmentOwnerId =request.getSession().getAttribute("ApartmentOwnerId").toString();
			
			LandLord landLord=landLordService.getLandLord(apartmentOwnerId);
			
			request.setAttribute("landLord", landLord);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/LLHome.jsp");
			view.forward(request, response);
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
