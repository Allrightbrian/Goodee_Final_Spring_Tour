<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="./js/myTourBookListAjax.js"></script>
<script type="text/javascript">
	function myTourBookInsert() {
		location.href="./myTourBookInsertForm.do";
	}
	
</script>
<title>MyTourBook 검색</title>
</head>
<body>
	<div class="container">
  <h2>MyTourBook 검색</h2>
  <input type="button" onclick="myTourBookInsert();" id="myTourBookInsert" value="MyTourBook생성하기"/>
  <input type="text" id="title" name="title" placeholder="제목을 입력해주세요.">
  <input type="button" onclick="titleseach();" id="titleSeach" value="검색"/>
  <table class="table table-striped">
    <thead>
      <tr>
        <td>제목</td>
        <td>키워드</td>
        <td>생성날짜</td>
        <td>상세보기</td>
      </tr>
    </thead>
    <tbody id="tbody">
    <c:if test="${!empty requestScope.myTourBookList}">
     <c:forEach var="myTourBook" items="${requestScope.myTourBookList}">
     	<tr>
     		<td>${myTourBook.title}</td>
        	<td>${myTourBook.keyword}</td>
        	<td>${myTourBook.regdate}</td>
        	<td><input type="button"  onclick="location.href='./myBookTourDetail.do?bookNo=${myTourBook.bookNo}'" value="상세보기"></td>	
     	</tr>
     </c:forEach>
     </c:if>
    </tbody>
  </table>
</div>
</body>
</html>