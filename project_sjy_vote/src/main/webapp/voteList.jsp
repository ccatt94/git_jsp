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
	
	<h1>투표검수조회</h1>

	<table width="800" border="1">

		<tr>
			<td align="center">주민번호</td>
			<td align="center">성명</td>
			<td align="center">투표번호</td>
			<td align="center">투표시간</td>
			<td align="center">투표장소</td>
			<td align="center">유권자확인</td>
		</tr>
		
		<c:forEach var="vote" items="${voteList}">
		<tr align="center">
		
			<td align="center">${vote.v_jumin}</td>
			<td align="center">${vote.v_name}</td>
			<td align="center">${vote.m_no}</td>
			<td align="center">${vote.v_time}</td>
			<td align="center">${vote.v_area}</td>
			<td align="center">${vote.v_confirm}</td>
			
		</tr>
		</c:forEach>
		
	</table>

	<a href="index.do">홈으로</a>


</body>
</html>