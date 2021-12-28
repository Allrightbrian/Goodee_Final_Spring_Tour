/*
$로 받아와야할 값들을 받아오지 못해 따로 빼주는거 보류
방법을 찾아볼것
*/

function request_pay() {
	//가맹점 식별코드
	IMP.init('imp51549826');
	IMP.request_pay({
		pg: 'html5_inicis',
		pay_method: 'card',
		merchant_uid: 'merchant_' + new Date().getTime(),
		name: '${productInfo.name}', //결제창에서 보여질 이름
		amount: '${productInfo.price}', //실제 결제되는 가격
		buyer_email: '${sessionScope.member.email}',
		buyer_name: '${sessionScope.member.name}',
		buyer_tel: '${sessionScope.member.phone}',
		/* buyer_addr : '서울 강남구 도곡동',
		buyer_postcode : '123-456' */
	}, function(rsp) {
		console.log(rsp);
		if (rsp.success) {
			var msg = '결제가 완료되었습니다.';
			msg += '고유ID : ' + rsp.imp_uid;
			msg += '상점 거래ID : ' + rsp.merchant_uid;
			msg += '결제 금액 : ' + rsp.paid_amount;
			msg += '카드 승인번호 : ' + rsp.apply_num;
			/* 결제검증 */
			var sendData = {
				"imp_uid": rsp.imp_uid, "pg": rsp.pg_provider, "pay_method": rsp.pay_method,
				"card_name": rsp.card_name, "price": rsp.paid_amount
			}
			$.ajax({
				url: "./paymentInsert.do",
				type: "POST",
				data: JSON.stringify(sendData),
				contentType: 'application/json; charset=UTF-8',
				dataType: 'json'
			}).done(function(data) {

				console.log(data);

				// 위의 rsp.paid_amount 와 data.response.amount를 비교한후 로직 실행 (import 서버검증)
				if (rsp.paid_amount == data.response.amount) {
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
