package edu.ict.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.command.VoteCommand;
import edu.ict.prj.dao.VoteDao;

public class VoteInsertCommand implements VoteCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String v_jumin = request.getParameter("v_jumin");
		String v_name = request.getParameter("v_name");
		String m_no = request.getParameter("m_no");
		String v_time = request.getParameter("v_time");
		String v_area = request.getParameter("v_area");
		String v_confirm = request.getParameter("v_confirm");
		
		
		VoteDao dao = new VoteDao();
		
		int rn = dao.insert(v_jumin, v_name, m_no, v_time, v_area, v_confirm);
		
		System.out.println("삽입 갯수 : " + rn );
		
	}

}
