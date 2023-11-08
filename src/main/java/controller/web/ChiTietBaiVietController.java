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
import model.FileBaiViet;
import model.NguoiDung;
import model.TuongTacBaiViet;
import service.BaiVietService;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietBaiVietController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maBaiViet = request.getParameter("maBaiViet");
		int maNguoiDung = 4;
		
		BaiVietView baiVietView = getDataBaiVietForView(Integer.parseInt(maBaiViet), maNguoiDung);
		
		
		request.setAttribute("baiVietView", baiVietView);
		
		request.getRequestDispatcher("views/chi-tiet-bai-viet.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public BaiVietView getDataBaiVietForView(int maBaiViet,int maNguoiDung) {
		BaiVietService baiVietService = new BaiVietService();
		BaiViet baiViet = baiVietService.getBaiVietById(maBaiViet);

		
		TuongTacBaiVietService tuongTacBaiVietService = new TuongTacBaiVietService();
		TuongTacBaiViet loginUserTuongTacBaiViet = tuongTacBaiVietService.getUserTuongTacBaiViet(maBaiViet, maNguoiDung);
		List<TuongTacBaiViet> top3TuongTacBaiViets = tuongTacBaiVietService.getTop3TuongTacBaiViet(maBaiViet);
		int tongLuotTuongTac = tuongTacBaiVietService.getTongLuotTuongTacBaiViet(maBaiViet);
		
		TuongTacBinhLuanService tuongTacBinhLuanService = new TuongTacBinhLuanService();
		int binhLuanCount = tuongTacBaiVietService.getTongLuotTuongTacBaiViet(maBaiViet);
		
		FileBaiVietService fileBaiVietService = new FileBaiVietService();
		List<FileBaiViet> fileBaiViets = fileBaiVietService.getFileBaiVietsByMaBaiViet(maBaiViet);
		List<FileBaiViet> fileHinhAnhs = new ArrayList<FileBaiViet>();
		List<FileBaiViet> fileDinhKems = new ArrayList<FileBaiViet>();
		for (FileBaiViet fileBaiViet : fileBaiViets) {
			if(fileBaiViet.getLoaiFile().equals("Anh")) {
				fileHinhAnhs.add(fileBaiViet);
			}
			else if(fileBaiViet.getLoaiFile().equals("File")) {
				fileDinhKems.add(fileBaiViet);
			}
		}
		
		
		
		NguoiDungService nguoiDungService = new NguoiDungService();
		NguoiDung nguoiDang = nguoiDungService.getNguoiDungById(baiViet.getMaNguoiDung());
		String anhDaiDienNguoiDang = nguoiDang.getHinhDaiDien();
		String hoVaTenNguoiDang = nguoiDang.getHoVaTen();
		
		BaiVietView baiVietView =  new BaiVietView(baiViet, loginUserTuongTacBaiViet, fileHinhAnhs, fileDinhKems, top3TuongTacBaiViets, binhLuanCount, tongLuotTuongTac, anhDaiDienNguoiDang, hoVaTenNguoiDang);

		
		return baiVietView;
		
	}
	
}
