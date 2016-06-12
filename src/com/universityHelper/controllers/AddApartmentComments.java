package com.universityHelper.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.ApartmentComment;
import com.universityHelper.services.ApartmentServiceLocal;

/**
 * Servlet implementation class AddApartmentComments
 */
@WebServlet("/AddApartmentComments")
public class AddApartmentComments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	ApartmentServiceLocal apartmentService;

	public AddApartmentComments() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String apartmentId = request.getParameter("apartmentKey");
		String studentId = request.getSession().getAttribute("StudentId").toString();
		String description = request.getParameter("comment");

		ApartmentComment acm = new ApartmentComment();
		acm.setDescription(description);
		// acm.setApartment(apartmentId);
		acm.setDateAndTime(new Date());

		boolean added = apartmentService.addComment(acm, apartmentId, studentId);
		System.out.println("apartment comment added " + added);

		ArrayList<ApartmentComment> commentsList = apartmentService.getApartmentComments(apartmentId);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ApartmentComments.jsp");
		request.setAttribute("commentsList", commentsList);
		view.forward(request, response);
	}

}
