package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BaoCaoBaiviet;
import model.BaoCaoBinhLuan;
import model.BaoCaoNguoiDung;
import model.QuanLyBaiViet;
import model.QuanLyBinhLuan;
import model.QuanLyNguoiDung;
import service.AdminService;

@WebServlet({ "/AdminActionController", "/admin_action" })
public class AdminActionController extends HttpServlet {
	private AdminService AS = new AdminService();
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String require = request.getParameter("require");
		int id = Integer.parseInt(request.getParameter("id"));
		int idadmin = 1;
		
		switch (require) {
		case "QLBV": {
			AS.banBaiViet(id, idadmin);
			List<BaoCaoBaiviet> list = AS.getAllBaoCaoBaiViet();
			request.setAttribute("list", list);
			break;
		}
		case "QLND": {
			AS.banNguoiDung(id, idadmin);
			List<BaoCaoNguoiDung> list = AS.getAllBaoCaoNguoiDung();
			request.setAttribute("list", list);
			break;
		}
		case "QLBL": {
			AS.banBinhLuan(id, idadmin);
			List<BaoCaoBinhLuan> list = AS.getAllBaoCaoBinhLuan();
			request.setAttribute("list", list);
			break;
		}
		case "LSQLBV": {
			AS.undoBanBaiViet(id, idadmin);
			List<QuanLyBaiViet> list = AS.getAllQuanLyBaiViet();
			request.setAttribute("list", list);
			break;
		}
		case "LSQLND": {
			AS.undoBanNguoiDung(id, idadmin);
			List<QuanLyNguoiDung> list = AS.getAllQuanLyNguoiDung();
			request.setAttribute("list", list);
			break;
		}
		case "LSQLBL": {
			AS.undoBanBinhLuan(id, idadmin);
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
