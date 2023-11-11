package controller.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet({ "/dang-ky" })
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public signupServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String inputEmail = request.getParameter("inputEmail");
		String inputPassword = request.getParameter("inputPassword");
		String inputName = request.getParameter("inputName");
		String inputCheckPassword = request.getParameter("inputCheckPassword");
		String confirmationCode = generateConfirmationCode();
		int userID = 0;
		// JDBC connection
		Connection conn = null;
		PreparedStatement checkStatement = null;
		PreparedStatement insertStatement = null;
		ResultSet rs = null;
		boolean userExists = false;
		boolean wrongPassword = !inputPassword.equals(inputCheckPassword); // Compare passwords

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "");

			// Use a prepared statement to prevent SQL injection
			String queryCheckExists = "SELECT * FROM nguoidung WHERE Email = ?";
			checkStatement = conn.prepareStatement(queryCheckExists);
			checkStatement.setString(1, inputEmail);
			rs = checkStatement.executeQuery();
			if (rs.next()) {
				userExists = true;
		        userID = rs.getInt("MaNguoiDung");
			}
			if (userExists == false && wrongPassword == false) {
				String insertQuery = "INSERT INTO nguoidung (Email, HoVaTen, MaXacNhan, MatKhau, MaQR, SoDienThoai, HinhDaiDien, NgaySinh, LoaiTaiKhoan, TrangThai) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				insertStatement = conn.prepareStatement(insertQuery);
				insertStatement.setString(1, inputEmail);
				insertStatement.setString(2, inputName);
				insertStatement.setString(3, confirmationCode);
				insertStatement.setString(4, inputPassword);
				insertStatement.setString(5, " ");
				insertStatement.setString(6, " ");
				insertStatement.setString(7, " ");
				
				Date now = new Date(1); 
				insertStatement.setDate(8, now);
				
				insertStatement.setString(9, " ");
				insertStatement.setString(10, " ");
				// Execute the insert query
				int rowsInserted = insertStatement.executeUpdate();
				if (rowsInserted > 0) {
					// Successfully inserted a new account
					System.out.println(
							"New account inserted: Email=" + inputEmail + ", ConfirmationCode=" + confirmationCode);
					EmailSender.sendActivationCode(inputEmail, inputName, confirmationCode);
					SessionManager.storeUserInfo(request, inputEmail, inputPassword, inputName, confirmationCode, SessionManager.getPhone(request), SessionManager.getDoB(request), userID); 
					request.getRequestDispatcher("/views/Confirm_Account.jsp").forward(request, response);
				} else {
					// Handle insertion failure
					request.setAttribute("userExists", userExists);
					request.setAttribute("wrongPassword", wrongPassword);
					System.out.println("Failed to insert a new account.");
					request.getRequestDispatcher("/views/SignUp.jsp").forward(request, response);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
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
			if (checkStatement != null) {
				try {
					checkStatement.close();
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
			System.out.println("User exists");
			request.getRequestDispatcher("/views/SignUp.jsp").forward(request, response);
		}
		if (wrongPassword) {
			System.out.println("Wrong password");
			request.getRequestDispatcher("/views/SignUp.jsp").forward(request, response);
		}
	}

	private String generateConfirmationCode() {
		// Generate a random confirmation code here (example: a 6-character alphanumeric
		// code)
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder code = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 6; i++) {
			code.append(characters.charAt(random.nextInt(characters.length())));
		}

		return code.toString();
	}
}
