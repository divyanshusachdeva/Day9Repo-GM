package com.graymatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserInfoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		Connection con = null;
		PreparedStatement ps = null;
		
		PrintWriter out = response.getWriter();
		out.print("Welcome!");
	
		EmployeeDataSource eds = new EmployeeDataSource();
		try {
			con = eds.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	out.print("\nConnection Established!");	
	
	String userid = request.getParameter("userid");
	String mobno = request.getParameter("mobno");
	String email = request.getParameter("email");
	String username = request.getParameter("username");
	String userpass = request.getParameter("userpass");
	
	String query1 = "INSERT INTO user VALUES (?,?,?,?,?)";
	
	
	try {
		ps = con.prepareStatement(query1);
		
		ps.setInt(1, Integer.parseInt(userid));
		ps.setString(2, username);
		ps.setString(3, email);
		ps.setString(4, userpass);
		ps.setString(5, mobno);
		
		ps.executeUpdate();
	} catch (NumberFormatException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	out.print("The user has been registered!");
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
