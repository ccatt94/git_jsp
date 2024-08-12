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
		out.print("<h1>������ ���</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();

		System.out.println("doGet().. �Լ��Դϴ�.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// html���Ͽ��� ������ �� �޾Ƴ���
		int dan = Integer.valueOf(request.getParameter("dan"));

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>������ " + dan + "��</h1>");

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

		System.out.println(dan + "���� ����մϴ�.");

	}

}
