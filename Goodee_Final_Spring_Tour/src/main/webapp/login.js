window.onload = function(){
	document.getElementById('signUp').onclick =function(){
		location.href="./signupForm.do"
	}
}

function enterKey(){
	if(window.event.keycode == 13){
		loginCheck();
	}
}

function loginCheck(){
	console.log("로그인 실행");
	var id = document.getElementById("inputId");
	var pw = document.getElementById("inputPw");
	
	var frm = document.forms[0];
	frm.action ="./login.do";
	
	//유효성 검사 후 ajax 로그인
	if(id.value == "" || id.value.trim() ==""){
		swal("로그인","아이디를 입력해 주세요");
		id.value="";
		id.focus();
	}else if(pw.value==""||id.value.trim() ==""){
		swal("로그인","비밀번호를 입력해 주세요");
		pw.value="";
		pw.focus();
	}else{
		$.ajax({
			type:"post",
//			url:"./loginCheckText.do",
			url:"./loginCheckMap.do",
			data:"id="+id.value+"&pw="+pw.value,
			success:function(msg){
				if(msg.isc == '성공'){
					console.log(msg.isc);
					frm.submit();
				}else{
					swal("로그인","해당 사용자는 존재하지 않습니다")
				}
			},
			error:function(){
				swal("로그인","로그인에 문제가 있습니다");
			}			
		});
	}
	
	
}


