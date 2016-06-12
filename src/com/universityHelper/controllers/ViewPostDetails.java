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
import javax.servlet.http.HttpSession;

import com.universityHelper.models.ApartmentComment;
import com.universityHelper.models.Post;
import com.universityHelper.services.PostServiceLocal;

/**
 * Servlet implementation class ViewPostDetails
 */
@WebServlet("/ViewPostDetails")
public class ViewPostDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	PostServiceLocal postService;
	
    public ViewPostDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String postId;//request.getParameter("postId");
		if(request.getParameter("postId")==null){
			HttpSession curSession=request.getSession();
			postId=curSession.getAttribute("postId").toString();
			curSession.removeAttribute("postId");
		}else{
			postId=request.getParameter("postId");
		}
		Post post=postService.viewPostDetails(postId);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ViewPostDetails.jsp");
		request.setAttribute("post", post);
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
