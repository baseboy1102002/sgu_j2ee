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
import service.BinhLuanBaiVietService;
import service.FileBaiVietService;
import service.NguoiDungService;
import service.SearchService;
import service.TuongTacBaiVietService;
import service.TuongTacBinhLuanService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaiVietService baiVietService = new BaiVietService();
	private TuongTacBaiVietService tuongTacBaiVietService = new TuongTacBaiVietService();
	private NguoiDungService nguoiDungService = new NguoiDungService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	private SearchService searchService = null;
    public SearchServlet() {
        super();
        searchService = new SearchService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
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
		System.out.println(baiViet.getMaNguoiDung());
		NguoiDung nguoiDang = nguoiDungService.getNguoiDungById(baiViet.getMaNguoiDung());
		
		String anhDaiDienNguoiDang = nguoiDang.getHinhDaiDien();
		String hoVaTenNguoiDang = nguoiDang.getHoVaTen();
		int maNguoiDang = nguoiDang.getMaNguoiDung();
		BaiVietView baiVietView = new BaiVietView(baiViet, loginUserTuongTacBaiViet, fileHinhAnhs, fileDinhKems,
				top3TuongTacBaiViets, binhLuanCount, tongLuotTuongTac, maNguoiDang, anhDaiDienNguoiDang, hoVaTenNguoiDang);


		return baiVietView;

	}
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keySearch = request.getParameter("keySearch");
		String context = request.getParameter("type");
		if(keySearch != null && !keySearch.equalsIgnoreCase("")) {
			if(context != null && context.equalsIgnoreCase("users")) {
				List<NguoiDung> users = searchService.findUsers(keySearch, 1);
				request.setAttribute("users", users.isEmpty() ? null : users);
			} else if(context != null && context.equalsIgnoreCase("posts")) {
				List<BaiViet> baiViets = searchService.findPosts(keySearch);
				List<BaiVietView> baiVietViews = new ArrayList<BaiVietView>();
				for(BaiViet i : baiViets) {
					baiVietViews.add(getDataBaiVietForView(i.getMaBaiViet(), 4));
				}
				request.setAttribute("posts", baiVietViews.isEmpty() ? null : baiVietViews);
			} else {
				List<NguoiDung> users = searchService.findUsers(keySearch, 4);
				request.setAttribute("users", users.isEmpty() ? null : users);
				
				List<BaiViet> baiViets = searchService.findPosts(keySearch);
				List<BaiVietView> baiVietViews = new ArrayList<BaiVietView>();
				for(BaiViet i : baiViets) {
					baiVietViews.add(getDataBaiVietForView(i.getMaBaiViet(), 4));
				}
				request.setAttribute("posts", baiVietViews.isEmpty() ? null : baiVietViews);
			}			
		}
		request.setAttribute("context", context);
		request.setAttribute("keySearch", keySearch);
		request.getRequestDispatcher("/views/searchPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}