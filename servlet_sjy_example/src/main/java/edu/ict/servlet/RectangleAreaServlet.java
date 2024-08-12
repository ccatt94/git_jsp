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
	 * doGet() : Get방식에서 호출되는 메소드. 데이터가 URL에 포함된다. 
	 * doPost() : Post방식에서 호출되는 메서드.데이터가 HTML header에 포함된다.
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>직사각형 넓이 출력</h1>");
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

		// html파일에서 전송한 값 받아내기
		double width = Double.valueOf(request.getParameter("width"));
		double height = Double.valueOf(request.getParameter("height"));
		
		Rectangle rec = new Rectangle(width, height);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1> 직사각형의 넓이 </h1>");
		out.print("<p>가로 : " + width + "</p>");
		out.print("<p>세로 : " + height + "</p>");
		out.print("<p>직사각형의 넓이는 " + rec.getArea() + "입니다. </p>");
		out.print("</body>");
		out.print("</html>");
		out.close();

		System.out.println("가로가 " + width + "이고 세로가 " + height + "인 직사각형의 넓이를 출력합니다.");

	}

}
