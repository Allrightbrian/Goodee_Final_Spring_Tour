/**
 * 
 */

function titleseach(){
	
	var title=document.getElementById("title").value;
		$.ajax({
			url: "./myTourbookTitleSerach.do?title="+title,
			type:'POST',
            dataType:'json',
			success: function(data) {
				$("#tbody tr").remove();
				for (var i in data) {
					
					var my_tbody = document.getElementById('tbody');
					var row = my_tbody.insertRow( my_tbody.rows.length );
					var cell1 = row.insertCell(0);
    				var cell2 = row.insertCell(1);
    				var cell3 = row.insertCell(2);
    				var cell4 = row.insertCell(3);
					cell1.innerHTML =JSON.parse(data[i]).title;
					cell2.innerHTML = JSON.parse(data[i]).keyword;
					cell3.innerHTML = JSON.parse(data[i]).regdate;
					cell4.innerHTML = "<input type='button' onclick="+"\""+"location.href="+"\'"+"./myTourBookDetail.do?bookNo="+JSON.parse(data[i]).bookNo+"\'\""+"value='상세보기'>";
				}
			},error: function() {
				alert("실패");
			}
		});
}
