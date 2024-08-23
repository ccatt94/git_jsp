<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 예제</h1>
문자열 : ${"test"}<br>
문자열 : ${'test'}<br>
정수 : ${20}<br>
부동소수점 : ${20.4}<br>
Boolean : ${true}<br>
null : ${null}<br> <%--${null}은 빈 문자열(" ")로 출력 --%>
<%
	pageContext.setAttribute("scores", new int[]{19, 80, 70, 100});
	pageContext.setAttribute("session_scores", new int[]{19, 80, 70, 100});
	request.setAttribute("request_scores", new int[]{19, 80, 70, 100});
	application.setAttribute("application_scores", new int[]{19, 80, 70, 100});

	pageContext.setAttribute("name", "홍길동");

	int num = 20;
	pageContext.setAttribute("num", num);
	
%>	
		
${scores[0]} <br>
${session_scores[0]} <br>
${request_scores[0]} <br>
${application_scores[0]} <br>
${name}<br>

<%=num %><br>
${num}<br>

<%
	List<String> list = new LinkedList<>();
	list.add("가나");
	list.add("다라");
	list.add("마바");
	
	pageContext.setAttribute("list", list);
	
%>

${list[0]}<br>		
${list[1]}<br>		
${list[2]}<br>		

<%
	Map<String, String> map = new HashMap<>();
	map.put("1", "a");
	map.put("2", "b");
	map.put("3", "c");
	
	session.setAttribute("map", map);

	Map<Integer, String> numMap = new HashMap<>();
	numMap.put(1, "a");
	numMap.put(2, "b");
	numMap.put(3, "c");
	
	session.setAttribute("numMap", numMap);
%>

${map["1"]}<br>
${map["2"]}<br>
${map["3"]}<br>
	
${numMap['1']}<br>
${numMap['2']}<br>
${numMap['3']}<br>























</body>
</html>