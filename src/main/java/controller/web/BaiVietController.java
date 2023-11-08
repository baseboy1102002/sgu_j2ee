package controller.web;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaiVietService;

/**
 * Servlet implementation class BaiVietController
 */
@WebServlet("/baiviet")
public class BaiVietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaiVietController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		BaiVietService baiVietService = new BaiVietService();
		PrintWriter printWriter = response.getWriter();
		switch (action) {
		case "delete": {
			String maBaiViet = request.getParameter("maBaiViet");
			
			printWriter.print(baiVietService.deleteBaiVietById(Integer.parseInt(maBaiViet)));
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		
	}

}
