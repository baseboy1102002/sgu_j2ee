package controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/CallVidController", "/callvid" })
public class CallVidController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String suserid1 = request.getParameter("userid1");
		String suserid2 = request.getParameter("userid2");
		
		int iuserid1 = Integer.parseInt(suserid1);
		int iuserid2 = Integer.parseInt(suserid2);
		
		if(iuserid1<10) {
			request.setAttribute("callerId", "user1");
			request.setAttribute("calleeId", "user2");
			request.setAttribute("token", "eyJjdHkiOiJzdHJpbmdlZS1hcGk7dj0xIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJqdGkiOiJTSy4wLnJVUlBiSWVYMWJ4U3hPNmlKbEc0WGF3OTB1TkRuSy0xNjk5OTcwMjg5IiwiaXNzIjoiU0suMC5yVVJQYkllWDFieFN4TzZpSmxHNFhhdzkwdU5EbksiLCJleHAiOjE3MDI1NjIyODksInVzZXJJZCI6InVzZXIxIn0.PxQ4wrrdAMN-m9XdKj_2Dj7RIYxRbwJoRE6JgAufF-Q");
		} else {
			request.setAttribute("callerId", "user2");
			request.setAttribute("calleeId", "user1");
			request.setAttribute("token", "eyJjdHkiOiJzdHJpbmdlZS1hcGk7dj0xIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJqdGkiOiJTSy4wLnJVUlBiSWVYMWJ4U3hPNmlKbEc0WGF3OTB1TkRuSy0xNjk5OTcwMzIxIiwiaXNzIjoiU0suMC5yVVJQYkllWDFieFN4TzZpSmxHNFhhdzkwdU5EbksiLCJleHAiOjE3MDI1NjIzMjEsInVzZXJJZCI6InVzZXIyIn0.wuA_BUcJ9mVPURDbvh2fCZohhJfQni2Qf2NwYVLeJLU");
		}
		
		request.getRequestDispatcher("/views/call.jsp").forward(request, response);
	}
}
