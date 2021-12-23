/**
 * 
 */

/*
 * 가입에 필요한 정보 전부 입력했는지 유효성검사
 */
function infoCheck(){
	var idvalidate = /^[a-zA-Z][a-zA-Z0-9]{6,20}$/;
	var pwvalidate = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/; //수정필요함.
	var phonevalidate = /^[0-9]{3,4}$/
	var phonevalidate2 = /^[0-9]{4}$/
	var emailvalidate = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	var id = document.getElementsByName("id");
	var pw = document.getElementsByName("password");
	var pwCheck = document.getElementsByName("passwordCheck");
	var name = document.getElementsByName("name");
	var nick = document.getElementsByName("nickname");
	var phone = document.getElementsByName("phone");
	var phone1 = document.getElementsByName("phone1");
	var phone2 = document.getElementsByName("phone2");
	var phone3 = document.getElementsByName("phone3");
	var email = document.getElementsByName("email");
	
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
	
	if(pw[0].value != pwCheck[0].value){
		alert('입력하신 비밀번호와 비밀번호 확인이 일치하지 않습니다.');
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
		alert('아이디를 확인해주세요');
		id[0].focus();
		return false;
	}
	
	if(nick[0].value != document.getElementById('checkNickFlag').value){
		alert('닉네임 중복확인을 해주세요');
		nick[0].focus();
		return false;
	}
	
	if(!emailvalidate.test(email[0].value)){
		alert('올바른 이메일 형식을 입력해 주세요');
		email[0].focus();
		return false;
	}
	
	phone[0].value = phone1[0].value + phone2[0].value + phone3[0].value;
}

/*
 * 아이디 중복 체크
 */
function duplicateCheckId(){
	var idvalidate = /^[a-zA-Z][a-zA-Z0-9]{5,20}$/;
	var id = document.getElementsByName("id")[0];
	var checkid = document.getElementById("checkResultId");
	
	if(!idvalidate.test(id.value)){
		checkid.innerText = '아이디는 영문과 숫자 6~20글자 사이로만 가능합니다.';
		checkid.style.color = "red";
		document.getElementById('checkIdFlag').value='false';
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
					document.getElementById('checkIdFlag').value='true';
				}else{
					checkid.innerText = '중복된 아이디입니다';
					checkid.style.color = 'red';
					document.getElementById('checkIdFlag').value='false';
				}
			}
		})
	}
}

/*
 * 닉네임 중복 체크
 */
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

/*
 * 회원정보 수정 시 입력 내용 유효성 검사
 */
function memberModifyCheck(a){
	console.log(a);
	var pwvalidate = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;
	var phonevalidate = /^[0-9]{1,11}$/
	var emailvalidate = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	var id = document.getElementsByName("id");
	if(a == 'N'){
		var pw = document.getElementsByName("password");
		var pwCheck = document.getElementsByName("passwordCheck");
	}
	var name = document.getElementsByName("name");
	var nick = document.getElementsByName("nickname");
	var phone = document.getElementsByName("phone");
	var email = document.getElementsByName("email");
	if(a == 'N'){
		if(pw[0].value != ""){
			if(!pwvalidate.test(pw[0].value)){
				alert('비밀번호는 영문 대/소문자와 숫자, 특수문자 조합으로 8~20글자 사이만 가능합니다.');
				pw[0].focus();
				return false;
			}else if(pw[0].value != pwCheck[0].value){
				alert('입력하신 비밀번호와 비밀번호 확인이 일치하지 않습니다.');
				pw[0].focus();
				return false;
			}
		}
	}
	if(nick[0].value != document.getElementById('checkNickFlag').value){
		alert('닉네임 중복확인을 해주세요'+nick[0].value+'   '+document.getElementById('checkNickFlag').value);
		nick[0].focus();
		return false;
	}else if(name[0].value == ""){
		alert('이름을 입력해 주세요');
		name[0].focus();
		return false;
	}else if(!phonevalidate.test(phone[0].value)){
		alert('올바른 휴대폰 번호를 넣어주세요');
		phone[0].focus();
		return false;
	}else if(!emailvalidate.test(email[0].value)){
		alert('올바른 이메일 형식을 입력해 주세요');
		email[0].focus();
		return false;
	}else{
		if(a=='N'){
			$.ajax({
				url:"./modifyMemberInfo.do",
				type:"post",
				data:"id="+id[0].value+"&pw="+pw[0].value+"&name="+name[0].value+"&nickname="+nick[0].value+"&phone="+phone[0].value+"&email="+email[0].value,
				async:true,
				success:function(msg){
					//console.log(msg);
					if(msg == "성공"){
						//console.log('수정완료');
						alert('수정 완료되었습니다.');
					}else{
						//console.log('에러');
						alert('에러발생');
					}
				}
			})
		}else if(a=='Y'){
			$.ajax({
				url:"./modifyMemberInfo.do",
				type:"post",
				data:"id="+id[0].value+"&name="+name[0].value+"&nickname="+nick[0].value+"&phone="+phone[0].value+"&email="+email[0].value,
				async:true,
				success:function(msg){
					//console.log(msg);
					if(msg == "성공"){
						//console.log('수정완료');
						alert('수정 완료되었습니다.');
					}else{
						//console.log('에러');
						alert('에러발생');
					}
				}
			})
		}
	}
	
}

/*
 * 아이디 찾기
 */
function findId(id){
	var name = document.getElementsByName("name")[0];
	var phone = document.getElementsByName("phone")[0];
	$.ajax({
		url:"./findId.do",
		type:"post",
		data:"name="+name.value+"&phone="+phone.value,
		async:true,
		success:function(resultId){
			if(resultId !="" && resultId != null){
				var result = document.getElementById("resultId");
				result.style.display="block";
				result.style.color="red";
				document.getElementById("ajaxresult").innerHTML="고객님의 ID는 "+resultId+"입니다.";
			}else{
				alert('입력하신 정보로 가입된 ID가 없습니다');
			}
		}
		
	});
}






















