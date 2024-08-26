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
      <form action="modify.do" method="post">
         <input type="hidden" name="bid" value="${board.bid}">
         <tr>
            <td> 번호 </td>
            <td> ${board.bid} </td>
         </tr>
         <tr>
            <td> 히트 </td>
            <td> ${board.bhit} </td>
         </tr>
         <tr>
            <td> 이름 </td>
            <td> <input type="text" name="bname" value="${board.bname}"></td>
         </tr>
         <tr>
            <td> 제목 </td>
            <td> <input type="text" name="btitle" value="${board.btitle}"></td>
         </tr>
         <tr>
            <td> 내용 </td>
            <td> <textarea rows="10" name="bcontent" >${board.bcontent}</textarea></td>
         </tr>
         <tr>
            <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="list.do">목록보기</a> &nbsp;&nbsp; <a href="delete.do?bid=${board.bid}">삭제</a> &nbsp;&nbsp; <a href="reply_view.do?bid=${board.bid}">답변</a></td>
         </tr>
      </form>
   </table>
	
	
				
	
</body>
</html>