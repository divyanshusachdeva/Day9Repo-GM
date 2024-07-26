package com.graymatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		Connection con = null;
		PreparedStatement ps = null;
		RequestDispatcher dispatcher;
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");

        String query = "SELECT * FROM user WHERE username = ? AND userpass = ?";
        
        EmployeeDataSource eds = new EmployeeDataSource();
		try {
			con = eds.getConnection();
			ps = con.prepareStatement(query);

	            ps.setString(1, username);
	            ps.setString(2, userpass);
	            //ps.executeUpdate();

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                
	            	out.print("Successful login");
	            }
	            	else {
	                out.print("Invalid username or password.");
	            }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		response.setContentType("text/html");
//		Connection con = null;
//		PreparedStatement ps = null;
//		
//		PrintWriter out = response.getWriter();
//		
//		String username = request.getParameter("username");
//        String userpass = request.getParameter("userpass");
//
//        String query = "SELECT * FROM user WHERE username = ? AND userpass = ?";
//        
//        EmployeeDataSource eds = new EmployeeDataSource();
//		try {
//			con = eds.getConnection();
//			ps = con.prepareStatement(query);
//
//	            ps.setString(1, username);
//	            ps.setString(2, userpass);
//
//	            ResultSet rs = ps.executeQuery();
//
//	            if (rs.next()) {
//	                
//	            	out.print("Successful login");
//	            }
//	            	else {
//	                out.print("Invalid username or password.");
//	            }
//			
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

}
