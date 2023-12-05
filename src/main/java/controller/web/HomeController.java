package controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BaiViet;
import model.BaiVietView;
import model.FileBaiViet;
import model.NguoiDung;
import model.TuongTacBaiViet;
import service.BaiVietService;
import service.FileBaiVietService;
import service.NguoiDungService;
import service.TuongTacBaiVietService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/trang-chu")
public class HomeController extends HttpServlet {
	private BaiVietService baiVietService = new BaiVietService();
	private TuongTacBaiVietService tuongTacBaiVietService = new TuongTacBaiVietService();
	private NguoiDungService nguoiDungService = new NguoiDungService();
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Integer> maBaiVietList = baiVietService.getBaiVietForHomePage(SessionManager.getID(request));
		
		List<BaiVietView> baiVietViews = new ArrayList<>();
		for (Integer baiVietID : maBaiVietList) {
			baiVietViews.add(getDataBaiVietForView(baiVietID, SessionManager.getID(request) ));
		}
		
		//List<Integer> maBaiVietList = baiVietService.getBaiVietForHomePage(SessionManager.getID(request));
		//System.out.println(maBaiVietList);
		//List<BaiVietView> baiVietViews =  maBaiVietList.stream().map(e -> getDataBaiVietForView(e, SessionManager.getID(request))).toList();
		request.setAttribute("baiVietViews", baiVietViews);
		request.getRequestDispatcher("views/Home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		List<FileBaiViet> fileHinhAnhs = new ArrayList<>();
		List<FileBaiViet> fileDinhKems = new ArrayList<>();
		for (FileBaiViet fileBaiViet : fileBaiViets) {
			if (fileBaiViet.getLoaiFile().equals("Anh")) {
				fileHinhAnhs.add(fileBaiViet);
			} else if (fileBaiViet.getLoaiFile().equals("File")) {
				fileDinhKems.add(fileBaiViet);
			}
		}
		System.out.println(baiViet);
		NguoiDung nguoiDang = nguoiDungService.getNguoiDungById(baiViet.getMaNguoiDung());
		
		String anhDaiDienNguoiDang = nguoiDang.getHinhDaiDien();
		String hoVaTenNguoiDang = nguoiDang.getHoVaTen();
		int maNguoiDang = nguoiDang.getMaNguoiDung();

		BaiVietView baiVietView = new BaiVietView(baiViet, loginUserTuongTacBaiViet, fileHinhAnhs, fileDinhKems,
				top3TuongTacBaiViets, binhLuanCount, tongLuotTuongTac, maNguoiDang, anhDaiDienNguoiDang, hoVaTenNguoiDang);

		return baiVietView;

	}

}
