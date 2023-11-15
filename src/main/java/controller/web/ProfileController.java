package controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.IDebugRequestor;

import com.google.gson.JsonObject;

import model.BaiViet;
import model.BaiVietView;
import model.FileBaiViet;
import model.NguoiDung;
import model.ThongTinKetBan;
import model.TuongTacBaiViet;
import service.BaiVietService;
import service.BinhLuanBaiVietService;
import service.FileBaiVietService;
import service.NguoiDungService;
import service.ThongTinKetBanService;
import service.TuongTacBaiVietService;
import service.TuongTacBinhLuanService;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaiVietService baiVietService = new BaiVietService();
	private TuongTacBaiVietService tuongTacBaiVietService = new TuongTacBaiVietService();
	private NguoiDungService nguoiDungService = new NguoiDungService();
	private TuongTacBinhLuanService tuongTacBinhLuanService = new TuongTacBinhLuanService();
	private BinhLuanBaiVietService binhLuanBaiVietService = new BinhLuanBaiVietService();
	private ThongTinKetBanService thongTinKetBanService = new ThongTinKetBanService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String userID = request.getAttribute("userID").toString();
//		String sessionID = request.getAttribute("sessionID").toString();

		String userID = "9";
		int currentUID = 6;
		ThongTinKetBan isfriend = new ThongTinKetBan();

		List<BaiViet> baiviets = new ArrayList<>();
		BaiVietService bvSV = new BaiVietService();
		List<BaiVietView> baiVietViews = new ArrayList<>();
		List<ThongTinKetBan> friendsOfUser = thongTinKetBanService.geThongTinKetBansLaBan(Integer.parseInt(userID));
		
		String postingDisplayString = "yes";
		String showButton = "";
		String btnDescriptionString = "";
		//Lấy số người bạn của User
		int count = getFriendsOfUser(friendsOfUser);
		
		//Lấy thông tin của button
		if (Integer.parseInt(userID) != currentUID) {
			postingDisplayString = "no";
			isfriend = thongTinKetBanService.getTrangThaiKetBanHaiNguoiDung(currentUID, Integer.parseInt(userID));
			String friendStatuString = "";
			if(isfriend != null) {
				friendStatuString = isfriend.getTrangThai();
			}
			switch (friendStatuString) {
			case "daketban": {
				showButton = "disabled";
				btnDescriptionString = "Đã kết bạn";

				break;
			}
			case "chochapnhan":{
				showButton = "disabled";
				btnDescriptionString = "Chờ chấp nhận";
				break;
			}
			case "chan": {
				btnDescriptionString = "Bạn đã bị chặn";
				showButton = "disabled";
				break;
			}
			default:
				showButton = "";
				btnDescriptionString = "Kết bạn";
			}
		}
//		int user = Integer.parseInt(request.getParameter("id"));
		
		//Lấy thông tin User
		NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(Integer.parseInt(userID));
		//Lấy các bài viết của User và cho vào ViewModel
		baiviets = bvSV.getBaiVietsByUserID(userID);
		for (BaiViet baiViet : baiviets) {
			baiVietViews.add(getDataBaiVietForView(baiViet.getMaBaiViet(), Integer.parseInt(userID)));
		}

		
		//Thay đổi thuộc tính của Button
		request.setAttribute("postingDisplayString", postingDisplayString);
		request.setAttribute("showButton", showButton);
		request.setAttribute("btnDescriptionString", btnDescriptionString);
		//Thông tin chung trong trang cá nhân
		request.setAttribute("currentUID", currentUID);
		request.setAttribute("songuoiban", count);
		request.setAttribute("baiVietViews", baiVietViews);
		request.setAttribute("nguoiDung", nguoiDung);
		request.getRequestDispatcher("views/ca-nhan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String CUID = request.getParameter("CUID");
		String UID = request.getParameter("UID");
		PrintWriter printWriter = response.getWriter();
		JsonObject jsonResponse = new JsonObject();
		
		Integer id = thongTinKetBanService.insertNewFriend(Integer.parseInt(CUID), Integer.parseInt(UID));
		if(id != null) {
			jsonResponse.addProperty("status", "success");
		} else {
			jsonResponse.addProperty("status", "failure");
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		
		
		printWriter.write(jsonResponse.toString());
	}
	
	
	public int getFriendsOfUser(List<ThongTinKetBan> friendsOfUser) {
		int count = 0;
		if (friendsOfUser == null) {
			return count;
		}
		else {
			for (ThongTinKetBan friend : friendsOfUser) {
				if ("daketban".equals(friend.getTrangThai())) {
					count++;
				}
			}
		}
		return count;
	}
	public BaiVietView getDataBaiVietForView(int maBaiViet, int maLoginUser) {

		BaiViet baiViet = baiVietService.getBaiVietById(maBaiViet);

		TuongTacBaiViet loginUserTuongTacBaiViet = tuongTacBaiVietService.getUserTuongTacBaiViet(maBaiViet,
				maLoginUser);
		List<TuongTacBaiViet> top3TuongTacBaiViets = tuongTacBaiVietService.getTop3TuongTacBaiViet(maBaiViet);
		int tongLuotTuongTac = tuongTacBaiVietService.getTongLuotTuongTacBaiViet(maBaiViet);

		int binhLuanCount = tuongTacBaiVietService.getTongLuotTuongTacBaiViet(maBaiViet);

		FileBaiVietService fileBaiVietService = new FileBaiVietService();
		List<FileBaiViet> fileBaiViets = fileBaiVietService.getFileBaiVietsByMaBaiViet(maBaiViet);
		List<FileBaiViet> fileHinhAnhs = new ArrayList<>();
		List<FileBaiViet> fileDinhKems = new ArrayList<>();
		for (FileBaiViet fileBaiViet : fileBaiViets) {
			if (fileBaiViet.getLoaiFile().equals("Anh")) {
				fileHinhAnhs.add(fileBaiViet);
			} else if (fileBaiViet.getLoaiFile().equals("File")) {
				fileDinhKems.add(fileBaiViet);
			}
		}

		NguoiDung nguoiDang = nguoiDungService.getNguoiDungById(baiViet.getMaNguoiDung());
		String anhDaiDienNguoiDang = nguoiDang.getHinhDaiDien();
		String hoVaTenNguoiDang = nguoiDang.getHoVaTen();

		BaiVietView baiVietView = new BaiVietView(baiViet, loginUserTuongTacBaiViet, fileHinhAnhs, fileDinhKems,
				top3TuongTacBaiViets, binhLuanCount, tongLuotTuongTac, anhDaiDienNguoiDang, hoVaTenNguoiDang);
		return baiVietView;

	}
}
