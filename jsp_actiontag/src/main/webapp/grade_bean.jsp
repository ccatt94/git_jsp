<%@ page import= "edu.ict.bean.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>성적표</h1>
	
	<%
	
	%>
	
	<jsp:useBean id="grade" class="edu.ict.bean.Grade" />
	
	<jsp:setProperty name="grade" property="name" value="홍길동" />
	<jsp:setProperty name="grade" property="kor" value="80" />
	<jsp:setProperty name="grade" property="eng" value="90" />
	<jsp:setProperty name="grade" property="math" value="75" />
	
	이름 : <jsp:getProperty name="grade" property="name" /><br>
	국어 점수 : <jsp:getProperty name="grade" property="kor" /><br>
	영어 점수 : <jsp:getProperty name="grade" property="eng" /><br>
	수학 점수 : <jsp:getProperty name="grade" property="math" /><br>
	
	평균 점수 : <jsp:getProperty property="avg" name="grade"/><br>
	
	성적 : <jsp:getProperty property="grade" name="grade"/>
	
</body>
</html>