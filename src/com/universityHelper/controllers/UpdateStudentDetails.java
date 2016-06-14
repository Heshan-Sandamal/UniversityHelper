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
@WebServlet("/UpdateStudentDetails")
public class UpdateStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	StudentServiceLocal studentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = studentService.getStudentDetails(request.getSession().getAttribute("StudentId").toString());
		student.getStudentProfile().setPassword(Encrypt.readEncrypt(student.getStudentProfile().getPassword()));

//		SimpleDateFormat readFormat = new SimpleDateFormat("EEE MMM dd yyyy hh:mm aaa");
//		Date birthday = null;
//		
//		birthday=student.getDob();
//		
//		
//		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
//		Date date=null;
//		try {
//			date = (Date)formatter.parse(birthday.toString());
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println(date);        
//
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		String formatedDate = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE) + "/" +         cal.get(Calendar.YEAR);
//		System.out.println("formatedDate : " + formatedDate); 
//		
//		
//		
//
//		DateFormat writeFormat = new SimpleDateFormat("MM/dd/yyyy");
//		
//		
//		try {
//			birthday = writeFormat.parse(formatedDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("FOramtted date "+birthday);
//student.setDob(birthday );

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/UpdateStudentDetails.jsp");
		request.setAttribute("student", student);
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
		s.setStudentId(request.getSession().getAttribute("StudentId").toString());
		s.setFirstName(request.getParameter("firstName"));
		s.setLastName(request.getParameter("lastName"));

		System.out.print(request.getParameter("birthday"));
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
		Date birthday = null;
		try {
			birthday = dt.parse(request.getParameter("birthday"));
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

		System.out.println("uni is" + request.getParameter("university"));

		StudentProfile sp = new StudentProfile();
		sp.setUserName(request.getParameter("userName"));

		sp.setPassword(Encrypt.WriteEncrypt(request.getParameter("password")));

		sp.setStudent(s);

		s.setStudentProfile(sp);

		studentService.updateStudentDetails(sp, s);

	}

}
