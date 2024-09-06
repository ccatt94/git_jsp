package edu.ict.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.InfoMemberDao;

public class MemberDeungrokCommand implements GolfProcessCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String memb_name 	= request.getParameter("memb_name");
		String birth_date 	= request.getParameter("birth_date");
		int sex_g 			= Integer.parseInt(request.getParameter("sex_g"));
		String tel_no 		= request.getParameter("tel_no");
		String juso 		= request.getParameter("juso");
		int grade 			= Integer.parseInt(request.getParameter("grade"));

		InfoMemberDao dao 	= new InfoMemberDao();

		int rn = dao.InfoMemberInsert(memb_name, birth_date, sex_g, tel_no, juso, grade);

		System.out.println("등록 건수 : " + rn);

	}
}
