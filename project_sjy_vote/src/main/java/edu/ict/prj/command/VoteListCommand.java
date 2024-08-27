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
		ArrayList<VoteVO> voteList = dao.list();
		String school = null;
		
		for(int i = 0; i < voteList.size(); i++){
			VoteVO v = voteList.get(i);
			
			
			if(v.getP_school().equals("1")) {
				school = "고졸";
			}else if(v.getP_school().equals("2")) {
				school = "학사";
			}else if(v.getP_school().equals("3")) {
				school = "석사";
			}else {
				school = "박사";
			}
		}
		
		request.setAttribute("voteList", voteList);
		request.setAttribute("school", school);
		
	}

}
