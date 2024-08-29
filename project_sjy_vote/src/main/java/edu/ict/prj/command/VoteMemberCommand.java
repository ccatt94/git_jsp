package edu.ict.prj.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.VoteDao;
import edu.ict.prj.vo.MemberVO;

public class VoteMemberCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		VoteDao dao = new VoteDao();
		List<MemberVO> memberList = dao.showMember();
		
		request.setAttribute("memberList", memberList);
		
	}

}
