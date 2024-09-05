<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.ict.prj.vo.ShoppingMoneyVO"%>
<%
request.setCharacterEncoding("UTF-8");
ArrayList<ShoppingMoneyVO> list = new ArrayList<ShoppingMoneyVO>();
list = (ArrayList<ShoppingMoneyVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style_shopping.css?ver=1">
</head>
<body>
	<%@ include file="topmenu.jsp"%>
	<section>
		<div class="title">회원매출조회</div>
		<div class="wrapper">
			<table>
				<tr>
					<th>회원번호</th>
					<th>회원성명</th>
					<th>고객등급</th>
					<th>매출</th>
				</tr>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getCustno()%></td>
					<td><%=list.get(i).getCustname()%></td>
					<td><%=list.get(i).getGrade()%></td>
					<td><%=list.get(i).getPrice()%></td>
				</tr>
				<%}%>
			</table>
		</div>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>