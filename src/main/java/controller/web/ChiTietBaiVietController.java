package controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BaiViet;
import model.BaiVietView;
import model.BinhLuanBaiViet;
import model.BinhLuanView;
import model.FileBaiViet;
import model.NguoiDung;
import model.TuongTacBaiViet;
import model.TuongTacBinhLuan;
import service.BaiVietService;
import service.BinhLuanBaiVietService;
import service.FileBaiVietService;
import service.NguoiDungService;
import service.TuongTacBaiVietService;
import service.TuongTacBinhLuanService;

/**
 * Servlet implementation class ChiTietBaiVietController
 */
@WebServlet("/chitietbaiviet")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maBaiViet = request.getParameter("maBaiViet");
		int maNguoiDung = 4;

		BaiVietView baiVietView = getDataBaiVietForView(Integer.parseInt(maBaiViet), maNguoiDung);
		List<BinhLuanView> binhLuanViews = new ArrayList<BinhLuanView>();
		List<BinhLuanBaiViet> binhLuanBaiViets = binhLuanBaiVietService.getBinhLuansByBaiVietId(Integer.parseInt(maBaiViet));
		for(BinhLuanBaiViet binhLuanBaiViet : binhLuanBaiViets) {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
		List<FileBaiViet> fileHinhAnhs = new ArrayList<FileBaiViet>();
		List<FileBaiViet> fileDinhKems = new ArrayList<FileBaiViet>();
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

	public BinhLuanView getDataForBinhLuanView(BinhLuanBaiViet binhLuanBaiViet,int maLoginUser) {
		int tongLuotTT = tuongTacBinhLuanService.getTongSoTuongTacBinhLuan(binhLuanBaiViet.getMaBinhLuan());
		TuongTacBinhLuan loginUserTuongTacBinhLuan = tuongTacBinhLuanService.getUserTuongTacBinhLuan(binhLuanBaiViet.getMaBinhLuan(), maLoginUser);
		List<TuongTacBinhLuan> top3TuongTacBinhLuans = tuongTacBinhLuanService.getTop3TuongTacBinhLuan(binhLuanBaiViet.getMaBinhLuan());
		NguoiDung nguoiDang = nguoiDungService.getNguoiDungById(binhLuanBaiViet.getMaNguoiDung());
		String hoVaTenNguoiDang = nguoiDang.getHoVaTen();
		String anhDaiDienNguoiDang = nguoiDang.getHinhDaiDien();
		
		
		BinhLuanView binhLuanView = new BinhLuanView(binhLuanBaiViet, tongLuotTT, loginUserTuongTacBinhLuan, top3TuongTacBinhLuans, anhDaiDienNguoiDang, hoVaTenNguoiDang);
		
		
		return binhLuanView;
	}

}
