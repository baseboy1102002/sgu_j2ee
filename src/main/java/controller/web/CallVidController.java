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
			request.setAttribute("token", "eyJjdHkiOiJzdHJpbmdlZS1hcGk7dj0xIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJqdGkiOiJTSy4wLnBYTEtMUmhUcUY5eGNZUjkzZkk4VndwNXY5bFg4OC0xNzAwMTQxMjEyIiwiaXNzIjoiU0suMC5wWExLTFJoVHFGOXhjWVI5M2ZJOFZ3cDV2OWxYODgiLCJleHAiOjE3MDI3MzMyMTIsInVzZXJJZCI6InVzZXIxIn0.brP74DaAZKpKR08ngYA9gxexaTKLxW6JsqWoDw-yo_I");
		} else {
			request.setAttribute("callerId", "user2");
			request.setAttribute("calleeId", "user1");
			request.setAttribute("token", "eyJjdHkiOiJzdHJpbmdlZS1hcGk7dj0xIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJqdGkiOiJTSy4wLnBYTEtMUmhUcUY5eGNZUjkzZkk4VndwNXY5bFg4OC0xNzAwMTQxMzY0IiwiaXNzIjoiU0suMC5wWExLTFJoVHFGOXhjWVI5M2ZJOFZ3cDV2OWxYODgiLCJleHAiOjE3MDI3MzMzNjQsInVzZXJJZCI6InVzZXIyIn0.cZ08gisPbnYgQHHmwsvP7c9nfK2Fo38te3-eqH0BpC8");
		}
		
		request.getRequestDispatcher("/views/call.jsp").forward(request, response);
	}
}
