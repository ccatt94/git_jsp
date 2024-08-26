package edu.ict.prj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.command.BoardCommand;
import edu.ict.prj.command.BoardContentCommand;
import edu.ict.prj.command.BoardDeleteCommand;
import edu.ict.prj.command.BoardListCommand;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet..");
		actionDo(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost..");
		actionDo(request, response);

		
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo..");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		BoardCommand command = null;
		
		String uri = request.getRequestURI(); //jsp_sjy_board/list.do
		String contextPath = request.getContextPath(); //jsp_sjy_board
		String com = uri.substring(contextPath.length());
		System.out.println(uri + ":" + contextPath + ":" + com);
		
		if(com.equals("/list.do")) {
			command = new BoardListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(com.equals("/content_view.do")) { //http://localhost:8282/jsp_sjy_board/content_view.do?bid=1
			command = new BoardContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}else if(com.equals("/delete.do")) { //http:localhost:8282/jsp_sjy_board/delete.do?bid=1
			command = new BoardDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		
		
		
		//서블릿에서 forwarding 하기 위해
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
		
		
	}
}
