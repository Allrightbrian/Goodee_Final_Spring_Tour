<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${sessionScope.member.id}
	<br>${sessionScope.member.nickname}
	<a href="./logout.do">로그아웃</a>
	<a href="./confirmPw.do">정보 수정</a>
</body>
</html>