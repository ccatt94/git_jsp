<%@page import="edu.ict.shape.Rectangle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	

	<%
		int width = Integer.valueOf(request.getParameter("width"));
		int height = Integer.valueOf(request.getParameter("height"));
		
		Rectangle rec = new Rectangle(width, height);
	%>
	
	<p> 가로 <%=rec.getWidth() %> <br> </p>
	<p> 세로 <%=rec.getHeight() %> <br> </p>
	<p> 직사각형 넓이 <%=rec.getArea() %> </p>
	
</body>
</html>