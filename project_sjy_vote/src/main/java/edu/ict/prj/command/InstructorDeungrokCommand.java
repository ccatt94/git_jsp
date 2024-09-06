package edu.ict.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.InfoInstructorDao;


public class InstructorDeungrokCommand  implements GolfProcessCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String ins_name 	= request.getParameter("ins_name");
		String empl_date 	= request.getParameter("empl_date");
		String qual_date 	= request.getParameter("qual_date");
		int sex_g 			= Integer.parseInt(request.getParameter("sex_g"));
		String tel_no 		= request.getParameter("tel_no");

		InfoInstructorDao dao 	= new InfoInstructorDao();

		int rn = dao.InfoInstructorInsert(ins_name, empl_date,qual_date, sex_g, tel_no);

		System.out.println("등록 건수 : " + rn);

	}
}
