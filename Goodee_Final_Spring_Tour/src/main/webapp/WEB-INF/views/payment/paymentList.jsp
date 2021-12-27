<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제내역 전체조회</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>

<%@ include file="../common/topMenu.jsp" %>
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>결제코드</th>
					<th>결제상태</th>
					<th>상품명</th>
					<th>금액</th>
					<th>유저아이디</th>
					<th>결제시간</th>
					<th>  </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="payment" items="${requestScope.paymentList}" varStatus="vs">
					<tr>
						<td>
							<input id="code${vs.index}" hidden="hidden" value="${payment.paycode}">
							<input id="imp${vs.index}" hidden="hidden" value="${payment.imp_uid}">
							${payment.imp_uid}
							
						</td>
						<td>${payment.pay_state}</td>
						<td>${payment.product_code}</td>
						<td>${payment.price}</td>
						<td>${payment.userid}</td>
						<td>${payment.pay_date}</td>
						
						<c:choose>  
							<c:when test="${payment.pay_state eq 'paid' and payment.cancelyn eq 'Y'}"> 
								<td><button onclick="cancelPay(imp${vs.index}, code${vs.index})">환불하기</button></td>
							</c:when> 
							<c:when test="${payment.pay_state eq 'CANCEL'}"> 
								<td>취소완료</td>
							</c:when> 
							<c:otherwise> 
								<td>취소불가</td>
							</c:otherwise> 
						</c:choose> 
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
	</div>

</body>
<script type="text/javascript">
  function cancelPay(imp, code) {
	var cancleRquest = imp.value;
	var codeValue = code.value;
	console.log(cancleRquest);
	$.ajax({
      url: './cancelPay.do',
      type: 'GET',
      contentType: 'application/json; charset=UTF-8',
      data: {
    	imp_uid: cancleRquest,
        cancel_request_amount: 100, // 환불금액
        reason: "테스트 결제 환불", // 환불사유
        paycode: codeValue
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
</html>