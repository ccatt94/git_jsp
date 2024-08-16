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
	
	<h1>bean 예제 입니다.</h1>
	
	<%
		/* Student student = new Student(); */
				/* student.setName("홍길동"); */
	%>
	
	<jsp:useBean id="student" class="edu.ict.bean.Student" />
	
	<jsp:setProperty name="student" property="name" value="홍길동" />
	<jsp:setProperty name="student" property="age" value="17" />
	<jsp:setProperty name="student" property="grade" value="6" />
	<jsp:setProperty name="student" property="studentNum" value="7000" />
	
	이름 : <jsp:getProperty name="student" property="name" /><br>
	나이 : <jsp:getProperty name="student" property="age" /><br>
	학년 : <jsp:getProperty name="student" property="grade" /><br>
	학번 : <jsp:getProperty name="student" property="studentNum" /><br>
	
	
</body>
</html>