package controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/CallVidController", "/callvid" })
public class CallVidController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String suserid1 = request.getParameter("userid1");
		String suserid2 = request.getParameter("userid2");

		int iuserid1 = Integer.parseInt(suserid1);
		int iuserid2 = Integer.parseInt(suserid2);

		if(iuserid1<10) {
			request.setAttribute("callerId", "user1");
			request.setAttribute("calleeId", "user2");
			request.setAttribute("token", "eyJjdHkiOiJzdHJpbmdlZS1hcGk7dj0xIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJqdGkiOiJTSy4wLlJOdFNOQUtINnVkNUppME5zZlZRVTV4UFBsNTFvc2JtLTE3MDE0ODI5OTEiLCJpc3MiOiJTSy4wLlJOdFNOQUtINnVkNUppME5zZlZRVTV4UFBsNTFvc2JtIiwiZXhwIjoxNzA0MDc0OTkxLCJ1c2VySWQiOiJ1c2VyMSJ9.5AqaJE9mvQ3AqBQX8JR1VD5MApYRm7X3gKFRbfIR1vI");
		} else {
			request.setAttribute("callerId", "user2");
			request.setAttribute("calleeId", "user1");
			request.setAttribute("token", "eyJjdHkiOiJzdHJpbmdlZS1hcGk7dj0xIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJqdGkiOiJTSy4wLlJOdFNOQUtINnVkNUppME5zZlZRVTV4UFBsNTFvc2JtLTE3MDE0ODMwMDQiLCJpc3MiOiJTSy4wLlJOdFNOQUtINnVkNUppME5zZlZRVTV4UFBsNTFvc2JtIiwiZXhwIjoxNzA0MDc1MDA0LCJ1c2VySWQiOiJ1c2VyMiJ9.xFxh7B3Os6SfeEN08CdNyf2GlmIIakMOnoxaOcR0Uj8");
		}

		request.getRequestDispatcher("/views/call.jsp").forward(request, response);
	}
}
