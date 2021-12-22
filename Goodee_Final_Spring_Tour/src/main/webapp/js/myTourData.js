/**
 * 
 */

$(document).ready(function() {

	//카카오맵 초기화
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(33.450701, 126.570667),
		level: 3
	};
	var map = new kakao.maps.Map(container, options);

	var markers = [];

	//getJSON을 이용한 JSON 데이터 가져오기 (지역 코드 [대분류])
	$.getJSON("./getAjaxMain.do", function(data) {
		$.each(data, function(index, value) {
			$('#main_category').append(
				'<option value="' + value.code + '">'
				+ value.name + '</option>');
		});
	});

	//지역 대분류 코드 선택시 해당하는 중분류 코드 데이터 출력
	$('#main_category').change(function() {
		$('#sub_category option').remove();
		$.getJSON("./getAjaxSub.do?areaCode=" + this.options[this.selectedIndex].value, function(data) {
			$.each(data, function(index, value) {
				$('#sub_category').append(
					'<option value="' + value.code + '">'
					+ value.name + '</option>');
			});
		});
	});


	$('#search').click(function() {

		console.log("검색 클릭");
		var mainCode = $("select[name=codeId]").val();
		var subCode = $("select[name=detailCodeId]").val();
		console.log("대분류 코드 : " + mainCode + ", 중분류 코드 : " + subCode);

		$.ajax({
			url: "./ajaxSearch.do?areaCode=" + mainCode + "&sigunguCode=" + subCode,
			type: "GET",
			datatype: "JSON",
			success: function(data) {
				$("#attrTest tr").remove();

				setMarkers(null);
				var mapx = 0;
				var mapy= 0;
				
				for (list in data) {

					var mapx = Number(mapx) + Number(data[list].mapx);
					var mapy = Number(mapy) + Number(data[list].mapy);
					var my_tbody = document.getElementById('attrTest');
					var row = my_tbody.insertRow( my_tbody.rows.length );
					var cell1 = row.insertCell(0);
    				var cell2 = row.insertCell(1);
    				var cell3 = row.insertCell(2);
    				var cell4 = row.insertCell(3);
					cell1.innerHTML =
					"<a href='./myTourDataDetail.do?contentId="+data[list].contentid+"'>"+data[list].title+"</a>"
					+"<input type='hidden' name='name' value='"+data[list].title+"'>";
					if(data[list].addr2!=null && data[list].addr1!=null){
						cell2.innerHTML = data[list].addr1 +" "+ data[list].addr2;
					}else if(data[list].addr2==null){
						cell2.innerHTML = data[list].addr1;
					}else if(data[list].addr1==null){
						cell2.innerHTML = data[list].addr2;
					}else if(data[list].addr2==null && data[list].addr1==null){
						cell2.innerHTML = "주소가 현재 입력되지 않았습니다";
					}
					cell3.innerHTML = data[list].contentid;
					cell4.innerHTML = "<input type='checkbox' class='myTourData' name='check' onchange='onChange()' value='"+data[list].contentid+"'>";

					var markerPosition = new kakao.maps.LatLng(data[list].mapy, data[list].mapx);

					var marker = new kakao.maps.Marker({
						position: markerPosition,
					});

					markers.push(marker);

					// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
					var iwContent = '<div style="padding:5px;">' + data[list].title + '</div>'
					
					, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
						iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

					// 인포윈도우를 생성합니다
					var infowindow = new kakao.maps.InfoWindow({
						content: iwContent,
						removable: iwRemoveable
					});

					marker.setMap(map);
					
					kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));
					
				}
				

				mapx = mapx / Number(data.length);
				mapy = mapy / Number(data.length);
				console.log("평균 좌표 : " + mapx + " / " + mapy);

				panTo(mapy, mapx);
			},
			error: function() {
				$("#attrTest").text("");
				$("#attrTest").append("조회 결과가 없습니다.");
			}
		})
	})

	function panTo(mapy, mapx) {
		var moveLatLon = new kakao.maps.LatLng(mapy, mapx);
		map.panTo(moveLatLon);
	}

	function setMarkers(map) {
		if (map === null) {
			markers.length = 0;
		} else {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(map);
			}
		}
	}
	
	function makeOverListener(map, marker, infowindow) {
    	return function() {
        	infowindow.open(map, marker);
    	};
	}	
	$("#checkAll").click(function(){
		if($("#checkAll").prop("checked")){
			$(".myTourData").prop("checked",true);
		}else{
			$(".myTourData").prop("checked",false);
		}
	})
});


function onChange(){
		var total = $("input[name=check]").length;
			var checked = $("input[name=check]:checked").length;
			if(total == checked){
				$("#checkAll").prop("checked",true);
			}else{
				$("#checkAll").prop("checked",false);
			}
	}

