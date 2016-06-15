package com.universityHelper.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.universityHelper.models.Post;
import com.universityHelper.services.PostServiceLocal;

/**
 * Servlet implementation class DiscussionThread
 */
@WebServlet("/ViewMyPosts")
public class ViewMyPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@EJB
	PostServiceLocal postService;

	public ViewMyPosts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentId = request.getSession().getAttribute("StudentId").toString();

		ArrayList<Post> postList = postService.getPostsOfStudent(studentId);
		request.setAttribute("postList", postList);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/MyPosts.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchVal=request.getParameter("searchVal");
		String studentId = request.getSession().getAttribute("StudentId").toString();
		ArrayList<Post> postList=postService.searchPostsOfStudent(studentId,searchVal);
		request.setAttribute("postList", postList);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/MyPosts.jsp");
		view.forward(request, response);
	}

}
