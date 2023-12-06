package controller.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import controller.web.SessionManager;
import model.BaiViet;
import model.BaiVietView;
import model.FileBaiViet;
import model.NguoiDung;
import service.BaiVietService;
import service.FileBaiVietService;
import service.NguoiDungService;

@WebServlet(urlPatterns = { "/api/post" })
public class PostApi extends HttpServlet {

	private static final long serialVersionUID = 3739265568460414533L;
	private BaiVietService baiVietService = new BaiVietService();
	private FileBaiVietService fileBaiVietService = new FileBaiVietService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		int MaBaiViet = Integer.parseInt(req.getParameter("MaBaiViet"));
		BaiViet baiViet = baiVietService.getBaiVietById(MaBaiViet);
		List<FileBaiViet> fileBaiViets = fileBaiVietService.getFileBaiVietsByMaBaiViet(MaBaiViet);
		List<FileBaiViet> fileHinhAnhs = fileBaiViets.stream().filter(e->e.getLoaiFile().equals("Anh")).toList();
		List<FileBaiViet> fileDinhKems = fileBaiViets.stream().filter(e->e.getLoaiFile().equals("File")).toList();
		BaiVietView baiVietView = new BaiVietView();
		baiVietView.setBaiViet(baiViet);
		baiVietView.setFileHinhAnhs(fileHinhAnhs);
		baiVietView.setFileDinhKems(fileDinhKems);

		String responseJson = new Gson().toJson(baiVietView);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(responseJson);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		BaiViet baiviet = new BaiViet();
		baiviet.setNoiDung(req.getParameter("NoiDung"));
		baiviet.setMaNguoiDung(SessionManager.getID(req));
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
		 String requestBody = req.getReader().lines().collect(Collectors.joining());
		 JsonObject json = new Gson().fromJson(requestBody, JsonObject.class);
		 String NoiDung = json.get("noi_dung").getAsString();
		 JsonArray jsonMaFile = json.get("file_id").getAsJsonArray();
		 if(jsonMaFile.size()>0) {
			 JsonArray jsonTenFile = json.get("file_id").getAsJsonArray();
			 List<Integer> ListMaFile = new ArrayList<>();
			 jsonMaFile.forEach(e-> ListMaFile.add(e.getAsInt()));
			 List<String> ListTenFile = new ArrayList<>();
			 jsonTenFile.forEach(e-> ListTenFile.add(e.getAsString()));
			 fileBaiVietService.deleteFileBaiViet(ListMaFile, ListTenFile, req);
			 baiVietService.updateBaiViet(NoiDung, MaBaiViet);
		 } else {
			 baiVietService.updateBaiViet(NoiDung, MaBaiViet);
		 }
		BaiViet baiViet = baiVietService.getBaiVietById(MaBaiViet);
		List<FileBaiViet> fileBaiViets = fileBaiVietService.getFileBaiVietsByMaBaiViet(MaBaiViet);
		List<FileBaiViet> fileHinhAnhs = fileBaiViets.stream().filter(e->e.getLoaiFile().equals("Anh")).toList();
		List<FileBaiViet> fileDinhKems = fileBaiViets.stream().filter(e->e.getLoaiFile().equals("File")).toList();
		BaiVietView baiVietView = new BaiVietView();
		baiVietView.setBaiViet(baiViet);
		baiVietView.setFileHinhAnhs(fileHinhAnhs);
		baiVietView.setFileDinhKems(fileDinhKems);
		NguoiDungService nguoiDungService = new NguoiDungService();
		NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(baiViet.getMaNguoiDung());
		baiVietView.setAnhDaiDienNguoiDang(nguoiDung.getHinhDaiDien());
		baiVietView.setHoVaTenNguoiDang(nguoiDung.getHoVaTen());
		String responseJson = new Gson().toJson(baiVietView);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(responseJson);

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		int MaBaiViet = Integer.parseInt(req.getParameter("MaBaiViet"));
		fileBaiVietService.deleteFileBaiVietByMaBaiViet(MaBaiViet, req);
		baiVietService.deleteBaiViet(MaBaiViet);
		resp.getWriter().write("Xóa bài viết thành công");
	}
}
