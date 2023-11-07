package controller.web;


import java.awt.print.Printable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TimeDifference;
import model.nguoidung;
import model.thongbao;
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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ThongbaoService tbService = new ThongbaoService();
		List<thongbao> thongbaos = new ArrayList<>();
		nguoidung user = new nguoidung(1, null, null, null, null, null, null, null, null, null, null, null);



		thongbaos = tbService.getThongBao(user);
		formatTime fTime = new formatTime();
		List<TimeDifference> timeDifference = new ArrayList<>();
		
		for (thongbao thongbao : thongbaos) {
			Date currntDate = new Date();
			TimeDifference timeDiff =  new TimeDifference();
			timeDiff.setTimeDiff(fTime.formatTimeDifferences(thongbao.getBaiviet().getNgayDang()));
			timeDifference.add(timeDiff);
		}
		
		request.setAttribute("timeDifference", timeDifference);
		request.setAttribute("thongbaos", thongbaos);
		request.getRequestDispatcher("views/thong-bao.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
