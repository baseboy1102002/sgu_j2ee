package controller.web;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/cai-dat")
@MultipartConfig
public class settingServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5777195563665546188L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve user information from session
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("inputName");
		String email = request.getParameter("inputEmail");
		String Strdob = request.getParameter("inputDoB");
		String phone = request.getParameter("inputPhone");

		File dir = new File(request.getServletContext().getRealPath("/files"));
		System.out.println(dir);
		if (!dir.exists()) { // tạo nếu chưa tồn tại
			dir.mkdirs();
		}
		Part photo = request.getPart("photo_file"); // file hình
		File photoFile = new File(dir, photo.getSubmittedFileName());
		photo.write(photoFile.getAbsolutePath());

		// Convert the String to java.sql.Date
		java.sql.Date dob = java.sql.Date.valueOf(Strdob);

		// JDBC connection
		Connection conn = null;
		PreparedStatement updateStatement = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "");

			// Query to update the confirmation status when the confirmation code matches
			// the email
			String updateQuery = "UPDATE nguoidung SET HoVaTen = ?, Email = ?, NgaySinh = ?, SoDienThoai = ? WHERE MaNguoiDung = ?";
			updateStatement = conn.prepareStatement(updateQuery);
			updateStatement.setString(1, name);
			updateStatement.setString(2, email);
			updateStatement.setDate(3, dob);
			updateStatement.setString(4, phone);
			updateStatement.setLong(5, SessionManager.getID(request));
			System.out.println(SessionManager.getDoB(request));
			int rowsUpdated = updateStatement.executeUpdate();

			if (rowsUpdated > 0) {
				// Confirmation code matched, and the status is updated
				System.out.println("ok");
				SessionManager.setDoB(request, dob);
				SessionManager.setEmail(request, email);
				SessionManager.setName(request, name);
				SessionManager.setPhone(request, phone);
			} else {
				
				System.out.println("not ok");
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			if (updateStatement != null) {
				try {
					updateStatement.close();
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

		request.getRequestDispatcher("views/Setting.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
