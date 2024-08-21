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

	<h1>emp 테이블</h1>
	
	<%
		EmpDao dao = new EmpDao();
		
		List<EmpVO> empList = dao.empSelect();
		
		for(EmpVO vo : empList){
			
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
	
				
	
</body>
</html>