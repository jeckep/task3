package ru.jeckep.firstservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDB
 */
@WebServlet("/UpdateDB")
public class UpdateDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		try {

			conn = DriverManager.getConnection("jdbc:derby:Company;create=true");
			stmt = conn.createStatement();
			
			String strAddEmployee = "INSERT INTO Employee values (" + request.getParameter("EMPNO") + ",'" + request.getParameter("ENAME") + "','" + request.getParameter("JOB_TITLE") +"')";
			System.out.println(strAddEmployee);
			stmt.executeUpdate(strAddEmployee);

		

		} catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: "
					+ se.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
