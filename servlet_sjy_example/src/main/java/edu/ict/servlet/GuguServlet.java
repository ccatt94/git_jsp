package edu.ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/gugudan")
public class GuguServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuguServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>구구단 출력</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();

		System.out.println("doGet().. 함수입니다.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// html파일에서 전송한 값 받아내기
		int dan = Integer.valueOf(request.getParameter("dan"));

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>구구단 " + dan + "단</h1>");

		for(int i = 1; i<=9; i++) {
			out.print("<p>" + dan + " x " + i + " = " +  dan*i + "<p>");
		}
		
//		for (int i = 1; i <= 9; i++) {
//			for (int j = 1; j <= 9; j++) {
//				if (dan == i) {
//					out.print(dan + " x " + j + " = " + (dan * j));
//					out.print("<br>");
//				}
//			}
//		}

		out.print("</body>");
		out.print("</html>");
		out.close();

		System.out.println(dan + "단을 출력합니다.");

	}

}
