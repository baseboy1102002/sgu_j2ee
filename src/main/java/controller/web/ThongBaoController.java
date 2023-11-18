package controller.web;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NguoiDung;
import model.ThongBao;
import model.TimeDifference;
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

		String currentUser = request.getParameter("userID").toString();
		ThongbaoService tbService = new ThongbaoService();
		List<ThongBao> ThongBaos = new ArrayList<>();
		NguoiDung user = new NguoiDung(1, null, null);
//		String currentUser = "4";


		ThongBaos = tbService.getThongBao(Integer.parseInt(currentUser));
		formatTime fTime = new formatTime();
		List<TimeDifference> timeDifference = new ArrayList<>();

		for (ThongBao ThongBao : ThongBaos) {
			Date currntDate = new Date();
			TimeDifference timeDiff =  new TimeDifference();
			timeDiff.setTimeDiff(formatTime.formatTimeDifferences(ThongBao.getBaiviet().getNgayDang()));
			timeDifference.add(timeDiff);
		}

		int count = 0;
		for (ThongBao ThongBao : ThongBaos) {
				count++;
		}

		request.setAttribute("soThongBao", count);
		request.setAttribute("timeDifference", timeDifference);
		request.setAttribute("thongbaos", ThongBaos);
		request.getRequestDispatcher("views/thong-bao.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
