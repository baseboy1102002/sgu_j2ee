package controller.web;

import java.io.IOException;
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
import model.TuongTacBaiViet;
import service.BaiVietService;
import service.FileBaiVietService;
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String maBaiViet = request.getParameter("maBaiViet");
		int maNguoiDung = 1;
		BaiVietView baiVietView = getDataBaiVietForView(Integer.parseInt(maBaiViet), maNguoiDung);
		response.getWriter().print(baiVietView);
		
		
		
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
		List<FileBaiViet> fileHinhAnhs = fileBaiViets.stream()
			    .filter(file -> "Anh".equals(file.getTrangThai()))
			    .collect(Collectors.toList());
		List<FileBaiViet> fileDinhKems = fileBaiViets.stream()
			    .filter(file -> "File".equals(file.getTrangThai()))
			    .collect(Collectors.toList());
		
		
		BaiVietView baiVietView = new BaiVietView(baiViet, loginUserTuongTacBaiViet, fileHinhAnhs, fileDinhKems, top3TuongTacBaiViets, binhLuanCount, tongLuotTuongTac);
		
		
		return baiVietView;
	}
	
}
