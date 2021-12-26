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
	<form method="post">
		이름 : <input type="text" name="name"><br>
		핸드폰 번호 : <input type="tel" name="phone"><br>
		<input type="button" value="아이디 찾기" onclick="findId(${sessionScope.member.id})">
	</form>
	<div id="resultId" style="display:none">
		<p id="ajaxresult"></p>
		<button type="button" onclick="script:location.href='./loginForm.do'">로그인</button>
	</div>
	<form action="./findPw.do" method="post">
		아이디 : <input type="text" name="id"><br>
		이름 : <input type="text" name="name"><br>
		핸드폰 번호 : <input type="tel" name="phone"><br>
		<input type="submit" value="패스워드 찾기">
	</form>
</body>
</html>