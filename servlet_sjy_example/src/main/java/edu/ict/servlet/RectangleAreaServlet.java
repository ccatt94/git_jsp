package edu.ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.shape.Rectangle;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/rectangle")
public class RectangleAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RectangleAreaServlet() {
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
		out.print("<h1>���簢�� ���� ���</h1>");
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
		double width = Double.valueOf(request.getParameter("width"));
		double height = Double.valueOf(request.getParameter("height"));
		
		Rectangle rec = new Rectangle(width, height);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1> ���簢���� ���� </h1>");
		out.print("<p>���� : " + width + "</p>");
		out.print("<p>���� : " + height + "</p>");
		out.print("<p>���簢���� ���̴� " + rec.getArea() + "�Դϴ�. </p>");
		out.print("</body>");
		out.print("</html>");
		out.close();

		System.out.println("���ΰ� " + width + "�̰� ���ΰ� " + height + "�� ���簢���� ���̸� ����մϴ�.");

	}

}
