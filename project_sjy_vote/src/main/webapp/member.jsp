<%@page import="edu.ict.prj.vo.MemberVO"%>
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
	
	
	
	<table align="center" width="500" cellpadding="0" cellspacing="0" border="1">
		<tr align="center">
		
			<td>후보번호</td>
			<td>성명</td>
			<td>소속정당</td>
			<td>학력</td>
			<td>주민번호</td>
			<td>지역구</td>
			<td>대표번호</td>
		
		</tr>
		
		
		
		<c:forEach var="member" items="${memberList}">
		
		<tr align="center">
			<td align="center">${member.m_no}</td>
			<td align="center">${member.m_name}</td>
			<td align="center">${member.p_code}</td>
			
			<td align="center">
			<c:choose>
			<c:when test="${member.p_school=='1'}">고졸</c:when>
			<c:when test="${member.p_school=='2'}">학사</c:when>
			<c:when test="${member.p_school=='3'}">석사</c:when>
			<c:otherwise>박사</c:otherwise>
			</c:choose>
			</td>
			
			<td align="center">${member.m_jumin}</td>
			<td align="center">${member.m_city}</td>
			<td align="center">${member.p_tel}</td>
		</tr>
		
		</c:forEach>
		
		
		
	
	</table>
	
	<a href=index.do>홈으로</a>
	
				
	
</body>
</html>