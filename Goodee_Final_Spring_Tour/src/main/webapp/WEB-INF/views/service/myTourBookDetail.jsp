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
<script type="text/javascript">
	function myTourDataInsertForm() {
		location.href="./myTourDataInsertForm.do";
	}
	
</script>
<title>myTourBookDetail</title>
</head>
<body>
	<div class="container">
  <h2>myTourBookDetail</h2>
  <input type="button" onclick="myTourDataInsertForm();" id="myTourDataInsert" value="MyTourData추가하기"/>
  <input type="text" id="title" name="title" placeholder="제목을 입력해주세요.">
 	<input type="button" onclick="titleseach();" id="titleSeach" value="검색"/>
  <table class="table table-striped">
    <thead>
      <tr>
        <td>지역코드</td>
        <td>시군별코드</td>
        <td>투어순서</td>
        <td>데이터ID</td>
      </tr>
    </thead>
    <tbody id="tbody">
    <c:if test="${!empty requestScope.myTourDatalists}">
     <c:forEach var="myTourData" items="${requestScope.myTourDatalists}">
     	<tr>
     		<td>${myTourData.attrLoc1}</td>
        	<td>${myTourData.attrLoc2}</td>
        	<td>${myTourData.tourOrder}</td>
        	<td>${myTourData.contentId}</td>	
     	</tr>
     </c:forEach>
     </c:if>
      <c:if test="${empty myTourDatalists}">
      	<tr>
      		<td colspan="4">데이터가 없습니다.</td>
      	</tr>
      </c:if>
    </tbody>
  </table>
</div>
</body>
</html>