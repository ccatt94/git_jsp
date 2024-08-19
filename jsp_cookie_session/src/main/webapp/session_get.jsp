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
	Object obj = session.getAttribute("session_name");
	String name = (String) obj;
	int num = (Integer) session.getAttribute("session_num");

	String id = (String) session.getAttribute("id");
	
	out.print("session_name : " + name + "<br/>");
	out.print("session_num : " + num + "<br/>");
	out.print("아이디 : " + id + "<br/>");
	
%>

<a href="session_del.jsp">session 삭제</a>

</body>
</html>