package edu.ict.prj.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.VoteDao;
import edu.ict.prj.vo.VoteVO;

public class VoteListCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		VoteDao dao = new VoteDao();
		ArrayList<VoteVO> voteList = dao.showVoteList();
		
		request.setAttribute("voteList", voteList);
		
	}

}
