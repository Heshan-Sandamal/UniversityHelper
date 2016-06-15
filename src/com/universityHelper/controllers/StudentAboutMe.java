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
import com.universityHelper.services.PostServiceLocal;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/StudentAboutMe")
public class StudentAboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	StudentServiceLocal studentService;
	
    public StudentAboutMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/StudentAboutMe.jsp");

		view.forward(request, response);
		
		
		//response.getWriter().append("Served at: added"+added+" ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String studentId=request.getSession().getAttribute("StudentId").toString();
		String content=request.getParameter("content");
		
		
		boolean added=studentService.updateAboutMe(studentId,content);
		response.sendRedirect("StudentHome");
	}

}
