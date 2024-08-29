<%@page import="edu.ict.prj.vo.VoteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	
	<h1>후보자등수</h1>

	<table width="800" border="1">

		<tr>
			<td align="center">후보번호</td>
			<td align="center">성명</td>
			<td align="center">총투표건수</td>
			
		</tr>
		
		<c:forEach var="rank" items="${memberRank}">
		<tr align="center">
		
			<td align="center">${rank.m_no}</td>
			<td align="center">${rank.m_name}</td>
			<td align="center">${rank.v_count}</td>
			
		</tr>
		</c:forEach>
		
	</table>

	<a href="index.do">홈으로</a>


</body>
</html>