package controller.web;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.baiviet;
import model.nguoidung;
import model.thongbao;

import service.BaivietService;
import service.ThongbaoService;


@WebServlet("/thongbao")
public class ThongBaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongBaoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ThongbaoService tbService = new ThongbaoService();
		List<thongbao> thongbaos = new ArrayList<>();
		nguoidung user = new nguoidung(1, null, null, null, null, null, null, null, null, null, null, null);


		
		thongbaos = tbService.getThongBao(user);
		
		/*
		 * BaivietService BVservice = new BaivietService(); List<baiviet> baiviet = new
		 * ArrayList<>();
		 * 
		 * baiviet = BVservice.getFriendsBaiViet(user);
		 */
		request.setAttribute("thongbaos", thongbaos);
		request.getRequestDispatcher("views/thong-bao.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
