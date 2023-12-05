package controller.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.NguoiDungService;

@WebServlet("/cai-dat")
@MultipartConfig
public class settingServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = -5777195563665546188L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve user information from session
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("inputName");
		String email = request.getParameter("inputEmail");
		String Strdob = request.getParameter("inputDoB");
		String phone = request.getParameter("inputPhone");

		Part photo = request.getPart("inputImage");
		String newFileName = SessionManager.getID(request) + "_ProfilePicture.png";
		File dir = new File(request.getServletContext().getRealPath("/files"));
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	    File newPhotoFile = new File(dir, newFileName);
	    photo.write(newPhotoFile.getAbsolutePath());
		System.out.println(dir);
		System.out.println(newFileName);

		NguoiDungService userService = new NguoiDungService();
		try {
            if (userService.CaiDat(email, newFileName, name, phone, Strdob, SessionManager.getID(request))) {
                // Confirmation code matched, and the status is updated
            	System.out.println("ok");
        		java.sql.Date dob = java.sql.Date.valueOf(Strdob);
				SessionManager.setDoB(request, dob);
				SessionManager.setEmail(request, email);
				SessionManager.setName(request, name);
				SessionManager.setPhone(request, phone);
				SessionManager.setIMG(request, newFileName);
            } else {
            	System.out.println("not ok");
            }

        } finally {
            // Close resources in a finally block

        }

		request.getRequestDispatcher("views/Setting.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
