package edu.ict.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.command.BoardCommand;
import edu.ict.prj.dao.BoardDao;

public class BoardWriteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = new BoardDao();
		
		int rn = dao.write(bname, btitle, bcontent);
		System.out.println("insertµÈ °¹¼ö : " + rn );
	}

}
