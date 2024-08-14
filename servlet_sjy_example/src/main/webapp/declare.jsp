<%@ page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 변수 선언, 함수 생성 -->
	<%!
	
		int i = 10;
		String words = "ABCDE";
	
	%>
	
	<%!
	
		public int sum(int a, int b){
			return a + b;
		}
	
	%>
	
	<%
		out.print(i + "<br>");
		out.print(words + "<br>");
		out.print(sum(3,5) + "<br>");
	%>
	
	<!-- expression toString()과 비슷 -->
	<%=i %> <br>
	<%=words %> <br>
	<%=sum(3,5) %> <br>
	
	<%
		int[] iArr = {10,20,30};
		out.print(Arrays.toString(iArr));
	%>
	
	<%= iArr %> <br>
	<%=	Arrays.toString(iArr)%> <br>
	<%= "[10, 20, 30]" %>
	
	
	
	
	
	
</body>
</html>