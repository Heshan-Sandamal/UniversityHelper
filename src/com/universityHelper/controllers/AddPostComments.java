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
import com.universityHelper.models.Comment;
import com.universityHelper.services.PostServiceLocal;

/**
 * Servlet implementation class AddPostComments
 */
@WebServlet("/AddPostComments")
public class AddPostComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	PostServiceLocal postService;
	
    public AddPostComments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		//RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ApartmentComments.jsp");
		//request.setAttribute("commentsList", commentsList);
		//view.forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postId = request.getParameter("postId");
		String studentId = request.getSession().getAttribute("StudentId").toString();
		String description = request.getParameter("comment");

		Comment acm = new Comment();
		acm.setContent(description);
		// acm.setApartment(apartmentId);
		acm.setTimeStamp(new Date());

		boolean added = postService.addComment(acm, postId, studentId);
		System.out.println(" comment added " + added);
		
		request.getSession().setAttribute("postId", postId);
		response.sendRedirect("ViewPostDetails");
		

	}

}
