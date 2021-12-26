<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f88578ab5b343bb364a9da74573288e2"></script>
<script type="text/javascript" src="./js/tourLoad.js"></script>
<script type="text/javascript">
	function myTourDataInsertForm() {
		location.href = "./myTourDataInsertForm.do?bookNo=" + ${requestScope.bookNo};
	}

	function onChangeAll() {
		if ($("#checkAll").prop("checked")) {
			$(".myTourData").prop("checked", true);
		} else {
			$(".myTourData").prop("checked", false);
		}
	}
	function onChange() {
		var total = $("input[name=check]").length;
		var checked = $("input[name=check]:checked").length;
		if (total == checked) {
			$("#checkAll").prop("checked", true);
		} else {
			$("#checkAll").prop("checked", false);
		}
	}
	function tourOrderUpdate() {
		var tourOrderList = document.getElementsByClassName("tourOrder");
		for (var i = 0; i < tourOrderList.length; i++) {
			if (tourOrderList[i].value == 0) {
				swal("제로 값 오류", "0이 존재합니다.");
				return false;
			}
			for (var j = 0; j < tourOrderList.length; j++) {
				if (tourOrderList[i].value == tourOrderList[j].value
						&& tourOrderList[j].value != 0 && i != j) {
					swal("동일 값 오류", "동일한 순서가 존재합니다.");
					return false;
				}
			}
		}
		console.log("순서변경");
		return true;
	}
</script>
<title>myTourBookDetail</title>
<style>
.dot {overflow:hidden;float:left;width:12px;height:12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/mini_circle.png');}    
.dotOverlay {position:relative;bottom:10px;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;float:left;font-size:12px;padding:5px;background:#fff;}
.dotOverlay:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}    
.number {font-weight:bold;color:#ee6152;}
.dotOverlay:after {content:'';position:absolute;margin-left:-6px;left:50%;bottom:-8px;width:11px;height:8px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white_small.png')}
.distanceInfo {position:relative;top:5px;left:5px;list-style:none;margin:0;}
.distanceInfo .label {display:inline-block;width:50px;}
.distanceInfo:after {content:none;}
.lable {
	color: #333333;

}
</style>
</head>
<body>
	<div class="container">
		<h2>myTourBookDetail</h2>
		<form action="./myTourDataTourOrder.do" method="post" onsubmit="return tourOrderUpdate();">
		
			<input type="button" onclick="myTourDataInsertForm();"
				id="myTourDataInsert" value="MyTourData추가하기" />
			<input type="hidden" id="bookNo" value="${requestScope.bookNo}" name="bookNo">
			<input type="submit" value="투어순서변경">
			<input type="button" id="myTourDataDelete" value="삭제" ><!-- formaction="./myTourDataDelete.do" -->
 			<table class="table table-striped">
				<thead>
					<tr>
						<td>이름</td>
						<td>지역코드</td>
						<td>시군별코드</td>
						<td>투어순서</td>
						<td>데이터ID</td>
						<td>전체삭제하기<input type="checkbox" name="checkAll"
							id="checkAll" onchange='onChangeAll()' /></td>
					</tr>
				</thead>
				<tbody id="tbody">
					<c:if test="${!empty requestScope.myTourDatalists}">
						<c:forEach var="myTourData"
							items="${requestScope.myTourDatalists}">
							<tr class="myTourDataList">
								<td>${myTourData.name}</td>
								<td>${myTourData.attrLoc1}</td>
								<td>${myTourData.attrLoc2}</td>
								<td><input type="text" name="tourOrder" class="tourOrder"
									value="${myTourData.tourOrder}"></td>
								<td><p class="contentId">${myTourData.contentId}</p> <input
									type="hidden" name="dataNo" value="${myTourData.dataNo}"></td>
								<td><input type='checkbox' class='myTourData' name='check'
									onchange='onChange()' value="${myTourData.dataNo}"></td>
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
				<div id="map"
					style="width: 800px; height: 400px; border: 1px solid black"></div>
			</div>


		</form>
	</div>
</body>
</html>