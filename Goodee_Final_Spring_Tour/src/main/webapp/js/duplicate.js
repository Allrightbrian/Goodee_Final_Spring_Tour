/**
 * 
 */
function duplicateCheckId(){
	var idvalidate = /^[a-zA-Z][a-zA-Z0-9]{6,20}$/;
	var id = document.getElementsByName("id")[0];
	var checkid = document.getElementById("checkResultId");
	
	if(!idvalidate.test(id.value)){
		checkid.innerText = '아이디는 영문과 숫자 6~20글자 사이로만 가능합니다.';
		checkid.style.color = "red";
		id.focus();
		return false;
	}else{
		$.ajax({
			url : './duplicateCheckId.do',
			type :'post',
			data : "id="+id.value,
			async : true,
			success : function(msg){
				console.log(msg);
				if(msg == "false"){
					checkid.innerText = '사용 가능한 아이디입니다';
					checkid.style.color = 'green';
					document.getElementById('checkIdFlag').value=id.value;
				}else{
					checkid.innerText = '중복된 아이디입니다';
					checkid.style.color = 'red';
					document.getElementById('checkIdFlag').value='false';
				}
			}
		})
	}
}

function duplicateCheckNick(){
	var nick = document.getElementsByName("nickname")[0];
	var checknick = document.getElementById("checkResultNick");
	
	if(nick.value.trim() == ""){
		checknick.innerHTML = '닉네임을 입력해 주세요';
		checknick.style.color = "red";
		nick.focus();
		return false;
	}else{
		$.ajax({
			url : './duplicateCheckNick.do',
			type :'post',
			data : "nickname="+nick.value,
			async : true,
			success : function(msg){
				console.log(msg);
				if(msg == "false"){
					checknick.innerText = '사용 가능한 닉네임입니다';
					checknick.style.color = 'green';
					document.getElementById('checkNickFlag').value=nick.value.trim();
				}else{
					checknick.innerText = '중복된 닉네임입니다';
					checknick.style.color = 'red';
					document.getElementById('checkNickFlag').value='false';
				}
			}
		})
	}
}
