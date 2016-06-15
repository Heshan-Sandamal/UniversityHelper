package com.universityHelper.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Post;
import com.universityHelper.services.LandLordServiceLocal;
import com.universityHelper.services.PostServiceLocal;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/LandLordAboutMe")
public class LandLordAboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	LandLordServiceLocal landLordService;
	
    public LandLordAboutMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/LandLordAboutMe.jsp");

		view.forward(request, response);
		
		
		//response.getWriter().append("Served at: added"+added+" ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ownerId=request.getSession().getAttribute("ApartmentOwnerId").toString();
		String content=request.getParameter("content");
		
		
		boolean added=landLordService.updateAboutMe(ownerId,content);
		response.sendRedirect("LLHome");
	}

}
