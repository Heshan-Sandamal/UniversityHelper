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
@WebServlet("/DiscussionThread")
public class DiscussionThread extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	PostServiceLocal postService;
	
    public DiscussionThread() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Post> postList=postService.getAllPosts();
		request.setAttribute("postList", postList);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/DiscussionThread.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
