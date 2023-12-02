package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@MultipartConfig
public class UploadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/upload/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File dir = new File(req.getServletContext().getRealPath("/files"));
		System.out.println(dir);
		if (!dir.exists()) { 
			dir.mkdirs();
		}
		Part photo = req.getPart("photo_file");
		File photoFile = new File(dir, photo.getSubmittedFileName());
		photo.write(photoFile.getAbsolutePath());
		Part doc = req.getPart("doc_file");
		File docFile = new File(dir, doc.getSubmittedFileName());
		doc.write(docFile.getAbsolutePath());
		req.setAttribute("img", photoFile);
		req.setAttribute("doc", docFile);
		req.getRequestDispatcher("/views/bai1/result.jsp").forward(req, resp);
	}
}
