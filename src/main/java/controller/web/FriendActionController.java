package controller.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NguoiDung;
import service.FriendActionService;
import service.FriendService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FriendActionController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String action = request.getParameter("nameact");
		String suserid1 = request.getParameter("userid1");
		String suserid2 = request.getParameter("userid2");
		int iuserid1 = Integer.parseInt(suserid1);
		int iuserid2 = Integer.parseInt(suserid2);

		FriendService FS = new FriendService();
		FriendActionService FAS = new FriendActionService();
		List<NguoiDung> userlist = new ArrayList<>();
		
		switch (type) {
		case "dsbb": {
			switch (action) {
				case "nhantin": {
	
					break;
				}
				case "huy": {
					FAS.ActionHuyKetBan(iuserid1, iuserid2);
					break;
				}
				case "chan": {
					FAS.ActionChan(iuserid1, iuserid2);
					break;
				}
				default: {
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
			}
			userlist = FS.getAllBanBeByID(iuserid1);
			break;

		}
		case "dslm": {
			switch (action) {
				case "chapnhan": {
					FAS.ActionChapNhanKetBan(iuserid1, iuserid2);
					break;
				}
				case "huy": {
					FAS.ActionHuyLoiMoiKetBan1(iuserid1, iuserid2);
					break;
				}
				case "chan": {
					FAS.ActionChan(iuserid1, iuserid2);
					break;
				}
				default: {
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
			}
			userlist = FS.getAllLoiMoiKetBanByID(iuserid1);
			break;
		}
		case "dskbcb": {
			switch (action) {
				case "huy": {
					FAS.ActionHuyLoiMoiKetBan2(iuserid1, iuserid2);
					break;
				}
				case "chan": {
					FAS.ActionChan(iuserid1, iuserid2);
					break;
				}
				default: {
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
			}
			userlist = FS.getAllLoiMoiCuaBanByID(iuserid1);
			break;
		}
		case "dsc": {
			switch (action) {
				case "bochan": {
					FAS.ActionBoChan(iuserid1, iuserid2);
					break;
				}
				default: {
					throw new IllegalArgumentException("Unexpected value: " + action);
				}
			}
			userlist = FS.getAllChanByID(iuserid1);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
		int listlength = userlist.size();

		int numpage = listlength / 8 + 1;
		
		request.setAttribute("type", type);
		request.setAttribute("userlist", userlist);
		request.setAttribute("numpage", numpage);

		request.getRequestDispatcher("/views/friend.jsp").forward(request, response);
	}
}
