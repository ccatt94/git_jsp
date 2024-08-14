<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// 프로젝트 이름
		out.print("컨텍스트 path" + request.getContextPath() + "<br>");
	
		//포트 번호
		out.print("컨텍스트 path" + request.getServerPort() + "<br>");
		
		//서버
		out.print("컨텍스트 path" + request.getServerName() + "<br>");
		
		// 요청 방식
		out.print("컨텍스트 path" + request.getMethod() + "<br>");
		
		// 컨텍스트 주소
		out.print("컨텍스트 path" + request.getRequestURI() + "<br>");
		
		// 전체주소
		out.print("컨텍스트 path" + request.getRequestURL() + "<br>");
	%>
	
</body>
</html>