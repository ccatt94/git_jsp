<%@page import="edu.ict.prj.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="edu.ict.prj.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>사원 정보</h1>
		
	<%
	
		EmpDao dao = new EmpDao();
	
		List<EmpVO> empList = dao.empSelect();	
	
		pageContext.setAttribute("empList", empList);
		
	
	%>
	
		<c:forEach var="emp" items="${empList}">
		사원번호:${emp.getEmpno()} 사원이름:${emp.ename} 직업:${emp.job} 매니저:${emp.mgr} 입사일:${emp.hiredate} 급여:${emp.sal} 커미션:${emp.comm} 부서번호:${emp.deptno} <br>
		</c:forEach>		
	
</body>
</html>