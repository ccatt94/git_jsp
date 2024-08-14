<%@page import="edu.ict.shape.Circle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	

	<%
		double radius = Double.valueOf(request.getParameter("radius"));
		Circle circle = new Circle(radius);
	%>
	
	<p> 반지름 <%=circle.getRadius() %> <br> </p>
	<p> 원의 넓이 <%=circle.getArea() %> </p>
	
</body>
</html>