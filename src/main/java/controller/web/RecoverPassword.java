package controller.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecoverPassword
 */
@WebServlet("/quen-password")
public class RecoverPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail = request.getParameter("inputEmail");
		String password = null, name = null;
        // JDBC connection
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "");
            String query = "select * from nguoidung where Email = '" + inputEmail + "'";
		    st = conn.createStatement();
		    rs = st.executeQuery(query);
		   
		    if (rs.next()) {
		        password = rs.getString("MatKhau");
		        name = rs.getString("HoVaTen");
		        EmailSender.sendForgetPassword(inputEmail, name, password);
		    }
		    request.setAttribute("loginStatus", "sendPassword");
		    System.out.println("send");
            request.getRequestDispatcher("/views/Index.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

	}
}

