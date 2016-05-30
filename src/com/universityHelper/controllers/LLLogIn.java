package com.universityHelper.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Apartment;
import com.universityHelper.models.LandLord;
import com.universityHelper.models.LandLordProfile;
import com.universityHelper.services.LandLordServiceLocal;

import jdk.nashorn.internal.runtime.Context;

/**
 * Servlet implementation class LLsignUp
 */
@WebServlet("/LLLogIn")
public class LLLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@EJB
	LandLordServiceLocal landLordService;

	public LLLogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		LandLord l=new LandLord();
//		l.setName("heshan");
//		l.addContactNo("12121sd");
//		l.addContactNo("12121s1d");
//		l.addContactNo("12121sd2");
//		l.addContactNo("12121s21d");
//		l.addContactNo("12121svvd");
//		
//		String name=landLordService.addLandLord(l);
//		
//		response.getWriter().print(name);
		
		
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/LLLogIn.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		boolean logIn = landLordService.logIn(new LandLordProfile(){{setPassword(password);setUserName(userName);}});
		
		if(logIn){
			response.sendRedirect("LLHome");
			//request.
			
			
		}else{
			request.setAttribute("error", "wrong info");
			request.getRequestDispatcher("WEB-INF/views/LLLogIn.jsp").forward(request, response);
		}
		
		//doGet(request, response);
	}

}
