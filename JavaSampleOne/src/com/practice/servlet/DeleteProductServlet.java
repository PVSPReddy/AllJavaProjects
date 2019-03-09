package com.practice.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

import java.sql.Connection;
import java.sql.SQLException;

import com.practice.utils.MyUtils;
import com.practice.utils.DBUtils;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Default
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Tutorial
		 Connection conn = MyUtils.getStoredConnection(request);
		 
	        String code = (String) request.getParameter("code");
	 
	        String errorString = null;
	 
	        try {
	            DBUtils.deleteProduct(conn, code);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        } 
	         
	        // If has an error, redirecte to the error page.
	        if (errorString != null) {
	            // Store the information in the request attribute, before forward to views.
	            request.setAttribute("errorString", errorString);
	            // 
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
	            dispatcher.forward(request, response);
	        }
	        // If everything nice.
	        // Redirect to the product listing page.        
	        else {
	            response.sendRedirect(request.getContextPath() + "/productList");
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
