<%@page import="edu.ict.prj.vo.MemberVO"%>
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
background-color:#d3d3d3;
color:white;
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
color:white;
text-decoration:none;
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
	</section>
	<footer>
	</footer>		
	
</body>
</html>