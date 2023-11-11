package controller.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NguoiDung;
import model.TinNhan;
import service.MessageService;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageService MS = new MessageService();
		String suserid1 = request.getParameter("userid1");
		String suserid2 = request.getParameter("userid2");
		int iuserid1 = Integer.parseInt(suserid1);
		int iuserid2 = 0;

		try {
			iuserid2 = Integer.parseInt(suserid2);
		} catch (Exception e) {
			iuserid2 = 0;
		}

		NguoiDung nd = new NguoiDung(0, "empty", "empty", "empty");

		List<NguoiDung> userlist = MS.getAllSortedBanBeByID(iuserid1, iuserid2);
		List<TinNhan> messlist = MS.getAllTinNhanById(iuserid1, iuserid2);
		List<String> timeformattedlist = FormatList(messlist);

		if (iuserid2 != 0) {
			nd = MS.getNguoiDungFocus(iuserid2);
		}

		request.setAttribute("ndfocus", nd);
		request.setAttribute("userlist", userlist);
		request.setAttribute("messlist", messlist);
		request.setAttribute("timelist", timeformattedlist);

		request.getRequestDispatcher("/views/message.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageService MS = new MessageService();
		String suserid1 = request.getParameter("manguoigui");
		String suserid2 = request.getParameter("manguoinhan");
		String noidung = request.getParameter("noidung");
		int iuserid1 = Integer.parseInt(suserid1);
		int iuserid2 = Integer.parseInt(suserid2);
		
		MS.GuiTinNhan(iuserid1, iuserid2, noidung);
	}

	public List<String> FormatList(List<TinNhan> messlist) {
		List<String> timeformattedlist = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");

		for (TinNhan tn : messlist) {
			Date ngaygioguiDate = tn.getNgayGioGui();
			Timestamp ngaygiogui = new Timestamp(ngaygioguiDate.getTime());
			String formattedTime = dateFormat.format(ngaygiogui);
			timeformattedlist.add(formattedTime);
		}

		return timeformattedlist;
	}
}