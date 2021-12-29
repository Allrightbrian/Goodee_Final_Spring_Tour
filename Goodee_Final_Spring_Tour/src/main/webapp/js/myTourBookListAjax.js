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
					var cell5 = row.insertCell(4);
					cell1.innerHTML =JSON.parse(data[i]).title;
					cell2.innerHTML = JSON.parse(data[i]).keyword;
					cell3.innerHTML = JSON.parse(data[i]).regdate;
					cell4.innerHTML = "<input type='button' onclick="+"\""+"location.href="+"\'"+"./myTourBookDetail.do?bookNo="+JSON.parse(data[i]).bookNo+"\'\""+"value='상세보기'>";
					cell5.innerHTML = "<input type='checkbox' class='myTourBook' name='check' onchange='onChange()' value="+JSON.parse(data[i]).bookNo+">";
				}
			},error: function() {
				alert("실패");
			}
		});
}
$(document).ready(function() {

$("#checkAll").click(function(){
		if($("#checkAll").prop("checked")){
			$(".myTourBook").prop("checked",true);
		}else{
			$(".myTourBook").prop("checked",false);
		}
})



})


function insert(){
   console.log("새글 작성 submit");
   var frm = document.getElementById("frmWrite");
   frm.action = "./myTourBookInsert.do";
   var title = document.getElementById("name");
   var keyword = document.getElementById("keyword");
	console.log("TITLE:"+title.value+"KEYWORD:"+keyword.value);
   if(title.value =="" || keyword.value == ""){
      swal("새글 작성 오류", "제목과 내용은 필수 입니다.");
   }else{
      frm.submit();
   }
   
}