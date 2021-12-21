<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="./js/EstimateInsertForm.js"></script>
</head>
<body>
	<div class="container">
	<form action="./EstimateInsert.do" method="post">
	<select title="대분류 선택" name="areacode" id="main_category"
		style="width: 150px">
		<option value="0">==대분류 선택==</option>
	</select>
	<input type="hidden" value="${requestScope.bookNo}" name="bookNo">
	<select title="중분류 선택" name="sigungucode" id="sub_category"
		style="width: 150px">
		<option value="0">==중분류 선택==</option>
	</select>
	<input type="text" name="title" placeholder="제목을 입력해주세요"/>
	<textarea name="content" rows="30" cols="15" placeholder="내용을 입력해주세요"></textarea>
	<input type="number" min='1' max='30' step='1' name="numOfAttr" placeholder="최소 투어 개수를 입력해주세요(최대 30개)"/>
	<input type="submit" value="Estimate 생성"/>
	</form>
	</div>
</body>
</html>