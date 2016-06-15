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
import com.universityHelper.models.Student;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class MyApartments
 */
@WebServlet("/MyApartments")
public class MyApartments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	StudentServiceLocal studentService;
	
    public MyApartments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String studentId = request.getSession().getAttribute("StudentId").toString();

		ArrayList<Apartment> studentList = studentService.getMyApartments(studentId);
		request.setAttribute("apartmentList", studentList);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/MyApartments.jsp");
		view.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String studentId = request.getSession().getAttribute("StudentId").toString();
		String apartmentId=request.getParameter("apartmentKey");
		boolean updated=studentService.unsubscribeApartment(studentId,apartmentId);
		
		if(updated){
			doGet(request, response);
		}else{
			response.getWriter().write("Unable to unsubscribe");
		}
		
	}

}
