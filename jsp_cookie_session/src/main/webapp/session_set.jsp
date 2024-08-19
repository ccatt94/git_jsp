<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	session.setAttribute("session_name", "세션_홍길동");
	session.setAttribute("session_num", 12345);
	session.setAttribute("id", "아이디이");
	
%>

<a href="session_get.jsp">session get</a>

</body>
</html>