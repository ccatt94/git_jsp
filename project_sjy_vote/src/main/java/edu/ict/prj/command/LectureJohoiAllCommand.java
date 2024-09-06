package edu.ict.prj.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.InfoLectureDao;
import edu.ict.prj.vo.InfoLectureVO;

public class LectureJohoiAllCommand implements GolfProcessCommand{
	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
	      
		   String v_confirm ="";
		   if (request.getParameter("v_confirm").equals("") || request.getParameter("v_confirm") == null) {
			   v_confirm ="1";
		   }
		   else {
			   v_confirm = request.getParameter("v_confirm");
		   }
		   InfoLectureDao dao = new InfoLectureDao();
		   ArrayList<InfoLectureVO> InfoLectureList = dao.list(v_confirm);
		   request.setAttribute("InfoLectureList", InfoLectureList);   
	      
	   }
}
