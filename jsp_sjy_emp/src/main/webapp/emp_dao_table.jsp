<%@page import="edu.ict.prj.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="edu.ict.prj.dao.EmpDao"%>
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
		
/* 		ResultSetMetaData rsmd = rs.getMetaData(); */
		
		out.print("<table border='1'>");
		
		out.print("<tr>");
		
		for(EmpVO vo : empList){
				
			out.print("<td>" + "사원번호 : " + vo.getEmpno() + "</td>");
			out.print("<td>" + "사원이름 : " + vo.getEname() + "</td>");
			out.print("<td>" + "직종 : " + vo.getJob() + "</td>");
			out.print("<td>" + "매니저 : " + vo.getMgr() + "</td>");
			out.print("<td>" + "입사일자 : " + vo.getHiredate() + "</td>");
			out.print("<td>" + "급여 : " + vo.getSal() + "</td>");
			out.print("<td>" + "성과급 : " + vo.getComm() + "</td>");
			out.print("<td>" + "부서번호 : " + vo.getDeptno() + "</td>");
			
			out.print("</tr>");
		}
	%>
	
				
	
</body>
</html>