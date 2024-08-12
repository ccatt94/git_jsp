package edu.ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.shape.Grade;



/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/grade")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GradeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>���� ���</h1>");
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
		
		request.setCharacterEncoding("UTF-8"); //Post��Ŀ��� �ѱ���Ʈ �ȱ����� ����
		

		// html���Ͽ��� ������ �� �޾Ƴ���
		String name = request.getParameter("name");
		double kor = Double.valueOf(request.getParameter("kor"));
		double eng = Double.valueOf(request.getParameter("eng"));
		double math = Double.valueOf(request.getParameter("math"));
		
		Grade grade = new Grade(name, kor, eng, math);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>" + grade.getName() + "�� ����ǥ </h1>");
		
		out.print("<p>���� ���� : " + kor + "</p>");
		out.print("<p>���� ���� : " + eng + "</p>");
		out.print("<p>���� ���� : " + math + "</p>");
		
		out.print("<p>������ " + (kor + eng + math) + "�Դϴ�. </p>");
		
		out.print("<p>����� " + grade.getAvg() + "�Դϴ�. </p>");
		
		out.print("<p>������ " + grade.getGrade() + "�Դϴ�. </p>");
		
		out.print("</body>");
		out.print("</html>");
		out.close();

		System.out.println(grade.getName() + "�� ����ǥ�� ����մϴ�.");

	}

}
