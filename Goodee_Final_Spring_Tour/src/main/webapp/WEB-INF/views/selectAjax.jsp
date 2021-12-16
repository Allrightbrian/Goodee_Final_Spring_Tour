<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=97477e57eb9637987516239b7670e4da"></script>
<script type="text/javascript" src="./js/AjaxService.js"></script>
<title>Document</title>
<style>
.attrContainer {
	border: 1px solid black;
	width: 500px;
	margin: 0 auto;
}
</style>
</head>

<body>
	<select title="대분류 선택" name="codeId" id="main_category"
		style="width: 150px">
		<option value="0">==대분류 선택==</option>
	</select>

	<select title="중분류 선택" name="detailCodeId" id="sub_category"
		style="width: 150px">
		<option value="0">==중분류 선택==</option>
	</select>

	<input type="button" id="search" value="검색">

	<!-- <div class="Wrapper">
            <div class="attrContainer">
                  <p id="title">제목 들어가는 곳</p>
                  <p id="mapx">X좌표</p>
                  <p id="mapy">Y좌표</p>
            </div>
      </div> -->

	<p id="attrTest"></p>

	<div id="map" style="width: 500px; height: 400px; border: 1px solid black"></div>

	
</body>

</html>