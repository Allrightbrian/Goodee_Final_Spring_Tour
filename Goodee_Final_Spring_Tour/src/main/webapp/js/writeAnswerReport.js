window.onload = function(){
	var secretflag = document.getElementsByName("secretflag")[0];
	var checkbox = document.getElementById("secretflag");
	
	if(secretflag != null && secretflag.value=="Y"){
		checkbox.checked = true;
	}
}

function answerReport(){
	var title = document.getElementsByName("title")[0];
	var content = document.getElementsByName("content")[0];
	if(content.value.trim()==""){
		alert('내용을 모두 입력해 주셔야 합니다!!');
		return false;
	}
	var contval = content.value;
	contval = contval.replace(/\r\n|\r|\n|\n\r/g, '<br>');
	contval = contval.replace(/</g,'&lt;');
	contval = contval.replace(/>/g,'&gt;');
	content.textContent = contval;
	return true;
	
}

