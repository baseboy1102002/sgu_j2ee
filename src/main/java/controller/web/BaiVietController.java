package controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import model.TuongTacBaiViet;
import service.BaiVietService;
import service.TuongTacBaiVietService;

/**
 * Servlet implementation class BaiVietController
 */
@WebServlet("/baiviet")
public class BaiVietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TuongTacBaiVietService tuongTacBaiVietService ;
	private BaiVietService baiVietService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaiVietController() {
		super();
		baiVietService = new BaiVietService();
		tuongTacBaiVietService = new TuongTacBaiVietService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter printWriter = response.getWriter();
		switch (action) {
		case "delete": {
			String maBaiViet = request.getParameter("maBaiViet");

			printWriter.print(baiVietService.deleteBaiVietById(Integer.parseInt(maBaiViet)));
			break;
		}
		case "react": {
			String maBaiViet = request.getParameter("maBaiViet");
			int maNguoiDung = 4; //Session
			String trangThai = request.getParameter("trangThai");
			TuongTacBaiViet tuongTacBaiViet = tuongTacBaiVietService.getUserTuongTacBaiViet(Integer.parseInt(maBaiViet),
					maNguoiDung);
		
			if (tuongTacBaiViet == null) {
//				Thêm tuongTacBaiViet nếu null
				TuongTacBaiViet tempTuongTacBaiViet = new TuongTacBaiViet();
				tempTuongTacBaiViet.setMaBaiViet(Integer.parseInt(maBaiViet));
				tempTuongTacBaiViet.setMaNguoiDung(maNguoiDung);
				tempTuongTacBaiViet.setNgayGioTuongTac(new Date());
				tempTuongTacBaiViet.setTrangThai(trangThai);
				tuongTacBaiVietService.addTuongTacBaiViet(tempTuongTacBaiViet);
//				get dữ liệu trả về
					
				response.setContentType("application/json");
				response.setContentType("UTF-8");
				printWriter.print(getDuLieuTuongTacTraVe(Integer.parseInt(maBaiViet)));

			} else {
				tuongTacBaiViet.setNgayGioTuongTac(new Date());
				tuongTacBaiViet.setTrangThai(trangThai);
				tuongTacBaiVietService.updateTuongTacBaiViet(tuongTacBaiViet);

//				get dữ liệu trả về

				response.setContentType("application/json");
				response.setContentType("UTF-8");
				printWriter.print(getDuLieuTuongTacTraVe(Integer.parseInt(maBaiViet)));

			}
			break;
		}
		case "deleteTuongTacBaiViet": {
			String maBaiViet = request.getParameter("maBaiViet");
			String maNguoiDung = request.getParameter("maNguoiDung");
			tuongTacBaiVietService.deleteTuongTacBaiViet(Integer.parseInt(maBaiViet),Integer.parseInt(maNguoiDung));

//			get dữ liệu trả về
			response.setContentType("application/json");
			response.setContentType("UTF-8");
			printWriter.print(getDuLieuTuongTacTraVe(Integer.parseInt(maBaiViet)));
			
			
			
			
			break;

		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}

	}

	private String getDuLieuTuongTacTraVe(int maBaiViet) {
		List<TuongTacBaiViet> top3TuongTacBaiViets = tuongTacBaiVietService.getTop3TuongTacBaiViet(maBaiViet);
		List<String> top3TuongTacStrings = new ArrayList<String>();
		int tongLuotTT = tuongTacBaiVietService.getTongLuotTuongTacBaiViet(maBaiViet);
		for (TuongTacBaiViet item : top3TuongTacBaiViets) {
			top3TuongTacStrings.add(item.getTrangThai());
		}
		JsonArray top3TuongJsonArray = new Gson().toJsonTree(top3TuongTacStrings).getAsJsonArray();

		Map<String, String> json = new LinkedHashMap<String, String>();
		json.put("tongLuotTT", String.valueOf(tongLuotTT));
		json.put("topTuongTac", top3TuongJsonArray.toString());
		String jsonObject = new Gson().toJson(json);
		return jsonObject;
	}

}
