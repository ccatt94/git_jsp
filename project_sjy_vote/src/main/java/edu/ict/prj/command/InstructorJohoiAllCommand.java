package edu.ict.prj.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.InfoInstructorDao;
import edu.ict.prj.vo.InfoInstructorVO;

public class InstructorJohoiAllCommand implements GolfProcessCommand{
	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
   System.out.println("KKKKKKKK   00000   001");

   			// 주의 : request.getParameter("v_confirm")에서 v_confirm 에 null값이 들어오면 에러남
		   String v_confirm = request.getParameter("v_confirm");
		   
   System.out.println("KKKKKKKK   00000   001");
		   InfoInstructorDao dao = new InfoInstructorDao();
   System.out.println("KKKKKKKK   00000   001");
		   ArrayList<InfoInstructorVO> InfoInstructorList = dao.list(v_confirm);
   System.out.println("KKKKKKKK   00000   001");
		   request.setAttribute("InfoInstructorList", InfoInstructorList);   
	      
	   }
}
