<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	

	<%
		request.setCharacterEncoding("UTF-8");
		
		// redirect와 forward의 차이
		// 고객 전화 -> 콜센타 직원 -> 해당 부서로 다시 전화 걸어주세요(전화를 끊고 다시 걸음) -> redirect
		// 고객 전화 -> 콜센타 직원 -> 해당 부서로 내선번호로 돌림(전화를 안끊음) -> forward -> request 기존 것 그대로 사용 가능 -> 전화번호가 바뀌지않음(주소바뀌지 않음)
	
		int age = Integer.valueOf(request.getParameter("age"));
		
		if(age >= 20){
			//? 붙이는건 get방식으로 값 넘김
			//sendRedirect - 해당 jsp 경로로 이동(서블릿에서 처리한 데이터를 별도로 넘기지 않고 페이지만 이동)
			response.sendRedirect("pass.jsp?age=" + age);
		}else {
			response.sendRedirect("ng.jsp?age=" + age);
		}
	%>
	
	
	
</body>
</html>