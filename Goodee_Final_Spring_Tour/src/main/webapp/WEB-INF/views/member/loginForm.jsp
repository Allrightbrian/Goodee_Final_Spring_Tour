<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
<script type="text/javascript" src="./js/login.js"></script>
</head>
<body>
	<div id="container">
		<div id="title">Spring Tour</div>
	
		<form method="post">
		
			<div class="inputWord">아 이 디</div>
			<input type="text" name="id" id="inputId" placeholder="아이디 입력">
			
			<div class="inputWord">비밀번호</div>
			<input type="password" name="password" id="inputPw" placeholder="비밀번호 입력" onkeyup="enterKey()">
				
			<div style="text-align: center">
				<input type="button" id="login" name="login" value="LOGIN" onclick="loginCheck()">
			</div>
		
			<div id="bottom" >
				<input type="button" value="Kakao 로그인" onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=71f95f0473e2f3e8ba2976e1e2f3ec86&redirect_uri=http://localhost:8096/Goodee_Final_Spring_Tour/kakaoLogin.do&response_type=code'">
				<input type="button" id="signUp" value="회원가입">
				<input type="button" value="아이디/비밀번호 찾기" onclick="location.href='./findIdPwForm.do'">
			</div>
		
		
		</form>
	</div>
</body>
</html>