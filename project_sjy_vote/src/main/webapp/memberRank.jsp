<%@page import="edu.ict.prj.vo.VoteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
header{
background-color:#0000ff;
color:white;
height:70px;
line-height:70px;
text-align:center;
}
nav{
background-color:black;
color:white;
height:40px;
line-height:40px;
text-align:center;
}
section{
magin:0;
background-color:#d3d3d3;
color:black;
min-height:550px;
}
footer{
background-color:black;
color:white;
height:50px;
line-height:50px;
text-align:center;
font-size:12px;
}
a:link, a:visited{
color:black;
text-decoration:none;
}
button{
background-color:white;
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
	<h1>후보자등수</h1>

	<table width="800" border="1">

		<tr>
			<td align="center">후보번호</td>
			<td align="center">성명</td>
			<td align="center">총투표건수</td>
			
		</tr>
		
		<c:forEach var="rank" items="${rank}">
		<tr align="center">
		
			<td align="center">${rank.m_no}</td>
			<td align="center">${rank.m_name}</td>
			<td align="center">${rank.v_count}</td>
			
		</tr>
		</c:forEach>
		
	</table>
	<h4 align="center"><button><a href=index.do>홈으로</a></button></h4>
	</section>
	<footer></footer>


</body>
</html>