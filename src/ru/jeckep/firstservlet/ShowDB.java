package ru.jeckep.firstservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDB
 */
@WebServlet("/ShowDB")
public class ShowDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs=null;
		try {

			conn = DriverManager.getConnection("jdbc:derby:Company;create=true");
			stmt = conn.createStatement();
			String sqlQuery = "SELECT * from Employee";
			rs = stmt.executeQuery(sqlQuery);
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			while (rs.next()) {
				out.println("" + rs.getInt("EMPNO") + ", " + rs.getString("ENAME") + ", " + rs.getString("JOB_TITLE") + "<br>");
			}
			out.println("</body></html>");
		

		} catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: "
					+ se.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				rs.close();
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
