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


@WebServlet("/lotto")
public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public LottoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Set<Integer> userLotto = new HashSet<>();
		Set<Integer> computerLotto = new HashSet<>();
		Set<Integer> sameLotto = new HashSet<>();
		Set<Integer> differLotto = new HashSet<>();
		
		
		
		// html파일에서 전송한 값 받아내기
		int num1 = Integer.valueOf(request.getParameter("num1"));
		int num2 = Integer.valueOf(request.getParameter("num2"));
		int num3 = Integer.valueOf(request.getParameter("num3"));
		int num4 = Integer.valueOf(request.getParameter("num4"));
		int num5 = Integer.valueOf(request.getParameter("num5"));
		int num6 = Integer.valueOf(request.getParameter("num6"));
		
		
		userLotto.add(num1);
		userLotto.add(num2);
		userLotto.add(num3);
		userLotto.add(num4);
		userLotto.add(num5);
		userLotto.add(num6);
		
		while(computerLotto.size() < 6) {
			int num = (int) (Math.random()*45+1);
			computerLotto.add(num);
		}
		
		for (Integer userNum : userLotto) {
			for (Integer comNum : computerLotto) {
				
				if(userNum == comNum) {
					sameLotto.add(userNum);
				}else {
					differLotto.add(userNum);
				
				}
			}
		}
		
		for(int num : sameLotto) {
			differLotto.remove(num);
		}
		
		
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");
		
		out.print("<h1>당신번호" + userLotto.toString() + "</h1>");
		out.print("<h1>컴퓨터번호" + computerLotto.toString() + "</h1>");
		out.print("<h1>맞춘번호" + sameLotto.toString() + "</h1>");
		out.print("<h1>틀린번호" + differLotto.toString() + "</h1>");
		
		out.print("</body>");
		out.print("</html>");
		out.close();


	}

}
