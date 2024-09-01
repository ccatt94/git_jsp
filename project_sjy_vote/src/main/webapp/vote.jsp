<%@page import="edu.ict.prj.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
header {
	background-color: steelblue;
	color: white;
	height: 70px;
	line-height: 70px;
	text-align: center;
}

nav {
	background-color: black;
	color: white;
	height: 40px;
	line-height: 40px;
	text-align: center;
}

section {
	magin: 0;
	background-color: #dfdfdf;
	color: black;
	min-height: 550px;
}

footer {
	background-color: black;
	color: white;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 12px;
}

a:link, a:visited {
	color: white;
	text-decoration: none;
}

button {
	background-color: steelblue;
}

table {
	width: 100%;
	max-width: 500px;
	height: 400px;
	border: 1px solid #dfdfdf;
	border-collapse: collapse;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
	border-radius: 10px;
	overflow: hidden;
	margin-left: auto;
	margin-right: auto;
}

tr, td {
	border-bottom: 1px solid #ffffff;
	border-left: 1px solid #ffffff;
	padding: 10px;
	background-color: #f4f4f4;
}
</style>
<script type="text/javascript">

	function formCheck() {
		
		//주민번호 확인 
		if(!checkV_jumin(voteForm.v_jumin.value)){
			return false;
		}
		
		//이름 확인
		if(!checkV_name(voteForm.v_name.value)){
			return false;
		}
		
		//후보 선택 확인
		if(voteForm.m_no.value === ""){
			alert("후보를 선택해주세요");
			voteForm.m_no.focus();
			return false;
		}
		
		//투표 시간 확인
		if(voteForm.v_time.value === ""){
			alert("투표시간을 선택해주세요");
			voteForm.v_time.focus();
			return false;
		}
		
		//투표 장소 확인
		if(voteForm.v_area.value === ""){
			alert("투표장소를 선택해주세요");
			voteForm.v_area.focus();
			return false;
		}

		//유권자 확인
		flag = false;
		for(i=0; i < voteForm.v_confirm.length; i++){
			if(voteForm.v_confirm[i].checked){
				flag = true;
				break;
			}
		}
		
		if(flag === false){
			alert("유권자 확인란에 체크하지 않았습니다");
			return false;
		}
		
		return true;
	}  
	
	//공백확인 함수
	function checkExistData(value, dataName){
		if(value === ""){
			alert(dataName + " 입력해주세요");
			return false;
		}
		return true;
	}
	
	function checkV_jumin(v_jumin) {        
		if (!checkExistData(v_jumin, "주민번호를"))            
			return false;         
		
		var juminReg = /\d{2}([0]\d|[1][0-2])([0][1-9]|[1-2]\d|[3][0-1])[1-4]\d{6}/;       
		if (!juminReg.test(v_jumin)) {            
			alert("주민번호를 확인해주세요");            
			voteForm.v_jumin.value = "";            
			voteForm.v_jumin.focus();            
			return false;        
		}        
		return true;
	}
	
	function checkV_name(v_name) {
		if (!checkExistData(v_name, "성명을"))         
			return false;
		
		var nameReg = /^[가-힣]+$/;       
		if (!nameReg.test(v_name)) {            
			alert("성명은 한글만 입력해야합니다");            
			voteForm.v_name.value = "";            
			voteForm.v_name.focus();            
			return false;        
		}
		console.log("전송 완료");       
		return true;
	}
		
	

	
	
	
</script>

</head>

<body>

	<header>
		<h1>지역구 의원 투표 프로그램</h1>
	</header>
	
	<nav>
		<a href=member.do>후보조회</a> &emsp; 
		<a href=vote.do>투표하기</a> &emsp;
		<a href=voteList.do>투표검수조회</a> &emsp;
		<a href=memberRank.do>후보자등수</a> &emsp;
		<a href=index.do>홈으로</a>
	</nav>
	
	<section>
	<br>
		<h2 align="center">투표지</h2>

		<form id="voteForm" action="vote_ok.do" method="post" onsubmit="return formCheck()">
			<table>

				<tr>
					<td align="center">주민번호</td>
					<td><input type="text" id="v_jumin" name="v_jumin" placeholder="예시) 9408282012341"></td>
				</tr>

				<tr>
					<td align="center">성명</td>
					<td><input type="text" id="v_name" name="v_name"></td>
				</tr>

				<tr>
					<td align="center">후보번호</td>

					<td>
						<select id="m_no" name=m_no>
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
						<select id="v_time" name=v_time>
							<option value="" selected disabled>시간 선택</option>
							<option value="0930">오전 9시 30분</option>
							<option value="1330">오후 1시 30분</option>
						</select>
					</td>
				</tr>

				<tr>
					<td align="center">투표장소</td>
					<td>
						<select id="v_area" name=v_area>
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
						<input type="submit" value="투표하기">
						<input type="reset" value="다시하기">
					</td>

				</tr>

			</table>
		</form>

	</section>
	
	<footer>
	</footer>


</body>
</html>