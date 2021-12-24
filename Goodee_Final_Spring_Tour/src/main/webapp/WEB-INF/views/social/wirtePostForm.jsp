<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./nav.jsp"%>
<title>writePostForm</title>
</head>
<body>
	<div class="container">
		<form action="./wirtePost.do" method="post">
			<input type="text" name="id" value="${sessionScope.userid}"><br>
			제목 : <input type="text" name="post_title" class="form-control"> <br>
			이미지 : <input type="text" name="post_img_path" value="post_img_path"> <!-- <input type="file" name="post_img_path" class="form-control" value="test/imgpath"> <br> -->
			내용 :
			<textarea rows="5" name="post_content" class="form-control"></textarea>
			<br> <select name="post_theme_id" onchange="myTourSelect()">
				<c:forEach var="theme" items="${sessionScope.themeList}">
					<option value="${theme.theme_id}">${theme.theme_name}</option>
				</c:forEach>
			</select><br> 
			<select name="bookno" onchange="myTourSelect()">
				<c:forEach var="myTourBook" items="${myTourList}">
					<option value="${myTourBook.bookNo}">${myTourBook.title}</option>
				</c:forEach>
			</select> <input type="submit" value="포스트하기">
		</form>
	</div>
</body>
</html>