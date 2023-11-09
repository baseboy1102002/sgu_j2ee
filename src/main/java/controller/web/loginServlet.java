package controller.web;

import java.io.IOException;
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
import controller.web.SessionManager;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet({ "/dang-nhap" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/Index.jsp").forward(request, response);
		request.setCharacterEncoding("utf-8");
		String inputEmail = request.getParameter("inputEmail");
		String inputPassword = request.getParameter("inputPassword");
		String checkRemember = request.getParameter("checkRemember");
		String userName = null, userConfirmCode = null, userPhone = null;
		//JDBC connection
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean userExists = false;
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "");
		    st = conn.createStatement();
		    String query = "select * from nguoidung where Email = '" + inputEmail + "' and MatKhau = '" + inputPassword + "'";
		    rs = st.executeQuery(query);
		    if (rs.next()) {
		        userExists = true;
		        userName = rs.getString("HoVaTen");
		        userConfirmCode = rs.getString("MaXacNhan");
		        userPhone = rs.getString("SoDienThoai");
		    }
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // Close resources in a finally block
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    if (st != null) {
		        try {
		            st.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}

		// Perform the redirection outside the try-catch block
		if (userExists) {
		    // Store user information in session
		    SessionManager.storeUserInfo(request, inputEmail, inputPassword, userName, userConfirmCode, userPhone); // Replace userID with the actual user ID

		    // Redirect to a different page (e.g., home page)
		    response.sendRedirect("views/Home.jsp"); // Replace with your desired page
		} else {
		    System.out.println("not ok");
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
