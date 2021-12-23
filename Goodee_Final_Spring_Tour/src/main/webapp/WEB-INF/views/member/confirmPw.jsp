<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:if test="${msg != null}">
		<script>alert('${msg}')</script>	
	</c:if> --%>
	<form action="./ModifyMemberInfoForm.do" method="post">
		로그인 하신 비밀번호를 입력해 주세요.<input type="password" name="password">
		<input type="submit" value="입력">
	</form>
</body>
</html>