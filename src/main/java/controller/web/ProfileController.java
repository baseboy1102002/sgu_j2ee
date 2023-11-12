package controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet("/ProfileController")
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userID = request.getAttribute("userID").toString();
		String userID = "4";
		int currentUID = 4;
//		int user = Integer.parseInt(request.getParameter("id"));
		List<BaiViet> baiviets = new ArrayList<>();
		BaiVietService bvSV = new BaiVietService();
		baiviets = bvSV.getBaiVietsByUserID(userID);
		List<BaiVietView> baiVietViews = new ArrayList<>();
		NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(Integer.parseInt(userID));
		List<ThongTinKetBan> friends = thongTinKetBanService.geThongTinKetBansLaBan(Integer.parseInt(userID));

		int count = 0;
		for (ThongTinKetBan friend : friends) {
			if("daketban".equals(friend.getTrangThai())) {
				count++;
			}
		}
		
		for (BaiViet baiViet : baiviets) {
			baiVietViews.add(getDataBaiVietForView(baiViet.getMaBaiViet(), Integer.parseInt(userID)));
		}
		
		
		request.setAttribute("currentUID", currentUID);
		request.setAttribute("songuoiban", count);
		request.setAttribute("baiVietViews", baiVietViews);
		request.setAttribute("nguoiDung", nguoiDung);
		request.getRequestDispatcher("views/ca-nhan.jsp").forward(request, response);
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

		NguoiDung nguoiDang = nguoiDungService.getNguoiDungById(baiViet.getMaNguoiDung());
		String anhDaiDienNguoiDang = nguoiDang.getHinhDaiDien();
		String hoVaTenNguoiDang = nguoiDang.getHoVaTen();

		BaiVietView baiVietView = new BaiVietView(baiViet, loginUserTuongTacBaiViet, fileHinhAnhs, fileDinhKems,
				top3TuongTacBaiViets, binhLuanCount, tongLuotTuongTac, anhDaiDienNguoiDang, hoVaTenNguoiDang);
		System.out.println("maBaiViet "+maBaiViet);
		System.out.println("top3 TT "+top3TuongTacBaiViets);
		return baiVietView;

	}
}
