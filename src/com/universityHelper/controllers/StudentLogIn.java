package com.universityHelper.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.other.Encrypt;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class StudentLogIn
 */
@WebServlet("/StudentLogIn")
public class StudentLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	StudentServiceLocal studentService;

	public StudentLogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/StudentLogIn.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		
		
		System.out.println("Encrypt one :"+Encrypt.WriteEncrypt(password));
		
		String studentId=studentService.logInStudent(userName, password);
		
		if (studentId==null) {
			request.setAttribute("error", "User Name not exists");
			request.getRequestDispatcher("WEB-INF/views/StudentLogIn.jsp").forward(request, response);
		}else if(studentId.equals("WP")){
			request.setAttribute("error", "Password Mismatch");
			request.getRequestDispatcher("WEB-INF/views/StudentLogIn.jsp").forward(request, response);
			
		}else{
			request.logout();
			request.login("Student", "12345");
			response.sendRedirect("StudentHome");
			request.getSession().setAttribute("StudentId",studentId);	
		}

		// doGet(request, response);
	}

}
