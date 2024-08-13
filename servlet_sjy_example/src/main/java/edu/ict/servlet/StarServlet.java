package edu.ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/star")
public class StarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public StarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
				
		// html파일에서 전송한 값 받아내기
		int num = Integer.valueOf(request.getParameter("num"));
		
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=i; j++) {
			out.print("*");
		}
			out.print("<br>");
		}
		
		out.print("<hr>");
		
		for(int i=1; i<=num; i++) {
			for(int j=i; j<=num; j++) {
			out.print("*");
		}
			out.print("<br>");
		}
		
		
		
		
		out.print("</body>");
		out.print("</html>");
		out.close();


	}

}
