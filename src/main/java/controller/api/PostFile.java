package controller.api;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;

import model.FileBaiViet;
import service.FileBaiVietService;

@WebServlet (urlPatterns = {"/api/post_file"})
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 20,      // 20 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class PostFile extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FileBaiVietService fileBaiVietService = new FileBaiVietService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File dir = new File(req.getServletContext().getRealPath("/files"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		Part filePart;
		boolean isImageFile = false;
		if (req.getPart("img_file") != null) {
			filePart = req.getPart("img_file");
			isImageFile = true;
		} else filePart = req.getPart("file");

		String fileName = filePart.getSubmittedFileName()+String.valueOf(new Date().getTime());
		File file = new File(dir, fileName);
		filePart.write(file.getAbsolutePath());

		FileBaiViet fileBaiViet = new FileBaiViet();
		fileBaiViet.setTenFile(fileName);
		fileBaiViet.setLoaiFile(isImageFile ? "Anh":"File");
		fileBaiViet.setMaBaiViet(Integer.parseInt(req.getParameter("postId")));
		fileBaiViet.setTrangThai("yes");
		int fileId = fileBaiVietService.saveFileBaiViet(fileBaiViet);

		Map<String, String> json = new LinkedHashMap<>();
		json.put("file_id", String.valueOf(fileId));
		json.put("file_name", fileBaiViet.getTenFile());
		if (fileBaiViet.getLoaiFile().equals("File"))
			json.put("file_extension", FilenameUtils.getExtension(fileName).toUpperCase());
		String jsonObject = new Gson().toJson(json);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(jsonObject);
	}
}
