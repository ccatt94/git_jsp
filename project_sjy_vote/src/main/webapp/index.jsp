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
background-color:steelblue;
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

<title>Ministore</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="author" content="">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap" rel="stylesheet">
    <!-- script
    ================================================== -->
    <script src="resource/js/modernizr.js"></script>

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