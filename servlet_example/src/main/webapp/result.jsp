<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% int money = Integer.valueOf(request.getParameter("money"));%>
	
	<%
		if ( money == 0){
			throw new NullPointerException("Money is null");
		}
	
	%>
	
	<h1 style="color: pink;">화폐매수 구하기</h1>
	<h3>액수 : <%=money %></h3>

	<%
	
	int m50000, m10000, m5000, m1000, m500, m100;
	int tMoney;

	m50000 = money / 50000;
	tMoney = money % 50000;
	out.print("오만원 : " + m50000 + "장" + "<br>");

	m10000 = tMoney / 10000;
	tMoney = tMoney % 10000;
	out.print("만원 : " + m10000 + "장" + "<br>");

	m5000 = tMoney / 5000;
	tMoney = tMoney % 5000;
	out.print("오천원 : " + m5000 + "장" + "<br>");

	m1000 = tMoney / 1000;
	tMoney = tMoney % 1000;
	out.print("천원 : " + m1000 + "장" + "<br>");

	m500 = tMoney / 500;
	tMoney = tMoney % 500;
	out.print("오백원 : " + m500 + "개" + "<br>");

	m100 = tMoney / 100;
	tMoney = tMoney % 100;
	out.print("백원 : " + m100 + "개" + "<br>"); 
	
	%>
				
	
</body>
</html>