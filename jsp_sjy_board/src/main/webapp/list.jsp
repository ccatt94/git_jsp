<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		
		<tr>
		
			<td>글번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>날짜</td>
			<td>조회수</td>
		
		</tr>
		
		
		
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.bid}</td>
			<td>${board.bname}</td>
			<td>
				<c:forEach begin="1" end="${board.bindent}">└</c:forEach>
            	<a href="content_view.do?bid=${board.bid}">${board.btitle}</a>
            </td>
			<td>${board.bdate}</td>
			<td>${board.bhit}</td>
		
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5"> <a href="write_view.do">글쓰기</a>
		
		</tr>
		
		
	
	</table>
	
	
				
	
</body>
</html>