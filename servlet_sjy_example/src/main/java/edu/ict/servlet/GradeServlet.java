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
		out.print("<h1>성적 출력</h1>");
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
		
		request.setCharacterEncoding("UTF-8"); //Post방식에서 한글폰트 안깨지게 설정
		

		// html파일에서 전송한 값 받아내기
		String name = request.getParameter("name");
		double kor = Double.valueOf(request.getParameter("kor"));
		double eng = Double.valueOf(request.getParameter("eng"));
		double math = Double.valueOf(request.getParameter("math"));
		
		Grade grade = new Grade(name, kor, eng, math);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>" + grade.getName() + "의 성적표 </h1>");
		
		out.print("<p>국어 점수 : " + kor + "</p>");
		out.print("<p>영어 점수 : " + eng + "</p>");
		out.print("<p>수학 점수 : " + math + "</p>");
		
		out.print("<p>총점은 " + (kor + eng + math) + "입니다. </p>");
		
		out.print("<p>평균은 " + grade.getAvg() + "입니다. </p>");
		
		out.print("<p>성적은 " + grade.getGrade() + "입니다. </p>");
		
		out.print("</body>");
		out.print("</html>");
		out.close();

		System.out.println(grade.getName() + "의 성적표를 출력합니다.");

	}

}
