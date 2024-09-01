<%@page import="edu.ict.prj.vo.VoteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
header {
	background-color: steelblue;
	color: white;
	height: 70px;
	line-height: 70px;
	text-align: center;
}

nav {
	background-color: black;
	color: white;
	height: 40px;
	line-height: 40px;
	text-align: center;
}

section {
	magin: 0;
	background-color: #d3d3d3;
	color: black;
}

footer {
	background-color: black;
	color: white;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 12px;
}

table {
	width: 100%;
	max-width: 800px;
	border: 1px solid #dfdfdf;
	border-collapse: collapse;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
	border-radius: 10px;
	overflow: hidden;
	margin-left: auto;
	margin-right: auto;
}

tr, td {
	border-bottom: 1px solid #ffffff;
	border-left: 1px solid #ffffff;
	padding: 10px;
	background-color: #f4f4f4;
}

a:link, a:visited {
	color: white;
	text-decoration: none;
}

button {
	background-color: steelblue;
	color:white;
	width: 80px;
	display: block;
	margin: auto;
}
</style>

</head>
<body>
	<header>
		<h1>지역구 의원 투표 프로그램</h1>
	</header>
	
	<nav>
		<a href=member.do>후보조회</a> &emsp; 
		<a href=vote.do>투표하기</a> &emsp;
		<a href=voteList.do>투표검수조회</a> &emsp;
		<a href=memberRank.do>후보자등수</a> &emsp;
		<a href=index.do>홈으로</a>
	</nav>
	
	<section>
		<br>
	<h1 align="center">투표검수조회</h1>

	<table>

		<tr>
			<td align="center">성명</td>
			<td align="center">생년월일</td>
			<td align="center">나이</td>
			<td align="center">성별</td>
			<td align="center">후보번호</td>
			<td align="center">투표시간</td>
			<td align="center">유권자확인</td>
		</tr>
		
		<c:forEach var="vote" items="${voteList}">
		<tr align="center">
		
			<td align="center">${vote.v_name}</td>
			<td align="center">${vote.v_jumin}</td>
			<td align="center">${vote.v_age}</td>
			<td align="center">${vote.v_sex}</td>
			<td align="center">${vote.m_no}</td>
			<td align="center">${vote.v_time}</td>
			<td align="center">${vote.v_confirm}</td>
			
		</tr>
		</c:forEach>
		
	</table>
	<br>
	<button onclick="location.href='index.do'">홈으로</button>
	<br>
	</section>
	<footer></footer>

</body>
</html>