package com.universityHelper.controllers;

import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.universityHelper.services.LandLordService;
import com.universityHelper.services.LandLordServiceLocal;
import com.universityHelper.services.StudentServiceLocal;

/**
 * Servlet implementation class StudentSignUp
 */
@WebServlet("/UpdateLandLordDetails")
public class UpdateLandLordDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	LandLordServiceLocal landLordService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateLandLordDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LandLord landLord = landLordService
				.getLandLord(request.getSession().getAttribute("ApartmentOwnerId").toString());
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/UpdateLandLordDetails.jsp");
		
		landLord.getLandLordProfile().setPassword(Encrypt.readEncrypt(landLord.getLandLordProfile().getPassword()));
		
		request.setAttribute("landLord", landLord);
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
		LandLordProfile llp = new LandLordProfile();
		llp.setUserName(request.getParameter("userName"));
		llp.setPassword(Encrypt.WriteEncrypt(request.getParameter("password")));

		LandLord landLord = new LandLord();
		landLord.setLandLordId(request.getSession().getAttribute("ApartmentOwnerId").toString());
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

		boolean updated = landLordService.updateLandLord(landLord, llp);

		if (updated) {
			response.sendRedirect("LLHome");
		} else {
			response.getWriter().write("Unable to updated details.");
		}

		// response.getWriter().write("sighUp");
	}
}
