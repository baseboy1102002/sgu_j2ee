package controller.api;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BaiViet;
import service.BaiVietService;
import service.FileBaiVietService;

@WebServlet (urlPatterns = {"/api/post"})
public class PostApi extends HttpServlet{

	private static final long serialVersionUID = 3739265568460414533L;
	private BaiVietService baiVietService = new BaiVietService();
	private FileBaiVietService fileBaiVietService = new FileBaiVietService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BaiViet baiviet = new BaiViet();
		baiviet.setNoiDung(req.getParameter("NoiDung"));
		baiviet.setMaNguoiDung(1);
		baiviet.setTrangThai("yes");
		baiviet.setNgayDang(new Date());
		int postId = baiVietService.saveBaiViet(baiviet);
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(String.valueOf(postId));
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		int MaBaiViet = Integer.parseInt(req.getParameter("MaBaiViet"));
		String NoiDung = req.getReader().lines().collect(Collectors.joining());
		baiVietService.updateBaiViet(NoiDung, MaBaiViet);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		int MaBaiViet = Integer.parseInt(req.getParameter("MaBaiViet"));
		if (fileBaiVietService.deleteAllFileBaiViet(MaBaiViet))
			baiVietService.deleteBaiViet(MaBaiViet);
		resp.getWriter().write("Xóa bài viết thành công");
	}
}
