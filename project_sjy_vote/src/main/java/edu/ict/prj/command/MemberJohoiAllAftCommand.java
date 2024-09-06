package edu.ict.prj.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.InfoMemberDao;
import edu.ict.prj.vo.InfoMemberVO;

public class MemberJohoiAllAftCommand  implements GolfProcessCommand{
	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
	      
		   String v_confirm = "4";

		   InfoMemberDao dao = new InfoMemberDao();
		   ArrayList<InfoMemberVO> InfoMemberList 	= dao.list(v_confirm);
		   request.setAttribute("InfoMemberList", InfoMemberList);   
	      
	   }
}
