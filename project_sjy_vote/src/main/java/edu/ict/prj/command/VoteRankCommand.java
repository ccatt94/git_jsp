package edu.ict.prj.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.VoteDao;
import edu.ict.prj.vo.RankVO;

public class VoteRankCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		VoteDao dao = new VoteDao();
		List<RankVO> rank = dao.memberRank();
		
		System.out.println(rank.get(0).getM_name());
		
		request.setAttribute("rank", rank);
		
	}

}
