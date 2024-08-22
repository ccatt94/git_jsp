<%@page import="edu.ict.prj.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="edu.ict.prj.dao.EmpDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>사원 정보</h1>
	
	<%
		int empno = Integer.valueOf(request.getParameter("empno"));
	
		EmpDao dao = new EmpDao();
		
		EmpVO vo = dao.empSelectOne(empno);
	
		if(vo == null){
			out.print("해당 사원이 없습니다." + "<br>");
			
		}else{
			
			out.print("사원번호 : " + vo.getEmpno() + "<br>");
			out.print("사원이름 : " + vo.getEname() + "<br>");
			out.print("직종 : " + vo.getJob() + "<br>");
			out.print("매니저 : " + vo.getMgr() + "<br>");
			out.print("입사일자 : " + vo.getHiredate() + "<br>");
			out.print("급여 : " + vo.getSal() + "<br>");
			out.print("성과급 : " + vo.getComm() + "<br>");
			out.print("부서번호 : " + vo.getDeptno() + "<br>");
			out.print("<br>");
			
		}
		
		
	%>
	
	<a href="emp_input.html">사원정보 입력</a>
	
				
	
</body>
</html>