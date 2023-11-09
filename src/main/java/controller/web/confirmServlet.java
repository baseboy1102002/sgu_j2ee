package controller.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class confirmServlet
 */
@WebServlet({ "/xac-nhan" })
public class confirmServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5245843161862142442L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputEmail = request.getParameter("inputEmail");  // Get the email from the hidden input field
        String inputConfirmCode = request.getParameter("inputConfirmCode");

        // JDBC connection
        Connection conn = null;
        PreparedStatement updateStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "");
            
            // Query to update the confirmation status when the confirmation code matches the email
            String updateQuery = "UPDATE nguoidung SET MaXacNhan = 'confirmed!' WHERE MaXacNhan = ? AND Email = ?";
            updateStatement = conn.prepareStatement(updateQuery);
            updateStatement.setString(1, inputConfirmCode);
            updateStatement.setString(2, inputEmail);

            int rowsUpdated = updateStatement.executeUpdate();
            
            if (rowsUpdated > 0) {
                // Confirmation code matched, and the status is updated
                System.out.println("Account confirmed: Email=" + inputEmail + ", ConfirmationCode=" + inputConfirmCode);
                
                // You can redirect to a success page or perform further actions here
            } else {
                // Handle incorrect confirmation code or email
                System.out.println("Incorrect confirmation code or email");
                // You can redirect to an error page or perform further actions heree
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
    }
}

