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

import model.BaoCaoBaiviet;
import model.TuongTacBaiViet;
import service.BaiVietService;
import service.BaoCaoBaiVietService;
import service.FileBaiVietService;
import service.TuongTacBaiVietService;

/**
 * Servlet implementation class BaiVietController
 */
@WebServlet("/baiviet")
public class BaiVietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TuongTacBaiVietService tuongTacBaiVietService ;
	private BaiVietService baiVietService;
	private FileBaiVietService fileBaiVietService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaiVietController() {
		super();
		baiVietService = new BaiVietService();
		tuongTacBaiVietService = new TuongTacBaiVietService();
		fileBaiVietService = new FileBaiVietService();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter printWriter = response.getWriter();
		switch (action) {
		case "delete": {
			String maBaiViet = request.getParameter("maBaiViet");
			fileBaiVietService.deleteFileBaiVietByMaBaiViet(Integer.parseInt(maBaiViet), request);
			printWriter.print(baiVietService.deleteBaiVietById(Integer.parseInt(maBaiViet)));
			break;
		}
		case "react": {
			String maBaiViet = request.getParameter("maBaiViet");
			int maNguoiDung = SessionManager.getID(request); //Session
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
		case "report":{
			BaoCaoBaiVietService baoCaoBaiVietService = new BaoCaoBaiVietService();
			int maNguoiDung = SessionManager.getID(request);
			String liDo = request.getParameter("liDo");
			int maBaiViet = Integer.parseInt( request.getParameter("maBaiViet"));
			BaoCaoBaiviet baoCaoBaiviet = new BaoCaoBaiviet(maNguoiDung, maBaiViet, new Date(), liDo);
			
			response.setContentType("UTF-8");
			Integer result = baoCaoBaiVietService.insert(baoCaoBaiviet);
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}

	}

	private String getDuLieuTuongTacTraVe(int maBaiViet) {
		List<TuongTacBaiViet> top3TuongTacBaiViets = tuongTacBaiVietService.getTop3TuongTacBaiViet(maBaiViet);
		List<String> top3TuongTacStrings = new ArrayList<>();
		int tongLuotTT = tuongTacBaiVietService.getTongLuotTuongTacBaiViet(maBaiViet);
		for (TuongTacBaiViet item : top3TuongTacBaiViets) {
			top3TuongTacStrings.add(item.getTrangThai());
		}
		JsonArray top3TuongJsonArray = new Gson().toJsonTree(top3TuongTacStrings).getAsJsonArray();

		Map<String, String> json = new LinkedHashMap<>();
		json.put("tongLuotTT", String.valueOf(tongLuotTT));
		json.put("topTuongTac", top3TuongJsonArray.toString());
		String jsonObject = new Gson().toJson(json);
		return jsonObject;
	}

}
