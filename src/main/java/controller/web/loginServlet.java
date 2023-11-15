package controller.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.web.SessionManager;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet({ "/dang-nhap" })
public class loginServlet extends HttpServlet {
       
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//logout
        HttpSession session = request.getSession();
        session.invalidate();
        
		String inputEmail = request.getParameter("inputEmail");
		String inputPassword = request.getParameter("inputPassword");
		String checkRemember = request.getParameter("checkRemember");
		String userName = null, userConfirmCode = null, userPhone = null, userAvatar = null;
		Date userDoB = null; 
		int userID = 0;
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
		        userDoB = rs.getDate("NgaySinh");
		        userID = rs.getInt("MaNguoiDung");
		        userAvatar = rs.getString("HinhDaiDien");
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
		    SessionManager.storeUserInfo(request, inputEmail, inputPassword, userName, userConfirmCode, userPhone, userDoB, userID, userAvatar);
		    System.out.println("ok");
		    
		    // Redirect to a different page (e.g., home page)
		    if (SessionManager.getConfirmCode(request).equals("confirmed!") ) {
		    	response.sendRedirect(request.getContextPath() + "/views/Home.jsp"); 
			    return;
		    }
		    else {
		    	response.sendRedirect(request.getContextPath() + "/views/Confirm_Account.jsp"); 
    		    return;
            }
		} else {
			request.setAttribute("loginStatus", "failed");
		    System.out.println("login failed");
            request.getRequestDispatcher("/views/Index.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
