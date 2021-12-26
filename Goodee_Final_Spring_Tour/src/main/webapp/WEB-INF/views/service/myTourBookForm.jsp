<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="./js/duplication.js"></script>
<%@ include file="../common/topMenu.jsp" %>
</head>
<body>
<form action="./myTourBookInsert.do" method="get">
  <div class="form-group">
    <label for="title">Title:</label>
    <input type="text" class="form-control" id="title" name="title">
  </div>
  <div class="form-group">
    <label for="keyword">Keyword:</label>
    <input type="text" class="form-control" id="keyword" name="keyword">
  </div>
  <input type="submit" value="mytourBook 생성">
</form>
</body>
</html>