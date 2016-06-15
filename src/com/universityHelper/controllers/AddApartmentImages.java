package com.universityHelper.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class AddApartmentImages
 */
@WebServlet("/AddApartmentImages")
public class AddApartmentImages extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddApartmentImages() {
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
		String apartmentKey = request.getParameter("ApartmentId");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/AddApartmentImages.jsp");
		request.setAttribute("ApartmentId", apartmentKey);
		request.setAttribute("address", address);
		request.setAttribute("name", name);
		view.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String apartmentId = null;

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
		} else {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			Iterator itr = items.iterator();
			String folder = apartmentId;
			int i=0;
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();

				
				// String relativeWebPath = "/WEB-INF/uploads/" + folder;
				
				
				if (item.isFormField()) {
					String value = item.getString();
					if (item.getFieldName().equals("ApartmentId")) {
						folder = value;
						
					}

				} else {
					try {
						String itemName = item.getName();

						//"F:\\uploads\\"+folder
						ServletContext context = getServletContext();
						String absoluteFilePath = context.getRealPath("/resources/uploads/apartment/" + folder);
						//String absoluteFilePath =request.getContextPath()+ folder;
						File directory = new File(absoluteFilePath);
						directory.mkdirs();

						
						File uploadedFile = new File(absoluteFilePath,"img"+(i++)+".jpg");
						// uploadedFile.getParentFile().mkdirs();
						item.write(uploadedFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			response.sendRedirect("LLHome");
		}

	}
}
