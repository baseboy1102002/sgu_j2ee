package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

import model.*;

@WebServlet({ "/AdminController", "/admin" })
public class AdminController extends HttpServlet {
	private AdminService AS = new AdminService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String require = request.getParameter("require");

		switch (require) {
		case "QLBV": {
			List<BaoCaoBaiviet> list = AS.getAllBaoCaoBaiViet();
			request.setAttribute("list", list);
			break;
		}
		case "QLND": {
			List<BaoCaoNguoiDung> list = AS.getAllBaoCaoNguoiDung();
			request.setAttribute("list", list);
			break;
		}
		case "QLBL": {
			List<BaoCaoBinhLuan> list = AS.getAllBaoCaoBinhLuan();
			request.setAttribute("list", list);
			break;
		}
		case "LSQLBV": {
			List<QuanLyBaiViet> list = AS.getAllQuanLyBaiViet();
			request.setAttribute("list", list);
			break;
		}
		case "LSQLND": {
			List<QuanLyNguoiDung> list = AS.getAllQuanLyNguoiDung();
			request.setAttribute("list", list);
			break;
		}
		case "LSQLBL": {
			List<QuanLyBinhLuan> list = AS.getAllQuanLyBinhLuan();
			request.setAttribute("list", list);
			break;
		}
		default: {
			throw new IllegalArgumentException("Unexpected value: " + require);
		}
		}
		request.setAttribute("require", require);
		request.getRequestDispatcher("/views/Table_Admin.jsp").forward(request, response);
	}
}
