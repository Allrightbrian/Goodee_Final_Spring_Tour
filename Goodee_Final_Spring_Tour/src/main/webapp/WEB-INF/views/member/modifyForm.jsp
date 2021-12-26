<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<input type="hidden" name="id" value="${sessionScope.member.id}">
	<c:if test="${sessionScope.member.snsjoin eq 'N'}">
		아이디 : ${sessionScope.member.id}<br>
		비번 : <input type="password" name="password" maxlength="20"><br>
		비밀번호 확인 : <input type="password" name="passwordCheck" maxlength="20"><br>
	</c:if>
	이름 : <input type="text" name="name" value="${sessionScope.member.name}" ><br>
	닉네임 : <input type="text" name="nickname" maxlength="10" value="${sessionScope.member.nickname}"><button type="button" onclick="duplicateCheckNick()">닉네임 중복체크</button> <br>
	<div id="checkResultNick"></div> 
	<input type="hidden" id="checkNickFlag" value="${sessionScope.member.nickname }">
	휴대폰 번호 : <input type="tel" name="phone" value="${sessionScope.member.phone}" maxlength="11"><br>
	이메일 : <input type="email" name="email" value="${sessionScope.member.email}" ><br>
	
	<button type="button" onclick="memberModifyCheck('${sessionScope.member.snsjoin}');">수정하기</button><br>
	<input type="button" value="뒤로가기" onclick="history.back()">
	</form>
</body>
</html>