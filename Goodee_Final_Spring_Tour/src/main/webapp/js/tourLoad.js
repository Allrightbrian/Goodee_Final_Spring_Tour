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
	var clickLine;	
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
		 // 지도 위에 선이 표시되고 있다면 지도에서 제거합니다
        deleteClickLine();
        
        // 지도 위에 커스텀오버레이가 표시되고 있다면 지도에서 제거합니다
        deleteDistnce();

        // 지도 위에 선을 그리기 위해 클릭한 지점과 해당 지점의 거리정보가 표시되고 있다면 지도에서 제거합니다
        deleteCircleDot();
		//
		var totalDistnce=0;
		
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
					
					clickLine =new daum.maps.Polyline({
						map:map,
						path:linePath,
						strokeWeightL:3,
						strokeColor: '#db4040',
						strokeOpacity: 1,
						strokeStyle : 'solid'
					});
					distance = Math.round(lineLine.getLength());
					//displayCircleDot(markerPosition, distance);
					
					totalDistnce+=distance;
				
				}
				
				mapx = mapx / Number(data.length);
				mapy = mapy / Number(data.length);
				console.log('평균 좌표 : ' + mapx + ' / ' + mapy);

				panTo(mapy, mapx);
				
               var path = clickLine.getPath();
    
        // 선을 구성하는 좌표의 개수가 2개 이상이면
        if (path.length > 1) {


            var distance = Math.round(clickLine.getLength()), // 선의 총 거리를 계산합니다
                content = getTimeHTML(totalDistnce); // 커스텀오버레이에 추가될 내용입니다
                
            // 그려진 선의 거리정보를 지도에 표시합니다
            showDistance(content, path[path.length-1]);  
             
        } else {

            // 선을 구성하는 좌표의 개수가 1개 이하이면 
            // 지도에 표시되고 있는 선과 정보들을 지도에서 제거합니다.
            deleteClickLine();
            deleteCircleDot(); 
            deleteDistnce();

        }
				
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
// 클릭으로 그려진 선을 지도에서 제거하는 함수입니다
function deleteClickLine() {
    if (clickLine) {
        clickLine.setMap(null);    
        clickLine = null;        
    }
}

// 마우스 드래그로 그려지고 있는 선의 총거리 정보를 표시하거
// 마우스 오른쪽 클릭으로 선 그리가 종료됐을 때 선의 정보를 표시하는 커스텀 오버레이를 생성하고 지도에 표시하는 함수입니다
function showDistance(content, position) {
    
    if (distanceOverlay) { // 커스텀오버레이가 생성된 상태이면
        
        // 커스텀 오버레이의 위치와 표시할 내용을 설정합니다
        distanceOverlay.setPosition(position);
        distanceOverlay.setContent(content);
        
    } else { // 커스텀 오버레이가 생성되지 않은 상태이면
        
        // 커스텀 오버레이를 생성하고 지도에 표시합니다
        distanceOverlay = new kakao.maps.CustomOverlay({
            map: map, // 커스텀오버레이를 표시할 지도입니다
            content: content,  // 커스텀오버레이에 표시할 내용입니다
            position: position, // 커스텀오버레이를 표시할 위치입니다.
            xAnchor: 0,
            yAnchor: 0,
            zIndex: 3  
        });      
    }
}

// 그려지고 있는 선의 총거리 정보와 
// 선 그리가 종료됐을 때 선의 정보를 표시하는 커스텀 오버레이를 삭제하는 함수입니다
function deleteDistnce () {
    if (distanceOverlay) {
        distanceOverlay.setMap(null);
        distanceOverlay = null;
    }
}

// 선이 그려지고 있는 상태일 때 지도를 클릭하면 호출하여 
// 클릭 지점에 대한 정보 (동그라미와 클릭 지점까지의 총거리)를 표출하는 함수입니다
function displayCircleDot(position, distance) {

    // 클릭 지점을 표시할 빨간 동그라미 커스텀오버레이를 생성합니다
    var circleOverlay = new kakao.maps.CustomOverlay({
        content: '<span class="dot"></span>',
        position: position,
        zIndex: 1
    });

    // 지도에 표시합니다
    circleOverlay.setMap(map);

    if (distance > 0) {
        // 클릭한 지점까지의 그려진 선의 총 거리를 표시할 커스텀 오버레이를 생성합니다
        var distanceOverlay = new kakao.maps.CustomOverlay({
            content: '<div class="dotOverlay">거리 <span class="number">' + distance + '</span>m</div>',
            position: position,
            yAnchor: 1,
            zIndex: 2
        });

        // 지도에 표시합니다
        distanceOverlay.setMap(map);
    }

    // 배열에 추가합니다
    dots.push({circle:circleOverlay, distance: distanceOverlay});
}

// 클릭 지점에 대한 정보 (동그라미와 클릭 지점까지의 총거리)를 지도에서 모두 제거하는 함수입니다
function deleteCircleDot() {
    var i;

    for ( i = 0; i < dots.length; i++ ){
        if (dots[i].circle) { 
            dots[i].circle.setMap(null);
        }

        if (dots[i].distance) {
            dots[i].distance.setMap(null);
        }
    }

    dots = [];
}

// 마우스 우클릭 하여 선 그리기가 종료됐을 때 호출하여 
// 그려진 선의 총거리 정보와 거리에 대한 도보, 자전거 시간을 계산하여
// HTML Content를 만들어 리턴하는 함수입니다
function getTimeHTML(distance) {

    // 도보의 시속은 평균 4km/h 이고 도보의 분속은 67m/min입니다
    var walkkTime = distance / 67 | 0;
    var walkHour = '', walkMin = '';

    // 계산한 도보 시간이 60분 보다 크면 시간으로 표시합니다
    if (walkkTime > 60) {
        walkHour = '<span class="number">' + Math.floor(walkkTime / 60) + '</span>시간 '
    }
    walkMin = '<span class="number">' + walkkTime % 60 + '</span>분'

    // 자전거의 평균 시속은 16km/h 이고 이것을 기준으로 자전거의 분속은 267m/min입니다
    var bycicleTime = distance / 227 | 0;
    var bycicleHour = '', bycicleMin = '';

    // 계산한 자전거 시간이 60분 보다 크면 시간으로 표출합니다
    if (bycicleTime > 60) {
        bycicleHour = '<span class="number">' + Math.floor(bycicleTime / 60) + '</span>시간 '
    }
    bycicleMin = '<span class="number">' + bycicleTime % 60 + '</span>분'

    // 거리와 도보 시간, 자전거 시간을 가지고 HTML Content를 만들어 리턴합니다
    var content = '<ul class="dotOverlay distanceInfo">';
    content += '    <li>';
    content += '        <span class="label" style="color:#333333">총거리</span><span class="number">' + distance + '</span>m';
    content += '    </li>';
    content += '    <li>';
    content += '        <span class="label" style="color:#333333">도보</span>' + walkHour + walkMin;
    content += '    </li>';
    content += '    <li>';
    content += '        <span class="label" style="color:#333333">자전거</span>' + bycicleHour + bycicleMin;
    content += '    </li>';
    content += '</ul>'

    return content;
}
})