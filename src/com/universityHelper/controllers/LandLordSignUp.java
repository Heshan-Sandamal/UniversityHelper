package com.universityHelper.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.LandLord;
import com.universityHelper.models.LandLordProfile;
import com.universityHelper.models.Student;
import com.universityHelper.models.StudentProfile;
import com.universityHelper.other.Encrypt;
import com.universityHelper.services.LandLordServiceLocal;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class StudentSignUp
 */
@WebServlet("/LandLordSignUp")
public class LandLordSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	LandLordServiceLocal landLordService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LandLordSignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/LandLordSignUp.jsp");
		view.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		LandLordProfile llp = new LandLordProfile();
		llp.setUserName(request.getParameter("userName"));
		llp.setPassword(Encrypt.WriteEncrypt(request.getParameter("password")));

		LandLord landLord = new LandLord();
		landLord.setFirstName(request.getParameter("firstName"));
		landLord.setLastName(request.getParameter("lastName"));
		landLord.setAddress(request.getParameter("address"));
		landLord.setEmail(request.getParameter("email"));

		Set<String> contactNoList = new HashSet<String>();

		String contactNo1 = request.getParameter("contactNo1");
		String contactNo2 = request.getParameter("contactNo2");

		if (!contactNo1.isEmpty()) {
			contactNoList.add(contactNo1);
		}

		if (!contactNo2.isEmpty()) {
			contactNoList.add(contactNo2);
		}

		landLord.setContactNoList(contactNoList);

		llp.setLandLord(landLord);
		landLord.setLandLordProfile(llp);

		boolean added = landLordService.addLandLord(landLord, llp);
		if (!added) {
			response.getWriter().write("User Name Already exists");
		}else{
			PrintWriter out = response.getWriter();

		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Registered</title>");
		    out.println("</head>");
		    out.println("<body bgcolor=\"white\">");
		    out.println("<h2>You successfully registered.Please logIn<h2/>");
		    out.println("<a href='LLLogIn'><h4>Log In</h4></a>");
		    out.println("</body>");
		    out.println("</html>");
		    
				
		}

	}

}
