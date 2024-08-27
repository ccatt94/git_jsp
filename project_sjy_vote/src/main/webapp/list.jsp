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
	
	<h1>지역구 의원 후보 조회</h1>
	
	
	
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		
		<tr>
		
			<td>후보번호</td>
			<td>성명</td>
			<td>소속정당</td>
			<td>학력</td>
			<td>주민번호</td>
			<td>지역구</td>
			
		
		</tr>
		
		
		
		<c:forEach var="vote" items="${voteList}">
		<tr>
			<td>${vote.m_no}</td>
			<td>${vote.m_name}</td>
			<td>${vote.p_code}</td>
			<td>${school}</td>
			<td>${vote.m_jumin}</td>
			<td>${vote.m_city}</td>
			
		
		</tr>
		</c:forEach>
		
		
		
	
	</table>
	
	
				
	
</body>
</html>