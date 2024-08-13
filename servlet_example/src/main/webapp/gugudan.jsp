<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
	
	
	<tr>
		
		<% for(int i = 2; i <= 9; i++){ %>
	
			<td> <% out.print(i + "단"); %> </td>
			
		<% } %>
	
	</tr>
	
	<tr>

			<% for(int i = 1; i <= 9; i++){ %>
		
			<% for(int j = 2; j <= 9; j++){ %>
			
				<td> <% out.print(j + " x " + i + " = " + i * j); %> </td>
			
			<% } %>
	
	</tr>
	
		 <%} %>
	
	
	</table>
				
	
</body>
</html>