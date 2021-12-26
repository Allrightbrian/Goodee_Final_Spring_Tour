<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./kakaoJoinForm.do" method="post">
		이름 : <input type="text" name="name">
		닉네임 : <input type="text" name="nickname" value="${userInfo.nickname}">
		핸드폰 : <input type="text" name="phone">
		<input type="hidden" name="email" value="${userInfo.email}">
		<input type="hidden" name="id" value="${userInfo.email }">
		<input type="hidden" name="password" value="">
		<input type="submit" value="가입">
	</form>
</body>
</html>