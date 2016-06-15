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
 * Servlet implementation class ApartmentComments
 */
@WebServlet("/ViewApartmentComments")
public class ViewApartmentComments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	ApartmentServiceLocal apartmentService;

	public ViewApartmentComments() {
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

		String apartmentId = request.getParameter("apartmentKey");
		String apartmentName = request.getParameter("apartmentName");
		String address = request.getParameter("address");

		if (apartmentId != null && apartmentName != null && address != null) {
			ArrayList<ApartmentComment> commentsList = apartmentService.getApartmentComments(apartmentId);

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ApartmentComments.jsp");
			request.setAttribute("commentsList", commentsList);
			request.setAttribute("apartmentKey", apartmentId);
			request.setAttribute("apartmentName", apartmentName);
			request.setAttribute("address", address);

			view.forward(request, response);
		} else {
			response.getWriter().write("Illegal apartment id");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String commentId = request.getParameter("commentId");
		boolean deleted = apartmentService.deleteComment(commentId);

		String apartmentId = request.getParameter("apartmentKey");
		String apartmentName = request.getParameter("apartmentName");
		String address = request.getParameter("address");
		System.out.println(apartmentId);
		ArrayList<ApartmentComment> commentsList = apartmentService.getApartmentComments(apartmentId);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ApartmentComments.jsp");
		request.setAttribute("commentsList", commentsList);
		request.setAttribute("apartmentKey", apartmentId);
		request.setAttribute("apartmentName", apartmentName);
		request.setAttribute("address", address);

		view.forward(request, response);

	}

}
