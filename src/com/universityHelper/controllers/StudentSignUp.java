package com.universityHelper.controllers;

import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Student;
import com.universityHelper.models.StudentProfile;
import com.universityHelper.other.Encrypt;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class StudentSignUp
 */
@WebServlet("/StudentSignUp")
public class StudentSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	StudentServiceLocal studentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentSignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/StudentSignUp.jsp");
		view.forward(request, response);

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student s = new Student();
		s.setFirstName(request.getParameter("firstName"));
		s.setLastName(request.getParameter("lastName"));
		
		
		System.out.print(request.getParameter("birthday"));
		SimpleDateFormat dt=new SimpleDateFormat("yyyy-mm-dd");
		Date birthday = null;
		try {
			birthday=dt.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s.setDob(birthday);
		
		s.setHomeTown(request.getParameter("address"));
		s.setContactNo(request.getParameter("contactNo"));
		s.setFburl(request.getParameter("fburl"));
		
		s.setEmail(request.getParameter("email"));
		s.setExamYear(Integer.valueOf(request.getParameter("examYear")));
		
		System.out.println("uni is"+request.getParameter("university"));

		StudentProfile sp = new StudentProfile();
		sp.setUserName(request.getParameter("userName"));
		
		

		sp.setPassword(Encrypt.WriteEncrypt(request.getParameter("password")));

		sp.setStudent(s);

		s.setStudentProfile(sp);
		
		

		studentService.signUpStudent(sp, s);

	}

}
