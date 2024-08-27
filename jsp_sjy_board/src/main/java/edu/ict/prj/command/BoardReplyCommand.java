package edu.ict.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.BoardDao;

public class BoardReplyCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
 
		
		
		String bid = request.getParameter("bid");
		String bgroup = request.getParameter("bgroup");
		String bstep = request.getParameter("bstep");
		String bindent = request.getParameter("bindent");
		
		
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = new BoardDao();
		
		int rn = dao.reply(bid, bname, btitle, bcontent, bgroup, bstep, bindent);
		System.out.println("´ä±Û °¹¼ö : " + rn );
	}

}
