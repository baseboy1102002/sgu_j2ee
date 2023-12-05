package controller.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import model.BaiViet;
import model.BaiVietView;
import model.BaoCaoBinhLuan;
import model.BinhLuanBaiViet;
import model.BinhLuanView;
import model.FileBaiViet;
import model.NguoiDung;
import model.TuongTacBaiViet;
import model.TuongTacBinhLuan;
import service.BaiVietService;
import service.BaoCaoBinhLuanService;
import service.BinhLuanBaiVietService;
import service.FileBaiVietService;
import service.NguoiDungService;
import service.TuongTacBaiVietService;
import service.TuongTacBinhLuanService;

/**
 * Servlet implementation class ChiTietBaiVietController
 */
@WebServlet("/chitietbaiviet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ChiTietBaiVietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaiVietService baiVietService = new BaiVietService();
	private TuongTacBaiVietService tuongTacBaiVietService = new TuongTacBaiVietService();
	private NguoiDungService nguoiDungService = new NguoiDungService();
	private TuongTacBinhLuanService tuongTacBinhLuanService = new TuongTacBinhLuanService();
	private BinhLuanBaiVietService binhLuanBaiVietService = new BinhLuanBaiVietService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChiTietBaiVietController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maBaiViet = request.getParameter("maBaiViet");
		int maNguoiDung = SessionManager.getID(request);




		BaiVietView baiVietView = getDataBaiVietForView(Integer.parseInt(maBaiViet), maNguoiDung);
		List<BinhLuanView> binhLuanViews = new ArrayList<>();
		List<BinhLuanBaiViet> binhLuanBaiViets = binhLuanBaiVietService
				.getBinhLuansByBaiVietId(Integer.parseInt(maBaiViet));
		for (BinhLuanBaiViet binhLuanBaiViet : binhLuanBaiViets) {
			binhLuanViews.add(getDataForBinhLuanView(binhLuanBaiViet, maNguoiDung));
		}


		request.setAttribute("baiVietView", baiVietView);
		request.setAttribute("binhLuanBaiViewList", binhLuanViews);

		request.getRequestDispatcher("views/chi-tiet-bai-viet.jsp").forward(request, response);

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

		File dir = new File(request.getServletContext().getRealPath("/files"));
		if (!dir.exists()) {
			dir.mkdirs();
		}

		switch (action) {
		case "addBinhLuan": {

			BinhLuanBaiViet binhLuanBaiViet = new BinhLuanBaiViet();

			String noiDung = request.getParameter("noiDung");
			int maBaiViet = Integer.parseInt(request.getParameter("maBaiViet"));
			int maNguoiDung = SessionManager.getID(request);
			Date ngayGioBinhLuan = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			String formattedDate = dateFormat.format(ngayGioBinhLuan);
			String formattedDate2 = dateFormat2.format(ngayGioBinhLuan);
			Part filePart = request.getPart("anhBinhLuan");

			binhLuanBaiViet.setMaBaiViet(maBaiViet);
			binhLuanBaiViet.setMaNguoiDung(maNguoiDung);
			binhLuanBaiViet.setNgayGioBinhLuan(ngayGioBinhLuan);
			binhLuanBaiViet.setTrangThai("new");
			binhLuanBaiViet.setNoiDung(noiDung);
			String fileName = "";
			if (filePart.getSubmittedFileName() != null) {

				fileName = "comment_" + maBaiViet + "_" + maNguoiDung + "_" + formattedDate2
						+ filePart.getSubmittedFileName();

				File file = new File(dir, fileName);
				filePart.write(file.getAbsolutePath());
			}
			binhLuanBaiViet.setAnhBinhLuan(fileName);

			NguoiDung nguoiDang = nguoiDungService.getNguoiDungById(maNguoiDung);
			Integer maBinhLuan = binhLuanBaiVietService.addBinhLuan(binhLuanBaiViet);

			Map<String, String> json = new LinkedHashMap<>();
			json.put("maBinhLuan", String.valueOf(maBinhLuan));
			json.put("anhBinhLuan", fileName);
			json.put("ngayGioBinhLuan", formattedDate);
			json.put("anhDaiDienNguoiDang", nguoiDang.getHinhDaiDien());
			json.put("hoVaTenNguoiDang", nguoiDang.getHoVaTen());

			String jsonObject = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(json);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			printWriter.write(jsonObject);

			break;
		}
		case "editBinhLuan": {
			int maBinhLuan = Integer.parseInt(request.getParameter("maBinhLuan"));
			BinhLuanBaiViet binhLuanBaiViet = binhLuanBaiVietService.getBinhLuanBaiVietById(maBinhLuan);
			Date ngayGioBinhLuan = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

			String formattedDate = dateFormat.format(ngayGioBinhLuan);
			String formattedDate2 = dateFormat2.format(ngayGioBinhLuan);

			String noiDung = request.getParameter("noiDung");
			Part filePart = request.getPart("anhBinhLuan");
			String imgSrc = request.getParameter("imgSrc");
			File deleteFile = new File(dir, binhLuanBaiViet.getAnhBinhLuan());

			String fileName = binhLuanBaiViet.getAnhBinhLuan(); // Default to the existing file name

			if (filePart.getSubmittedFileName() != null ) {
				fileName = "comment_" + binhLuanBaiViet.getMaBaiViet() + "_" + binhLuanBaiViet.getMaNguoiDung() + "_"
						+ formattedDate2 + filePart.getSubmittedFileName();

				File file = new File(dir, fileName);
				filePart.write(file.getAbsolutePath());
				// Delete the old file only if a new file is uploaded
				if (deleteFile.exists()) {
					deleteFile.delete();
				}
			} else if ( (imgSrc == null || imgSrc.isEmpty())) {
				// No new file is selected, and imgSrc is null or empty, do not delete the old
				// file
				if (deleteFile.exists()) {
					deleteFile.delete();
				}
				fileName = "";
			} else {
				// No new file is selected, delete the old file

			}
			binhLuanBaiViet.setAnhBinhLuan(fileName);
			binhLuanBaiViet.setNoiDung(noiDung);

			binhLuanBaiVietService.updateBinhLuan(binhLuanBaiViet);

			Map<String, String> json = new LinkedHashMap<>();
			json.put("anhBinhLuan", fileName);
			json.put("ngayGioBinhLuan", formattedDate);

			String jsonObject = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(json);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			printWriter.write(jsonObject);

			break;
		}
		case "react":{
			int maBinhLuan = Integer.parseInt(request.getParameter("maBinhLuan"));
			int maNguoiDung = SessionManager.getID(request); //Lấy session
			String trangThai = request.getParameter("trangThai");
			Date ngayGioTuong = new Date();
			TuongTacBinhLuan loginUserTuongTacBinhLuanBaiViet = tuongTacBinhLuanService.getUserTuongTacBinhLuan(maBinhLuan, maNguoiDung);
			if(loginUserTuongTacBinhLuanBaiViet == null) {


				TuongTacBinhLuan tempTuongTacBinhLuan = new TuongTacBinhLuan(maNguoiDung, maBinhLuan, ngayGioTuong, trangThai);
				tuongTacBinhLuanService.addTuongTacBinhLuan(tempTuongTacBinhLuan);
			}
			else {
				loginUserTuongTacBinhLuanBaiViet.setNgayGioTuongTac(ngayGioTuong);
				loginUserTuongTacBinhLuanBaiViet.setTrangThai(trangThai);
				tuongTacBinhLuanService.updateTuongTacBinhLuan(loginUserTuongTacBinhLuanBaiViet);
			}

			printWriter.print(layDuLieuTuongTacTraVe(maBinhLuan));

			break;
		}
		case "deleteTuongBinhLuan":{
			int maBinhLuan = Integer.parseInt(request.getParameter("maBinhLuan")) ;
			int maNguoiDung = SessionManager.getID(request);


			tuongTacBinhLuanService.deleteTuongTacBinhLuan(maBinhLuan, maNguoiDung);


//			get dữ liệu trả về
			response.setContentType("application/json");
			response.setContentType("UTF-8");
			printWriter.print(layDuLieuTuongTacTraVe(maBinhLuan));

			break;
		}
		case "deleteComment":{
			int maBinhLuan = Integer.parseInt(request.getParameter("maBinhLuan")) ;


			BinhLuanBaiViet binhLuanBaiViet = binhLuanBaiVietService.getBinhLuanBaiVietById(maBinhLuan);
			File oldFile = new File(dir,binhLuanBaiViet.getAnhBinhLuan());
			if(oldFile.exists()) {
				oldFile.delete();
			}


			printWriter.print(binhLuanBaiVietService.deleteBinhLuanById(maBinhLuan));

			break;
		}
		case "commentReport":{
			int maBinhLuan = Integer.parseInt(request.getParameter("maBinhLuan"));
			String liDo = request.getParameter("liDo");
			int maNguoiDung = SessionManager.getID(request);
			BaoCaoBinhLuanService baoCaoBinhLuanService = new BaoCaoBinhLuanService();
			BaoCaoBinhLuan baoCaoBinhLuan = new BaoCaoBinhLuan(maNguoiDung, maBinhLuan, new Date(), liDo);
			response.setContentType("UTF-8");
			printWriter.print(baoCaoBinhLuanService.insert(baoCaoBinhLuan));

			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}

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
		int maNguoiDang = nguoiDang.getMaNguoiDung();

		BaiVietView baiVietView = new BaiVietView(baiViet, loginUserTuongTacBaiViet, fileHinhAnhs, fileDinhKems,
				top3TuongTacBaiViets, binhLuanCount, tongLuotTuongTac, maNguoiDang, anhDaiDienNguoiDang, hoVaTenNguoiDang);

		return baiVietView;

	}

	public BinhLuanView getDataForBinhLuanView(BinhLuanBaiViet binhLuanBaiViet, int maLoginUser) {
		int tongLuotTT = tuongTacBinhLuanService.getTongSoTuongTacBinhLuan(binhLuanBaiViet.getMaBinhLuan());
		TuongTacBinhLuan loginUserTuongTacBinhLuan = tuongTacBinhLuanService
				.getUserTuongTacBinhLuan(binhLuanBaiViet.getMaBinhLuan(), maLoginUser);
		List<TuongTacBinhLuan> top3TuongTacBinhLuans = tuongTacBinhLuanService
				.getTop3TuongTacBinhLuan(binhLuanBaiViet.getMaBinhLuan());
		NguoiDung nguoiDang = nguoiDungService.getNguoiDungById(binhLuanBaiViet.getMaNguoiDung());
		String hoVaTenNguoiDang = nguoiDang.getHoVaTen();
		String anhDaiDienNguoiDang = nguoiDang.getHinhDaiDien();
		int maNguoiDang = nguoiDang.getMaNguoiDung();

		BinhLuanView binhLuanView = new BinhLuanView(binhLuanBaiViet, tongLuotTT, loginUserTuongTacBinhLuan,
				top3TuongTacBinhLuans, anhDaiDienNguoiDang, hoVaTenNguoiDang, maNguoiDang);

		return binhLuanView;
	}


	private String layDuLieuTuongTacTraVe(int maBinhLuan) {
		List<TuongTacBinhLuan> top3TuongTacBinhLuans = tuongTacBinhLuanService.getTop3TuongTacBinhLuan(maBinhLuan);
		List<String> top3TuongTacBinhLuanStrings = new ArrayList<>();
		int tongLuotTT = tuongTacBinhLuanService.getTongSoTuongTacBinhLuan(maBinhLuan);
		for(TuongTacBinhLuan tuongTacBinhLuan : top3TuongTacBinhLuans) {
			top3TuongTacBinhLuanStrings.add(tuongTacBinhLuan.getTrangThai());
		}
		JsonArray top3TuongJsonArray = new Gson().toJsonTree(top3TuongTacBinhLuanStrings).getAsJsonArray();

		Map<String, String> json = new LinkedHashMap<>();
		json.put("tongLuotTT", String.valueOf(tongLuotTT));
		json.put("topTuongTac", top3TuongJsonArray.toString());
		String jsonObject = new Gson().toJson(json);
		return jsonObject;
	}

}
