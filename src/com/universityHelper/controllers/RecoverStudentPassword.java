package com.universityHelper.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Student;
import com.universityHelper.other.Encrypt;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/RecoverStudentPassword")
public class RecoverStudentPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	StudentServiceLocal studentService;

	public RecoverStudentPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("userName") != null) {
			String userName = request.getParameter("userName");
			Student student = studentService.getStudentProfileDetails(userName);

			String recoveryToken = Encrypt.readEncrypt(student.getStudentProfile().getPassword());
			String email = student.getEmail();
			com.universityHelper.other.SendEmail.sendMailTO(email, recoveryToken);
			response.getWriter().write("Password has been sent to " + email);
		}else{
			response.getWriter().write("Illegal userName");
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