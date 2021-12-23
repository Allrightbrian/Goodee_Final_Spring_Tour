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
	
	$("#toruLoadInsert").click(function() {
		var contentId = document.getElementsByClassName("contentId");
		var tourOrder = document.getElementsByClassName("tourOrder");
		for (var i = 0; i < tourOrder.length; i++) {
     		console.log(tourOrder[i].value,contentId[i].textContent);
    	}
		var Arrays = [];
		for (var i = 0; i < contentId.length; i++) {
     		Arrays.push(contentId[i].textContent);
    	}
		var objParams = {"contentId" : Arrays };
		$.ajax({
			url: "./ajaxSearchTourDataList.do",
			data: objParams,
			type: "POST",
			datatype: "JSON",
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
					var iwContent = '<div style="padding:5px;">' + data[list].title + '</div>'
					
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
				console.log("평균 좌표 : " + mapx + " / " + mapy);

				panTo(mapy, mapx);
				
			},
			error: function() {
				alert("데이터 입력이 잘못되었습니다.");
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
					content: '<div class="dotOverlay">거리<span class="number">'+distance+'</span>m</div>',
					position: position,
					yAnchor: 1,
					zIndex: 2
				
			});
			//지도에 표시합니다
			distanceOverlay.setMap(map);
		}
	}
	
	
})
