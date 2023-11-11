package controller.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import service.*;

import java.io.IOException;
import java.util.List;

public class FriendController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FriendService FS = new FriendService();
		List<NguoiDung> userlist = FS.getAllBanBeByID(1);
		int listlength = userlist.size();
		int numpage = listlength / 8 + 1;

		request.setAttribute("type", "dsbb");
		request.setAttribute("userlist", userlist);
		request.setAttribute("numpage", numpage);
		
		request.getRequestDispatcher("/views/friend.jsp").forward(request, response);
	}
}
