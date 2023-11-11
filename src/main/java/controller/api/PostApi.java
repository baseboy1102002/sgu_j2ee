package controller.api;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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

import model.BaiViet;
import service.BaiVietService;
import service.FileBaiVietService;

@WebServlet(urlPatterns = { "/api/post" })
public class PostApi extends HttpServlet {

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
			 if (fileBaiVietService.deleteFileBaiViet(ListMaFile, ListTenFile, req));
			 baiVietService.updateBaiViet(NoiDung, MaBaiViet);
		 } else {
			 baiVietService.updateBaiViet(NoiDung, MaBaiViet);
		 }
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		int MaBaiViet = Integer.parseInt(req.getParameter("MaBaiViet"));
		if (fileBaiVietService.deleteFileBaiVietByMaBaiViet(MaBaiViet, req))
			baiVietService.deleteBaiViet(MaBaiViet);
		resp.getWriter().write("Xóa bài viết thành công");
	}
}
