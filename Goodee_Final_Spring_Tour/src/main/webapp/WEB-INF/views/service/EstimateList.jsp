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
	<div class="container">
  <h2>MyTourBook 검색</h2>
  <input type="button" onclick="myTourBookInsert();" id="myTourBookInsert" value="MyTourBook생성하기"/>
  <input type="text" id="title" name="title" placeholder="제목을 입력해주세요.">
  <input type="button" onclick="titleseach();" id="titleSeach" value="검색"/>
  
  <table class="table table-striped">
    <thead>
      <tr>
        <td>지역코드</td>
        <td>시구별코드</td>
        <td>제목</td>
        <td>최소개수</td>
        <td>작성자</td>
      </tr>
    </thead>
    <tbody id="tbody">
    <c:if test="${!empty requestScope.lists}">
     <c:forEach var="estimate" items="${requestScope.lists}">
     	<tr>
     		<td>${estimate.areacode}</td>
        	<td>${estimate.sigungucode}</td>
        	<td>${estimate.title}</td>
        	<td>${estimate.numOfAttr}</td>
        	<td>${estimate.userId}</td>
     	</tr>
     </c:forEach>
     </c:if>
     <c:if test="${empty requestScope.lists}">
     	검색 결과가 없습니다.
     </c:if>
    </tbody>
  </table>
</div>
</body>
</html>