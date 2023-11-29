package controller.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NguoiDung;
import service.NguoiDungService;

/**
 * Servlet implementation class confirmServlet
 */
@WebServlet({ "/xac-nhan" })
public class confirmServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5245843161862142442L;

	/**
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail = null, inputConfirmCode = null;
		if (SessionManager.getEmail(request) != null && SessionManager.getPassword(request) != null) {
			inputEmail = SessionManager.getEmail(request);
			inputConfirmCode = SessionManager.getConfirmCode(request);
		}
		else {
			inputEmail = request.getParameter("inputEmail");
			inputConfirmCode = request.getParameter("inputConfirmCode");
		}
		
		NguoiDungService userService = new NguoiDungService();
		
        try {
            if (userService.XacNhanTaiKhoan(inputEmail, inputConfirmCode)) {
                // Confirmation code matched, and the status is updated
                System.out.println("Account confirmed: Email=" + inputEmail + ", ConfirmationCode=" + inputConfirmCode);
                request.setAttribute("inputEmail", SessionManager.getEmail(request));
                request.setAttribute("inputPassword", SessionManager.getPassword(request));
                request.getRequestDispatcher("/views/Index.jsp").forward(request, response);
                //response.sendRedirect(request.getContextPath() + "/views/Home.jsp");
				//return;
            } else {
                // Handle incorrect confirmation code or email
                System.out.println("Incorrect confirmation code or email");
                // You can redirect to an error page or perform further actions heree
            }

        } finally {
            // Close resources in a finally block
            
        }
}
}
