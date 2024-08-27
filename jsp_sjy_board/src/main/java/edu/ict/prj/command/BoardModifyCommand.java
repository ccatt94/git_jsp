package edu.ict.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.BoardDao;

public class BoardModifyCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = new BoardDao();
		
		int rn = dao.modify(bid, bname, btitle, bcontent);
		System.out.println("modifyµÈ °¹¼ö : " + rn );

	}

}
