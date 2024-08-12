package edu.ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.shape.Circle;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/circlearea")
public class CircleAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CircleAreaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * doGet() : Get��Ŀ��� ȣ��Ǵ� �޼ҵ�. �����Ͱ� URL�� ���Եȴ�. 
	 * doPost() : Post��Ŀ��� ȣ��Ǵ� �޼���.�����Ͱ� HTML header�� ���Եȴ�.
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>���� ���� ���</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// html���Ͽ��� ������ �� �޾Ƴ���
		double radius = Double.valueOf(request.getParameter("radius"));
		
		Circle circle = new Circle(radius);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1> ���� ���� </h1>");
		out.print("<p> �������� " + radius + "�� ���� ���̴� " + circle.getArea() + "�Դϴ�. </p>");
		out.print("</body>");
		out.print("</html>");
		out.close();

		System.out.println("�������� " + radius + "�� ���� ���̸� ����մϴ�.");

	}

}
