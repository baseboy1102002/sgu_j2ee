package controller.web;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NguoiDung;
import service.NguoiDungService;

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

		NguoiDungService userService = new NguoiDungService();
		NguoiDung user = new NguoiDung();

		boolean wrongPassword = !inputPassword.equals(inputCheckPassword); // Compare passwords
		boolean userExists = userService.KiemTraTaiKhoanTonTai(inputEmail);
		
		if (userExists) {
			System.out.println("User exists");
			request.setAttribute("signupStatus", "exists");
			return;
		} else if (wrongPassword) {
			System.out.println("Wrong password");
			request.setAttribute("signupStatus", "wrong");
			return;
		}
		
		if (wrongPassword == false && userExists == false) {

			user = userService.DangKi(inputEmail, inputPassword, inputName, confirmationCode);
			if (user != null) {
				// Successfully inserted a new account
				System.out.println(
						"New account inserted: Email=" + inputEmail + ", ConfirmationCode=" + confirmationCode);
				EmailSender.sendActivationCode(inputEmail, inputName, confirmationCode);
				SessionManager.storeUserInfo(request, inputEmail, inputPassword, inputName, confirmationCode,
						user.getSoDienThoai(), user.getNgaySinh(), user.getMaNguoiDung(), user.getHinhDaiDien());
				request.getRequestDispatcher("/views/Confirm_Account.jsp").forward(request, response);
				return;
			} else {
				// Handle insertion failure
				System.out.println("Failed to insert a new account.");
			}
		}
		request.getRequestDispatcher("/views/SignUp.jsp").forward(request, response);
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
