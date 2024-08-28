package edu.ict.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.BoardDao;
import edu.ict.prj.vo.BoardVO;

public class BoardContentCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		
		BoardDao dao = new BoardDao();
		
		BoardVO board = dao.getBoard(bid);
		dao.upHit(bid);
		
		request.setAttribute("board", board);
	}

}
