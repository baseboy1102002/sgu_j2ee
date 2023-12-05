package controller.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NguoiDung;
import model.TinNhan;
import service.MessageService;

public class MessageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		MessageService MS = new MessageService();
		String suserid1 = request.getParameter("userid1");
		String suserid2 = request.getParameter("userid2");
		int iuserid1 = Integer.parseInt(suserid1);
		int iuserid2 = Integer.parseInt(suserid2);

		NguoiDung nd = MS.getNguoiDungFocus(iuserid2);

		List<NguoiDung> userlist = MS.getAllSortedBanBeByID(iuserid1, iuserid2);
		List<TinNhan> messlist = MS.getAllTinNhanById(iuserid1, iuserid2);
		List<String> timeformattedlist = FormatList(messlist);

		request.setAttribute("ndfocus", nd);
		request.setAttribute("userlist", userlist);
		request.setAttribute("messlist", messlist);
		request.setAttribute("timelist", timeformattedlist);

		request.getRequestDispatcher("/views/message.jsp").forward(request, response);
	}

	@Override
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
	    SimpleDateFormat shortFormat = new SimpleDateFormat("hh:mm a");
	    SimpleDateFormat longFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");

	    for (TinNhan tn : messlist) {
	        Date ngaygioguiDate = tn.getNgayGioGui();
	        Timestamp ngaygiogui = new Timestamp(ngaygioguiDate.getTime());

	        long timeDifferenceMillis = System.currentTimeMillis() - ngaygiogui.getTime();
	        long hoursDifference = TimeUnit.MILLISECONDS.toHours(timeDifferenceMillis);

	        String formattedTime;

	        if (hoursDifference < 24) {
	            formattedTime = shortFormat.format(ngaygiogui);
	        } else {
	            formattedTime = longFormat.format(ngaygiogui);
	        }

	        timeformattedlist.add(formattedTime);
	    }

	    return timeformattedlist;
	}

}
