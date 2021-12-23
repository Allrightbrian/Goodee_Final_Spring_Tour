<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./login.do" method="post">
		<input type="text" name="id">
		<input type="password" name="password">
		<input type="submit" value="로그인">
	</form>
	<a href="https://kauth.kakao.com/oauth/authorize?client_id=71f95f0473e2f3e8ba2976e1e2f3ec86&redirect_uri=http://localhost:8096/Goodee_Final_Spring_Tour/kakaoLogin.do&response_type=code">Kakao 로그인</a>
	<br><a href="./joinMemberForm.do">회원가입</a><br>
	<a href="./findIdPwForm.do">아이디/비밀번호 찾기</a>
</body>
</html>