package controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NguoiDungService;

/**
 * Servlet implementation class RecoverPassword
 */
@WebServlet("/quen-password")
public class RecoverPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail = request.getParameter("inputEmail");
		NguoiDungService userService = new NguoiDungService();

		try {
            if (userService.QuenMatKhau(inputEmail)) {
            	request.setAttribute("loginStatus", "sendPassword");
    		    System.out.println("send");
                request.getRequestDispatcher("/views/Index.jsp").forward(request, response);
            } else {
                // Handle incorrect confirmation code or email
                System.out.println("no can do brother!");
                // You can redirect to an error page or perform further actions heree
            }

        } finally {
            // Close resources in a finally block

        }
	}
}

