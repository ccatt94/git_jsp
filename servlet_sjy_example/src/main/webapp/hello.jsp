<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--스크립트릿 자바문법이 들어감 -->
	<% 
	
		int i=0;
		System.out.println(i);
		
		out.println("<h1>" + i + "</h1>");
		
	
	%>
	<hr>
	<h1>3단</h1>
	<%
	
		int dan = 3;
		
		for(i = 1; i <=9; i++){
			out.println(dan + " x " + i + " = " + dan*i + "<br>");
		}
	
	
	%>
	<hr>
	<h1>구구단</h1>
	<%
		
		for(i=1; i<=9; i++){
			out.print(i + "단");
			out.print("<br>");
			for(int j=1; j<=9; j++){
				out.print(i + " x " + j + " = " + i*j + "<br>");
			}
			out.print("<br>");
		}
		
	%>
	<hr>
	<h1>구구단 테이블</h1>
	
	
		<table border="1">
				
			<tr>
			
				<%for(i = 2; i <= 9; i++){%>
				
				<td align=center>
				<%out.print(i + "단"); %>
				</td>
				
				<%}%>
				
			</tr>
			
			
		
		<% for(i = 1; i <=9; i++){ %>
		
			<tr>
			
			<% for(int j = 2; j <= 9; j++){ %>
				
					<td align=center>
					<%=j %> * <%=i%> = <%= i*j %>
					</td>
				
			<% } %>
				
			</tr>
		
		<% } %>
		
		
		</table>
		
		
		<hr>
<%-- 		<h1>구구단 테이블</h1>
		
		<table border="1" width="800">
		
		<tr>
			
			<% %>
			
		
		
		
		
		
		</tr>
		 --%>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		</table>
		
		

	
	
	<h1>안녕하세요</h1>
	
</body>
</html>