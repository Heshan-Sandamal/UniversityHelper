package com.universityHelper.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

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
 * Servlet implementation class AddPost
 */
@WebServlet("/UpdatePost")
public class UpdatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	PostServiceLocal postService;
	
    public UpdatePost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String postId=request.getParameter("postId");
		Post post=postService.viewPostDetails(postId);
		request.setAttribute("post", post);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/UpdatePost.jsp");

		view.forward(request, response);
		
		
		//response.getWriter().append("Served at: added"+added+" ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Post post=new Post();
		String studentId=request.getSession().getAttribute("StudentId").toString();
		post.setId(request.getParameter("postId").toString());
		post.setTopic(request.getParameter("topic").toString());
		post.setContent(request.getParameter("content").toString());
		post.setDateTime(new Date());
		
		boolean added=postService.updatePost(studentId,post);
		response.sendRedirect("ViewMyPosts");
	}

}