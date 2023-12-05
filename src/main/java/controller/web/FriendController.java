package controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NguoiDung;
import service.FriendService;

public class FriendController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String suserid = request.getParameter("userid");
		int iuserid = Integer.parseInt(suserid);
		FriendService FS = new FriendService();
		List<NguoiDung> userlist = FS.getAllBanBeByID(iuserid);
		int listlength = userlist.size();
		int numpage = listlength / 8 + 1;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		request.setAttribute("type", "dsbb");
		request.setAttribute("userlist", userlist);
		request.setAttribute("numpage", numpage);

		request.getRequestDispatcher("/views/friend.jsp").forward(request, response);
	}
}
