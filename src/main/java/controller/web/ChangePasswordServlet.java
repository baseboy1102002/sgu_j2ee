package controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NguoiDungService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String inputOldPassword = request.getParameter("inputOldPassword");
		String inputNewPassword_1 = request.getParameter("inputNewPassword_1");
		String inputNewPassword_2 = request.getParameter("inputNewPassword_2");

		NguoiDungService userService = new NguoiDungService();
		boolean wrongPassword_2 = !inputNewPassword_1.equals(inputNewPassword_2); // Compare passwords
		boolean wrongPassword_1 = !inputOldPassword.equals(SessionManager.getPassword(request)); // Compare passwords


		if (!wrongPassword_1 && !wrongPassword_2) {
			try {
				if (userService.DoiMatKhau(SessionManager.getEmail(request), inputNewPassword_1, SessionManager.getName(request))) {
					System.out.println("Changed Password: Email=" + SessionManager.getEmail(request) +
							", password =" + inputOldPassword);
					request.setAttribute("changePasswordStatus", "success");
					SessionManager.setPassword(request, inputNewPassword_1);
				} else {
					// Handle incorrect confirmation code or email
					System.out.println("no can do brother!");
					// You can redirect to an error page or perform further actions heree
				}

			} finally {
				// Close resources in a finally block

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
