package edu.ict.prj.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ict.prj.dao.InfoInstructorDao;
import edu.ict.prj.vo.InfoInstructorVO;

public class InstructorJohoiAllAftCommand  implements GolfProcessCommand{
	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
System.out.println("KKKKKKKK   00000   001");
	      
		 String  v_confirm ="4";
		    
		   
System.out.println("KKKKKKKK   00000   001");
		   InfoInstructorDao dao = new InfoInstructorDao();
System.out.println("KKKKKKKK   00000   001");
		   ArrayList<InfoInstructorVO> InfoInstructorList = dao.list(v_confirm);
System.out.println("KKKKKKKK   00000   001");
		   request.setAttribute("InfoInstructorList", InfoInstructorList);   
	      
	   }
}
