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
 * Servlet implementation class CreateDB
 */
@WebServlet("/CreateDB")
public class CreateDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDB() {
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
			//Create tables
			String strACreateTable = "CREATE TABLE Employee ( EMPNO int NOT NULL, ENAME varchar (50) NOT NULL, JOB_TITLE varchar (150) NOT NULL )";
			String strAddEmployee = "INSERT INTO Employee values (7369,'John Smith', 'Clerk'), (7499,'Joe Allen','Salesman'), (7521,'Mary Lou','Director')";
			
			stmt.executeUpdate(strACreateTable);
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
