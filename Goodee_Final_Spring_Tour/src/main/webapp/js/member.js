/**
 * 
 */

function infoCheck(){
	var idvalidate = /^[a-zA-Z][a-zA-Z0-9]{6,20}$/;
	var pwvalidate = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/; //수정필요함.
	var phonevalidate = /^[0-9]{3,4}$/
	var phonevalidate2 = /^[0-9]{4}$/
	
	var id = document.getElementsByName("id");
	var pw = document.getElementsByName("password");
	var name = document.getElementsByName("name");
	var nick = document.getElementsByName("nickname");
	var phone = document.getElementsByName("phone");
	var phone1 = document.getElementsByName("phone1");
	var phone2 = document.getElementsByName("phone2");
	var phone3 = document.getElementsByName("phone3");
	
	if(!idvalidate.test(id[0].value)){
		alert('아이디는 영문과 숫자 6~20글자 사이로만 가능합니다.');
		id[0].focus();
		return false;
	}
	
	if(!pwvalidate.test(pw[0].value)){
		alert('비밀번호는 영문 대/소문자와 숫자, 특수문자 조합으로 8~20글자 사이만 가능합니다.');
		pw[0].focus();
		return false;
	}
	if(name[0].value == ""){
		alert('이름을 입력해 주세요');
		name[0].focus();
		return false;
	}
	
	if(nick[0].value == ""){
		alert('닉네임을 입력해 주세요');
		nick[0].focus();
		return false;
	}
	
	if(!phonevalidate.test(phone2[0].value) || !phonevalidate2.test(phone3[0].value)){
		alert('핸드폰 번호를 올바른 형식으로 적어주세요');
		phone2[0].focus();
		return false;
	}
	
	if(id[0].value != document.getElementById('checkIdFlag').value){
		alert('아이디 중복확인을 해주세요');
		id[0].focus();
		return false;
	}
	
	if(nick[0].value != document.getElementById('checkNickFlag').value){
		alert('닉네임 중복확인을 해주세요'+nick[0].value+'   '+document.getElementById('checkNickFlag').value);
		nick[0].focus();
		return false;
	}
	phone[0].value = phone1[0].value + phone2[0].value + phone3[0].value;
}

