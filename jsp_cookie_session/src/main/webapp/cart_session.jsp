<%@page import="edu.ict.shop.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>카트 객체를 세션에 저장하는 페이지</h1>

<%
	session.setAttribute("cart", new Cart());
%>

<a href="cart_get.jsp">카트 내용보기</a>

</body>
</html>