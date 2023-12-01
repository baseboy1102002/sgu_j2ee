package controller.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NguoiDung;
import service.FriendService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FriendLoadController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String suserid = request.getParameter("userid");
		int iuserid = Integer.parseInt(suserid);
		FriendService FS = new FriendService();
		List<NguoiDung> userlist;
		String type = request.getParameter("type");
		String search = request.getParameter("search");
				
		switch (type) {
		case "dsbb": {
			userlist = FS.getAllBanBeByID(iuserid);
			break;
		}
		case "dslm": {
			userlist = FS.getAllLoiMoiKetBanByID(iuserid);
			break;
		}
		case "dskbcb": {
			userlist = FS.getAllLoiMoiCuaBanByID(iuserid);
			break;
		}
		case "dsc": {
			userlist = FS.getAllChanByID(iuserid);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
		
		if(search!=null) {
			for (NguoiDung nd : new ArrayList<>(userlist)) {
				if(!nd.getHoVaTen().toLowerCase().contains(search.toLowerCase())) {
					userlist.remove(nd);
				}
			}
		}

		PrintWriter out = response.getWriter();
				
		int start = 0;
		int end = 0;
		int ipage = 0;
		int indexing = 0;

		try {
			String spage = request.getParameter("indexpage");
			ipage = Integer.parseInt(spage);
		} catch (Exception e) {
			ipage = 1;
		}
				
		start = (ipage - 1) * 8;
		end = ipage * 8;

		for (NguoiDung nd : userlist) {
			if (start == end) {
				break;
			}
			if (indexing != start) {
				indexing += 1;
				continue;
			}
			indexing += 1;
			start += 1;
			out.println("<li class=\"listfriend_item\">\r\n"
					+ "		<a href=\"/sgu_j2ee/profile?userID=" + nd.getMaNguoiDung() + "\" class=\"item_info\">\r\n"
					+ "			<img src=\"/sgu_j2ee/files/" + nd.getHinhDaiDien() + "\" alt=\"ảnh người dùng\" class=\"item_info_img\">\r\n"
					+ "			<div class=\"item_info_name\">" + nd.getHoVaTen() + "</div>\r\n"
					+ "		</a>\r\n"
					+ "\r\n");
			
			switch (type) {
			case "dsbb": {
				out.println("<div class=\"item_action\">\r\n"
						+ "		<a href=\"mess?userid1=" + iuserid + "&userid2=" + nd.getMaNguoiDung() + "\" class=\"action_message\"> <i class=\"fa-regular fa-comment\" style=\"margin-right: 10px;\"></i> Nhắn tin</a>\r\n"
						+ "		<a href=\"action?type=" + type + "&nameact=huy&userid1=" + iuserid + "&userid2=" + nd.getMaNguoiDung() + "\" class=\"action_cancel\"><i class=\"fa-solid fa-xmark\" style=\"margin-right: 10px;\"></i> Hủy</a>\r\n"
						+ "		<a href=\"action?type=" + type + "&nameact=chan&userid1=" + iuserid + "&userid2=" + nd.getMaNguoiDung() + "\" class=\"action_block\"><i class=\"fa-solid fa-ban\" style=\"margin-right: 10px;\"></i> Chặn</a>\r\n"
						+ "	</div>");
				break;
			}
			case "dslm": {
				out.println("<div class=\"item_action\">\r\n"
						+ "		<a href=\"action?type=" + type + "&nameact=chapnhan&userid1=" + iuserid + "&userid2=" +nd.getMaNguoiDung() + "\" class=\"action_message\"><i class=\"fa-regular fa-circle-check\" style=\"margin-right: 10px;\"></i> Chấp nhận</a>\r\n"
						+ "		<a href=\"action?type=" + type + "&nameact=huy&userid1=" + iuserid + "&userid2=" + nd.getMaNguoiDung() + "\" class=\"action_cancel\"><i class=\"fa-solid fa-xmark\" style=\"margin-right: 10px;\"></i> Hủy</a>\r\n"
						+ "		<a href=\"action?type=" + type + "&nameact=huy&userid1=" + iuserid + "&userid2=" + nd.getMaNguoiDung() + "\" class=\"action_block\"><i class=\"fa-solid fa-ban\" style=\"margin-right: 10px;\"></i> Chặn</a>\r\n"
						+ "	</div>");
				break;
			}
			case "dskbcb": {
				out.println("<div class=\"item_action\">\r\n"
						+ "		<a href=\"action?type=" + type + "&nameact=huy&userid1=" + iuserid + "&userid2=" + nd.getMaNguoiDung() + "\" class=\"action_cancel\"><i class=\"fa-solid fa-xmark\" style=\"margin-right: 10px;\"></i> Hủy</a>\r\n"
						+ "		<a href=\"action?type=" + type + "&nameact=chan&userid1=" + iuserid + "&userid2=" + nd.getMaNguoiDung() + "\"  class=\"action_block\"><i class=\"fa-solid fa-ban\" style=\"margin-right: 10px;\"></i> Chặn</a>\r\n"
						+ "	</div>");
				break;
			}
			case "dsc": {
				out.println("<div class=\"item_action\">\r\n"
						+ "		<a href=\"action?type=" + type + "&nameact=bochan&userid1=" + iuserid + "&userid2=" + nd.getMaNguoiDung() + "\" class=\"action_cancel\"><i class=\"fa-solid fa-xmark\" style=\"margin-right: 10px;\"></i> Bỏ Chặn</a>\r\n"
						+ "	</div>");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
			}								
		}
	}
}