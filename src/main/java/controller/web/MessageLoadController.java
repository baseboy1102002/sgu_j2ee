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
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MessageLoadController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageService MS = new MessageService();
		int userid1 = Integer.parseInt(request.getParameter("userid1"));
		int userid2 = Integer.parseInt(request.getParameter("userid2"));
		String type = request.getParameter("type");
		
		NguoiDung nd1 = MS.getNguoiDungFocus(userid1);
		NguoiDung nd2 = MS.getNguoiDungFocus(userid2);
		String color = "";
		
		switch(nd2.getTrangThai()) {
			case "offline": {
				color = "gray";
				break;
			}
			case "online": {
				color = "var(--darker-primary-color)";
				break;
			}
			case "systembanned": {
				color = "red";
				break;
			}
			default: {
				color = "#ffcf61";
				break;
			}
		}
		
		List<TinNhan> listtn = MS.getAllTinNhanById(userid1, userid2);
		List<String> timeformattedlist = FormatList(listtn);
		
		PrintWriter out = response.getWriter();
		
		if(type.equalsIgnoreCase("loadall")) {
			out.println("            <div class=\"chatbox_header\">\r\n"
					+ "                <a href=\"/sgu_j2ee/profile?userID=" + nd2.getMaNguoiDung() + "\" class=\"chatbox_header_info_wrapper\" id=\"chatbox_header_info_wrapper\">\r\n"
					+ "                    <img src=\"/sgu_j2ee/files/" + nd2.getHinhDaiDien() + "\" alt=\"\" class=\"chatbox_header_image\">\r\n"
					+ "                    <div class=\"chatbox_header_info\">\r\n"
					+ "                        <div class=\"chatbox_info_name\">\r\n"
					+ "                            " + nd2.getHoVaTen() + "\r\n"
					+ "                        </div>\r\n"
					+ "                        <div class=\"chatbox_info_status\">\r\n"
					+ "                            <div class=\"status_dot\" style=\"background-color: " + color + ";\"></div>\r\n"
					+ "                            <div class=\"status_name\">\r\n"
					+ "                                " + nd2.getTrangThai() + "\r\n"
					+ "                            </div>\r\n"
					+ "                        </div>\r\n"
					+ "                    </div>\r\n"
					+ "                </a>\r\n"
					+ "                <div class=\"chatbox_call\">\r\n"
					+ "                    <div class=\"chatbox_norcall\">\r\n"
					+ "                        <i class=\"fa-solid fa-phone\"></i>\r\n"
					+ "                    </div>\r\n"
					+ "                    <a href=\"/sgu_j2ee/callvid?userid1=" + userid1 + "&userid2=" + userid2 + "\" class=\"chatbox_vidcall\">\r\n"
					+ "                        <i class=\"fa-solid fa-video\"></i>\r\n"
					+ "                    </a>\r\n"
					+ "                </div>\r\n"
					+ "            </div>\r\n"
					+ "            <hr class=\"separateline\">\r\n"
					+ "			   <div class=\"chatbox_content\">\r\n");
		}
		int index = 0;
		for (TinNhan tn : listtn) {
			if(tn.getMaNguoiNhan() == userid1) {
				out.println("<div class=\"chatbox_content_sender\">\r\n"
						+ "		                    <div class=\"sender_value\">\r\n"
						+ "		                        <div class=\"sender_time\">" + timeformattedlist.get(index) + "</div>\r\n"
						+ "		                        <div class=\"sender_message\">" + tn.getNoiDung() + "</div>\r\n"
						+ "		                    </div>\r\n"
						+ "		                    <img src=\"/sgu_j2ee/files/" + nd1.getHinhDaiDien() + "\" alt=\"\" class=\"sender_image\"></img>\r\n"
						+ "		                </div>");
			} else {
				out.println("<div class=\"chatbox_content_receiver\">\r\n"
						+ "		                    <img src=\"/sgu_j2ee/files/" + nd2.getHinhDaiDien() + "\" alt=\"\" class=\"receiver_image\"></img>\r\n"
						+ "		                    <div class=\"receiver_value\">\r\n"
						+ "		                        <div class=\"receiver_time\">" + timeformattedlist.get(index) + "</div>\r\n"
						+ "		                        <div class=\"receiver_message\">" + tn.getNoiDung() + "</div>\r\n"
						+ "		                    </div>\r\n"
						+ "		                </div>");
			}
			index++;
		}
		
		if(type.equalsIgnoreCase("loadall")) {
			out.println("</div>\r\n"
					+ "            <div class=\"chatbox_inputs\">\r\n"
					+ "                <div class=\"inputs_file\">\r\n"
					+ "                    <i class=\"fa-regular fa-image\"></i>\r\n"
					+ "                </div>\r\n"
					+ "                <textarea type=\"text\" class=\"inputs_text\" id=\"inputs_text\" onkeydown=\"checkEnterKey(event, " + userid1 + ", " + userid2 + ")\"></textarea>\r\n"
					+ "                <div class=\"inputs_buttonsend\" onclick=\"sendMessage(" + userid1 + ", " + userid2 + ")\">\r\n"
					+ "                    <i class=\"fa-regular fa-paper-plane\"></i>\r\n"
					+ "                </div>\r\n"
					+ "            </div>");
		}
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
