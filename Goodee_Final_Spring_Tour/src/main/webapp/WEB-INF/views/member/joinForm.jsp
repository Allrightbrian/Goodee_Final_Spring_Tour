<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/member.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="./joinMember.do" method="post">
	아이디 : <input type="text" name="id" maxlength="20" onkeyup="duplicateCheckId()"><br>
	 <!-- onkeyup으로 아이디 맞으면 중복체크 버튼disabled 풀고 틀리면 중복체크 못하게 하는 로직 생각해보기 -->
	<div id="checkResultId"></div> 
	<input type="hidden" id="checkIdFlag" value="false">
	비밀번호 : <input type="password" name="password" maxlength="20"><br>
	비밀번호 확인 : <input type="password" name="passwordCheck" maxlength="20"><br>
	이름 : <input type="text" name="name"><br>
	닉네임 : <input type="text" name="nickname" maxlength="10"><button type="button" onclick="duplicateCheckNick()">닉네임 중복체크</button> <br>
	<div id="checkResultNick"></div> 
	<input type="hidden" id="checkNickFlag" value="false">
	핸드폰 번호 : <input type="hidden" name="phone">
		<select name="phone1">
			<option value="010" selected>010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
		</select>
	<input type="tel" name="phone2" maxlength="4"> - <input type="tel" name="phone3" maxlength="4"><br>
	이메일 : <input type="email" name="email"><br>
	<input type="submit" value="회원가입" onclick="return infoCheck();"><br>
	<input type="button" value="뒤로가기" onclick="history.back()">
	</form>
	<button type="button" onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=71f95f0473e2f3e8ba2976e1e2f3ec86&redirect_uri=http://localhost:8096/Goodee_Final_Spring_Tour/kakaoJoin.do&response_type=code'">카카오 회원가입</button>
</body>
</html>











