package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import service.*;

import java.io.IOException;
import java.util.List;

public class FriendServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FriendService FS = new FriendService();
		List<NguoiDung> userlist = FS.getAllBanBeByID(1);
		int listlength = userlist.size();
		int numpage = listlength / 8 + 1;

		request.setAttribute("userlist", userlist);
		request.setAttribute("numpage", numpage);

		request.getRequestDispatcher("/views/friend.jsp").forward(request, response);
	}
}