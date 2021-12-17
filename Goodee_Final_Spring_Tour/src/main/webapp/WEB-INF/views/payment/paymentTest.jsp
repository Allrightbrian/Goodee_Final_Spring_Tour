<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script type="text/javascript">

/* var IMP = window.IMP; // 생략 가능
IMP.init("{가맹점 식별코드}"); // 예: imp00000000 //html5_inicis */

	function request_pay(){
	//가맹점 식별코드
	IMP.init('imp51549826');
	IMP.request_pay({
	    pg : 'html5_inicis',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '${productName}' , //결제창에서 보여질 이름
	    amount : '${price}', //실제 결제되는 가격
	    buyer_email : '${userEmail}',
	    buyer_name : '${userName}',
	    buyer_tel : '${userTel}',
	    /* buyer_addr : '서울 강남구 도곡동',
	    buyer_postcode : '123-456' */
	}, function(rsp) {
		console.log(rsp);
	  	if ( rsp.success ) {
	    	var msg = '결제가 완료되었습니다.';
	        msg += '고유ID : ' + rsp.imp_uid;
	        msg += '상점 거래ID : ' + rsp.merchant_uid;
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num;
	        /* 결제검증 */
	        var sendData = {"imp_uid":rsp.imp_uid, "pg":rsp.pg_provider, "pay_method":rsp.pay_method,
	        				"card_name":rsp.card_name, "price":rsp.paid_amount}
	        $.ajax({
	        	url : "./paymentInsert.do" ,
	        	type : "POST",
	        	data: JSON.stringify(sendData),
	        	contentType : 'application/json; charset=UTF-8',
	            dataType : 'json'
	        }).done(function(data) {
	        	
	        	console.log(data);
	        	
	        	// 위의 rsp.paid_amount 와 data.response.amount를 비교한후 로직 실행 (import 서버검증)
	        	if(rsp.paid_amount == data.response.amount){
	        		console.log(rsp.paid_amount);
	        		console.log(data.response.amount);
		        	alert("결제 및 결제검증완료");
	        	} else {
	        		alert("결제 실패 : 위조된 결제시도");
	        	}
	        }); 
	    } else {
	    	 var msg = '결제에 실패하였습니다.';
	         msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg);
	});
}
</script>
<script type="text/javascript">
  function cancelPay() {
	$.ajax({
      url: './cancelPay.do',
      type: 'GET',
      contentType: 'application/json',
      data: {
    	imp_uid: 'imp_684875265630',
        cancel_request_amount: 100, // 환불금액
        reason: "테스트 결제 환불" // 환불사유
        /* "refund_holder": "홍길동", // [가상계좌 환불시 필수입력] 환불 수령계좌 예금주
        "refund_bank": "88" // [가상계좌 환불시 필수입력] 환불 수령계좌 은행코드(예: KG이니시스의 경우 신한은행은 88번)
        "refund_account": "56211105948400" // [가상계좌 환불시 필수입력] 환불 수령계좌 번호 */
      },
      dataType: "json"
    }).done(function(data) {
    	if(data.message != null){
    		console.log(data.message);
    		alert("취소요청 실패 : " + data.message)
    	}else{
    		alert("취소완료");
    	}
    
    }); 
  }
</script>
</head>
<body>
	<h2>테스트페이지</h2>
	<button onclick="request_pay()">결제</button>
	<button onclick="cancelPay()">환불하기</button>
	<button onclick="location.href='./productList.do'">상품 전체 보기</button>
	<button onclick="location.href='./paymentList.do'">결제내역 전체 보기</button>
	
</body>


</html>