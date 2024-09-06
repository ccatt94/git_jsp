package edu.ict.prj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.command.VoteCommand;
import edu.ict.prj.command.VoteInsertCommand;
import edu.ict.prj.command.VoteListCommand;
import edu.ict.prj.command.VoteMemberCommand;
import edu.ict.prj.command.VoteRankCommand;

@WebServlet("*.do")
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VoteController() {
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
		VoteCommand command = null;
		
		String uri = request.getRequestURI(); //project_sjy_vote/list.do
		String contextPath = request.getContextPath(); //project_sjy_vote
		String com = uri.substring(contextPath.length());
		
		// /project_sjy_vote/vote/member.do:/project_sjy_vote:/vote/member.do
		System.out.println(uri + ":" + contextPath + ":" + com);
		
		if(com.equals("/vote/main.do")) {
			command = new VoteMemberCommand();
			command.execute(request, response);
			viewPage = "main.jsp";
		}else if(com.equals("/vote/member.do")) {
			command = new VoteMemberCommand();
			command.execute(request, response);
			viewPage = "member.jsp";
		}else if(com.equals("/vote/vote.do")) {
			viewPage = "vote.jsp";
		}else if(com.equals("/vote/vote_ok.do")) {
			command = new VoteInsertCommand();
			command.execute(request, response);
			viewPage = "main.do";
		}else if(com.equals("/vote/voteList.do")) {
			command = new VoteListCommand();
			command.execute(request, response);
			viewPage = "voteList.jsp";
		}else if(com.equals("/vote/memberRank.do")) {
			command = new VoteRankCommand();
			command.execute(request, response);
			viewPage = "memberRank.jsp";
		}
		
		
		
		
		
		
		//서블릿에서 forwarding 하기 위해
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
		
		
		
	}
}
