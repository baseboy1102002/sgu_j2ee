package controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.NguoiDung;
import service.NguoiDungService;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet({ "/dang-nhap" })
public class loginServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 6568224008104939619L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
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
		request.setCharacterEncoding("utf-8");
		// logout
		HttpSession session = request.getSession();
		session.invalidate();

		String inputEmail = request.getParameter("inputEmail");
		String inputPassword = request.getParameter("inputPassword");
		//String checkRemember = request.getParameter("checkRemember");

		NguoiDungService userService = new NguoiDungService();
		NguoiDung user = userService.DangNhap(inputEmail, inputPassword);

		if (user != null) {
			SessionManager.storeUserInfo(request, inputEmail, inputPassword, user.getHoVaTen(), user.getMaXacNhan(), user.getSoDienThoai(),
					user.getNgaySinh(), user.getMaNguoiDung(), user.getHinhDaiDien(), user.getLoaiTaiKhoan(), user.getTrangThai());
			if (SessionManager.getTrangThai(request).equals("systembanned")) {
				request.setAttribute("loginStatus", "ban");
				System.out.println("system banned");
				request.getRequestDispatcher("/views/Index.jsp").forward(request, response);
				return;
			}
			else {
				if (!SessionManager.getConfirmCode(request).equals("confirmed!")){
					response.sendRedirect(request.getContextPath() + "/views/Confirm_Account.jsp");
					return;
				}
				else {
					if (SessionManager.getLoaiTaiKhoan(request).equals("admin")) {
						response.sendRedirect(request.getContextPath() + "/views/Home_Admin.jsp");
						return;
					}
					if (SessionManager.getLoaiTaiKhoan(request).equals("user")) {

						response.sendRedirect(request.getContextPath() + "/trang-chu");
						return;
					}
				}
			}
		} else {
			request.setAttribute("loginStatus", "failed");
			System.out.println("login failed");
			request.getRequestDispatcher("/views/Index.jsp").forward(request, response);
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
