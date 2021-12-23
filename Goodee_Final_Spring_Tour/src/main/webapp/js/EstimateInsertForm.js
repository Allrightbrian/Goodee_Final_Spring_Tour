/**
 * 
 */

$(document).ready(function() {
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
	
	
});