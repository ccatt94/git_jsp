<%@page import="edu.ict.prj.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
//폼을 날렸을 때 리턴 false 값이 안넘어가고 true 면 값이 넘어감
	const handleSubmit = (event) => {
		console.log(event.currentTarget)
		const formdata = new FormData(event.currentTarget)
		console.log(formdata)
		console.log(formdata.get("v_jumin"))
		if(formdata.get("v_jumin") === ''){
			console.log("비었음")
			return false;
		}
		return true
		
	}
	
</script>

</head>
<body>
	
	<h1>투표지</h1>

	<table width="500" height="400" cellpadding="0" cellspacing="0" border="1">
	<form action="vote_ok.do" method="post" onsubmit="handleSubmit(event)">
		<tr>
			<td align="center">주민번호</td>
			<td>&nbsp; 
				<input type="text" name="v_jumin"> &nbsp; ex)9408282012341
			</td>
		</tr>

		<tr>
			<td align="center">성명</td>
			<td>
				<input type="text" name="v_name">
			</td>
		</tr>

		<tr>
			<td align="center">투표번호</td>

			<td>&nbsp; 
				<select name=m_no>
					<option value="" selected disabled>후보 선택</option>
					<option value="1">기호 1번 김후보</option>
					<option value="2">기호 2번 이후보</option>
					<option value="3">기호 3번 박후보</option>
					<option value="4">기호 4번 조후보</option>
					<option value="5">기호 5번 최후보</option>
				</select>

			</td>
		</tr>

		<tr>
			<td align="center">투표시간</td>
			<td>
				<select name=v_time>
					<option value="" selected disabled>시간 선택</option>
					<option value="0930">오전 9시 30분</option>
					<option value="1330">오후 1시 30분</option>
				</select>
			</td>
		</tr>

		<tr>
			<td align="center">투표장소</td>
			<td>
				<select name=v_area>
					<option value="" selected disabled>장소 선택</option>
					<option value="제1투표장">제1투표장</option>
					<option value="제2투표장">제2투표장</option>
				</select>
			</td>
		</tr>

		<tr>
			<td align="center">유권자확인</td>
			<td>
				<input type="radio" id="check" value="Y" name="v_confirm">확인 
				<input type="radio" value="N" id="non-check" name="v_confirm">미확인
			</td>
		</tr>

		<tr>
			<td colspan="2" align="center">
				<button type="submit">투표하기</button> &nbsp;&nbsp;
				<button type="reset">다시하기</button>&nbsp;&nbsp;
			</td>

		</tr>
	</form>
	</table>

	
	


</body>
</html>