<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%!
		String name, id, pw, major;
		String[] hobbys;
	%>
	
	<%
		request.setCharacterEncoding("UTF-8");
		
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("password");
		hobbys = request.getParameterValues("hobby");
		major = request.getParameter("major");
	%>
	
	이름 : <%=name %> <br>
	아이디 : <%=id %> <br>
	비밀번호 : <%=pw %> <br>
	취미 : <%=Arrays.toString(hobbys) %> <br>
	전공 : <%=major %> <br>
	
</body>
</html>