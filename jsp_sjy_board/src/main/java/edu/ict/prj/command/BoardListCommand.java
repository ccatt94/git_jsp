package edu.ict.prj.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.BoardDao;
import edu.ict.prj.vo.BoardVO;

public class BoardListCommand implements BoardCommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		BoardDao dao = new BoardDao();
		ArrayList<BoardVO> boardList = dao.list();
		request.setAttribute("boardList", boardList);
		
	}
	
}
