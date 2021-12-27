<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f88578ab5b343bb364a9da74573288e2"></script>
<!-- 97477e57eb9637987516239b7670e4da -->
<script type="text/javascript" src="./js/myTourData.js"></script>
<script type="text/javascript">
$("#checkAll").click(function(){
	if($("checkAll").prop("checked")){
		$("input[name=check]").prop("checked",true);
	}else{
		$("input[name=check]").prop("checked",false);
	}
})

$(".myTourData").click(function(){
var total = $("input[name=check]").length;
var checked = $("input[name=check]:checked").length;
if(total == checked){
	$("#checkAll").prop("checked",true);
}else{
	$("#checkAll").prop("checked",false);
}
})
</script>
<title>Document</title>
<style>
.attrContainer {
	border: 1px solid black;
	width: 500px;
	margin: 0 auto;
}
</style>
<%@ include file="../common/topMenu.jsp" %>
</head>

<body>
	<div class="container">
	<form action="./myTourDataInsert.do?bookNo=${requestScope.bookNo}" method="post">
	<select title="대분류 선택" name="codeId" id="main_category"
		style="width: 150px">
		<option value="0">==대분류 선택==</option>
	</select>
	<input type="hidden" value="${requestScope.bookNo}" name="bookNo">
	<select title="중분류 선택" name="detailCodeId" id="sub_category"
		style="width: 150px">
		<option value="0">==중분류 선택==</option>
	</select>
	<input type="button" id="search" value="검색">
	<input type="submit" id="insert" value="myTourData 생성"/>
	<div id="map" style="width: 800px; height: 400px; border: 1px solid black"></div>
	<table class="table table-striped">
    <thead>
      <tr>
        <td>제목</td>
        <td>주소</td>
        <td>지역아이디</td>
        <td>전체선택하기<input type="checkbox"  name="checkAll" id="checkAll"/></td>
      </tr>
    </thead>
    <tbody id="attrTest">
    </tbody>
    </table>
    </form>
	</div>
</body>

</html>