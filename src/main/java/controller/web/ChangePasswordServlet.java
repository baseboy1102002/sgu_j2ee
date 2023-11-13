package controller.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/doi-password")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String inputOldPassword = request.getParameter("inputOldPassword");
		String inputNewPassword_1 = request.getParameter("inputNewPassword_1");
		String inputNewPassword_2 = request.getParameter("inputNewPassword_2");
		
		// JDBC connection
		Connection conn = null;
		PreparedStatement updateStatement = null;
		ResultSet rs = null;
		boolean wrongPassword_2 = !inputNewPassword_1.equals(inputNewPassword_2); // Compare passwords
		boolean wrongPassword_1 = !inputOldPassword.equals(SessionManager.getPassword(request)); // Compare passwords
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "");

			if (wrongPassword_1 == false && wrongPassword_2 == false) {
				String updateQuery = "UPDATE nguoidung SET MatKhau = ? WHERE Email = ?";
	            updateStatement = conn.prepareStatement(updateQuery);
	            updateStatement.setString(1, inputNewPassword_1);
	            updateStatement.setString(2, SessionManager.getEmail(request));

	            int rowsUpdated = updateStatement.executeUpdate();
	           
	            if (rowsUpdated > 0) {
	            	SessionManager.setPassword(request, inputNewPassword_1);
	                System.out.println("Password changed: Email=" + SessionManager.getEmail(request) + ", Password=" + SessionManager.getPassword(request));
	    		    request.setAttribute("changePasswordStatus", "success");
	    		    EmailSender.sendChangedPassword(SessionManager.getEmail(request), SessionManager.getName(request), inputNewPassword_1);
	            } else {
	                System.out.println("failed changing password");
	            }
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		// Perform the redirection outside the try-catch block
		if (wrongPassword_1) {
			System.out.println("Wrong password");
		    request.setAttribute("changePasswordStatus", "wrong");
		}
			
		else if (wrongPassword_2) {
			System.out.println("Password not similar");
		    request.setAttribute("changePasswordStatus", "not_similar");
		} 
		request.getRequestDispatcher("views/ChangePassword.jsp").forward(request, response);
	}

}
