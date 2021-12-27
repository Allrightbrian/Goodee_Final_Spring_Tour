window.onload = function(){
	var secretflag = document.getElementsByName("secretflag")[0];
	var checkbox = document.getElementById("secretflag");
	if(secretflag != null && secretflag.value=="Y"){
		checkbox.checked = true;
	}
	if(checkbox != null){
		checkbox.addEventListener("change",function(){
			secretflag.value = (checkbox.checked == true)? "Y":"N";
		});
	}
}

function updateReport(report_num){
	var title = document.getElementsByName("title")[0];
	var content = document.getElementsByName("content")[0];
	var secretflag = document.getElementsByName("secretflag")[0];
	var originContent = document.getElementById("originContent");
	
	console.log(title.value);
	console.log(content.value);
	console.log(secretflag.value);
	
	if(title.value.trim() == "" || content.value.trim()==""){
		alert('제목과 내용을 모두 입력해 주셔야 합니다!!');
		return false;
	}
	
	if(originContent.value != content.value){
		var contval = content.value;
		contval = contval.replace(/\r\n|\r|\n|\n\r/g, '<br>');
		contval = contval.replace(/</g,'&lt;');
		contval = contval.replace(/>/g,'&gt;');
		content.textContent = contval;
	}
	
	$.ajax({
		url:"./updateReport.do",
		data:"title="+title.value+"&content="+content.value+"&secretflag="+secretflag.value+"&report_num="+report_num,
		type:"post",
		async:true,
		success:function(msg){
			if(msg == 'true'){
				alert('수정이 완료되었습니다.');
			}else{
				alert('수정에 실패했습니다');
			}
		}
	});
}

