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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f88578ab5b343bb364a9da74573288e2"></script>
<script type="text/javascript" src="./js/tourLoad.js"></script>
<script type="text/javascript">
	function myTourDataInsertForm() {
		location.href="./myTourDataInsertForm.do?bookNo="+${requestScope.bookNo};
	}
	
	function onChangeAll(){
		if($("#checkAll").prop("checked")){
			$(".myTourData").prop("checked",true);
		}else{
			$(".myTourData").prop("checked",false);
		}
	}
	function onChange(){
		var total = $("input[name=check]").length;
			var checked = $("input[name=check]:checked").length;
			if(total == checked){
				$("#checkAll").prop("checked",true);
			}else{
				$("#checkAll").prop("checked",false);
			}
	}
</script>
<title>myTourBookDetail</title>
</head>
<body>
	<div class="container">
  <h2>myTourBookDetail</h2>
  <form action="./myTourDataDelete.do" method="post">
  <!-- 
  	<input type="submit" value="수정" formaction="/manage/update">
	<input type="submit" value="삭제" formaction="/manage/delete">
   -->
  <input type="button" onclick="myTourDataInsertForm();" id="myTourDataInsert" value="MyTourData추가하기"/>
  <input type="text" id="title" name="title" placeholder="제목을 입력해주세요.">
  <input type="button" onclick="titleseach();" id="titleSeach" value="검색"/>
  <input type="hidden" value="${requestScope.bookNo}" name="bookNo">
  <input type="submit" value="투어순서변경" formaction="./myTourDataTourOrder.do">
  <input type="submit" value="삭제" formaction="./myTourDataDelete.do">
  <table class="table table-striped">
    <thead>
      <tr>
      	<td>이름</td>
        <td>지역코드</td>
        <td>시군별코드</td>
        <td>투어순서</td>
        <td>데이터ID</td>
        <td>전체삭제하기<input type="checkbox" name="checkAll" id="checkAll"  onchange='onChangeAll()'/></td>
      </tr>
    </thead>
    <tbody id="tbody">
    <c:if test="${!empty requestScope.myTourDatalists}">
     <c:forEach var="myTourData" items="${requestScope.myTourDatalists}">
     	<tr class="myTourDataList">
     		<td>${myTourData.name}</td>
     		<td>${myTourData.attrLoc1}</td>
        	<td>${myTourData.attrLoc2}</td>
        	<td><input type="text" name="tourOrder" class="tourOrder" value="${myTourData.tourOrder}"></td>
        	<td><p class="contentId">${myTourData.contentId}</p><input type="hidden" name="dataNo" value="${myTourData.dataNo}"></td>	
        	<td><input type='checkbox' class='myTourData' name='check' onchange='onChange()' value="${myTourData.dataNo}"></td>
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
  <div id="tourLoad">
  	<input type="button" id="toruLoadInsert" value="투어로드 생성">
  	<div id="map" style="width: 800px; height: 400px; border: 1px solid black"></div>
  </div>
  
  
  </form>
</div>
</body>
</html>