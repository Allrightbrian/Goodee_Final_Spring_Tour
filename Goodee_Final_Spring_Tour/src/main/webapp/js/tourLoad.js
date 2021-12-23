/**
 * 
 */
$(document).ready(function() {
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(37.550701, 127.070667),
		level: 5
	};
	var map = new kakao.maps.Map(container, options);
	var distanceOverlay; //선의 거리정보를 표시할 커스텀오버
	var dots ={}; //선이 그려지고 있을 때 클릭 할 때마다 클릭 지점과 거리를 표시
	var linePath;
	var lineLine = new daum.maps.Polyline();
	var distance;
	
	var markers = [];
	
	$('#toruLoadInsert').click(function() {
		var contentId = document.getElementsByClassName('contentId');
		var tourOrder = document.getElementsByClassName('tourOrder');
		for (var i = 0; i < tourOrder.length; i++) {
     		console.log(tourOrder[i].value,contentId[i].textContent);
    	}
		var Arrays = [];
		for (var i = 0; i < contentId.length; i++) {
     		Arrays.push(contentId[i].textContent);
    	}
		var objParams = {'contentId' : Arrays };
		$.ajax({
			url: './ajaxSearchTourDataList.do',
			data: objParams,
			type: 'POST',
			datatype: 'JSON',
			success: function(data) {
				console.log(data);
				setMarkers(null);
				var mapx = 0;
				var mapy= 0;
				for (list in data) {
					var mapx = Number(mapx) + Number(data[list].mapx);
					var mapy = Number(mapy) + Number(data[list].mapy);
					var markerPosition = new kakao.maps.LatLng(data[list].mapy, data[list].mapx);

					var marker = new kakao.maps.Marker({
						position: markerPosition,
					});

					markers.push(marker);
					var iwContent = "<div style='padding:5px;'>" + data[list].title + "</div>"
					
					, iwRemoveable = true; 


					var infowindow = new kakao.maps.InfoWindow({
						content: iwContent,
						removable: iwRemoveable
					});

					marker.setMap(map);
					
					kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));
				
					if(list != 0){
						linePath =  [new kakao.maps.LatLng(data[list-1].mapy, data[list-1].mapx) ,new kakao.maps.LatLng(data[list].mapy, data[list].mapx)]
					}
					lineLine.setPath(linePath);
					
					var drawLine =new daum.maps.Polyline({
						map:map,
						path:linePath,
						strokeWeightL:3,
						strokeColor: '#db4040',
						strokeOpacity: 1,
						strokeStyle : 'solid'
					});
					distance = Math.round(lineLine.getLength());
					displayCircleDot(markerPosition, distance);
					
				}
				
				mapx = mapx / Number(data.length);
				mapy = mapy / Number(data.length);
				console.log('평균 좌표 : ' + mapx + ' / ' + mapy);

				panTo(mapy, mapx);
				
			},
			error: function() {
				alert('데이터 입력이 잘못되었습니다.');
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
	function displayCircleDot(position,distance){
		if(distance>0){
			var distanceOverlay = new daum.maps.CustomOverlay(
				{
					content: "<div class='dotOverlay'>거리<span class='number'>"+distance+"</span></div>",
					position: position,
					yAnchor: 1,
					zIndex: 2
				
			});
			//지도에 표시합니다
			distanceOverlay.setMap(map);
		}
		
	}
	$('#myTourDataDelete').click(function(){
		var check=[];
		var bookNo= $('#bookNo').val();
		$('input[name=check]:checked').each(function(){
			var chk=$(this).is(':checked');
			if(chk==true){
				check.push($(this).val());
			}
		})
		console.log(check);
		var objParams = {'check' : check };
		$.ajax({
			url: './myTourDataDelete.do?bookNo='+bookNo,
			data: objParams,
			type: 'POST',
			datatype: 'JSON',
			success: function(data) {
				$('.myTourDataList').remove();
				console.log(data.list);
				for(i in data.list){
				var my_tbody = document.getElementById('tbody');
				var row = my_tbody.insertRow( my_tbody.rows.length );
				 $("#tbody tr").addClass('myTourDataList');	
					var cell1 = row.insertCell(0);
    				var cell2 = row.insertCell(1);
    				var cell3 = row.insertCell(2);
    				var cell4 = row.insertCell(3);
    				var cell5 = row.insertCell(4);
    				var cell6 = row.insertCell(5);
					cell1.innerHTML = data.list[i].name;
					cell2.innerHTML = data.list[i].attrLoc1;
					cell3.innerHTML = data.list[i].attrLoc2;
					cell4.innerHTML = "<input type='text' name='tourOrder' class='tourOrder' value='"+data.list[i].tourOrder+"'>";					 
					cell5.innerHTML = "<p class='contentId'>"+data.list[i].contentId+"</p>"+"<input type='hidden' name='dataNo' value='"+data.list[i].dataNo+"'>";
					cell6.innerHTML = "<input type='checkbox' class='myTourData' name='check' onchange='onChange()' value="+data.list[i].dataNo+">";
				}
			},
			error: function(){
				alert('오류가 발생했습니다. 삭제가 완료되지 못했습니다.');
			}
		});
	});
	
})
