package com.tour.edu.ctrl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.tour.edu.model.service.IPaymentsService;
import com.tour.edu.model.service.IProductsService;
import com.tour.edu.vo.MemberVo;
import com.tour.edu.vo.PaymentsVo;
import com.tour.edu.vo.ProductsVo;

@Controller
public class PaymentCtrl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String apiKey = "6833076151848562";
	private final String apisecret = "8cb171ad19502807f44c2224bb7043e04bbf3de216913e05207c936292513f0ad798b4707825784c";
	
	@Autowired
	private IPaymentsService service;
	
	@Autowired
	private IProductsService productsService;
	
	private IamportClient client;
	public PaymentCtrl() {
		client = new IamportClient(apiKey, apisecret);
	}
	
	@GetMapping(value = "/paymentList.do")
	public String PaymentList(Model model, HttpSession session) {
		logger.info("PaymentCtrl PaymentList 호출");
		
		MemberVo vo = (MemberVo)session.getAttribute("member");
		
		if(vo.getManager().equals("Y")) {
			List<PaymentsVo> paymentList = service.paymentSelectAll();
			model.addAttribute("paymentList", paymentList);
			
			return "payment/paymentList";
		}else {
			List<PaymentsVo> paymentList = service.paymentSelectAllByMember(vo.getId());
			model.addAttribute("paymentList", paymentList);
			return "payment/paymentList";
		}
	}
	
	/**
	 * 결제 요청은 클라이언트 상에서 이루어지기 때문에 클라이언트의 스크립트를 조작해 금액을 위변조하여 결제를 요청할 수 있습니다. 
	 * 따라서 결제 프로세스 완료 후 처음 요청했던 금액과 실제로 결제된 금액을 비교하여 일치하지 않을 경우 결제 취소시키는 로직을 구현
	 * @param imp_uid: client-side에서 넘겨받은 imp_uid
	 * @param paid_amount: client-side에서 넘겨받은 paid_amount
	 */
	
	@ResponseBody
	@RequestMapping(value="/paymentInsert.do", method = RequestMethod.POST)
	public IamportResponse<Payment> paymentInsert(Model model, HttpSession session, @RequestBody Map<String,String> map, HttpServletResponse resp) throws IamportResponseException, IOException{	
			logger.info("paymentByImpUid 실행");
//			System.out.println(map);
			String imp_uid = map.get("imp_uid");
//			System.out.println("imp_uid 확인 :" + imp_uid);
			String iamportServerAmount = client.paymentByImpUid(imp_uid).getResponse().getAmount().toString();
//			System.out.println("iamportServerAmount: " + iamportServerAmount);
			//imp_uid로 아임포트 서버에서 조회하여 data를 반환시킴 // 결제금액이 일치하지 않을경우 결제 취소됨
			String paidAmount = map.get("price");
//			String paidAmount = "300"; //testcode
//			System.out.println("paidAmount : " + paidAmount);
			System.out.println(map+"check");
			if(paidAmount.equals(iamportServerAmount)) {
				System.out.println("인증성공");
				//상품명으로 상품 코드 호출
				ProductsVo vo = productsService.productSelectOneByName(map.get("name"));
				//세션에 map으로 올려놓은 memberId 호출
				@SuppressWarnings("unchecked")
				Map<String, String> memberInfo = (Map<String, String>) session.getAttribute("memberInfo");
				String userid = memberInfo.get("memberId");
				String product_code = Integer.toString(vo.getProduct_code());
				//상품코드, userid map에 추가
				map.put("product_code", product_code);
				map.put("userid", userid);
				System.out.println(map+"check");
				service.paymentInsert(map);
				//검증 추가할 방법 생각해보기
			}else {
				System.out.println("인증실패");
				CancelData cancel_data = new CancelData(imp_uid, true); //imp_uid를 통한 전액취소
				client.cancelPaymentByImpUid(cancel_data);
				//위변조 시도된 경우 세션 삭제 추가 // 별도의 페이지라 세션 공유가 안됨 따라서 logout.do를 호출하여 세션 삭제
				
			}
			return client.paymentByImpUid(imp_uid);
	}
	// 화면처리 및 로직 수정 필요
	@ResponseBody
	@RequestMapping(value="/cancelPay.do", method = RequestMethod.GET)
	public IamportResponse<Payment> cancelByImpUid(Model model, HttpSession session, String imp_uid, String cancel_request_amount, String reason, String paycode) throws IamportResponseException, IOException{	
		System.out.println("호출됨");
		System.out.println(reason);
		System.out.println(imp_uid);
		System.out.println(client.paymentByImpUid(imp_uid).getResponse().getImpUid());
		
		int client_cancel_request_amount = Integer.parseInt(cancel_request_amount);
		int paycode2 = Integer.parseInt(paycode);
		CancelData cancel_data = new CancelData(imp_uid, true);
		//서버와 아임포트 서버간에 환불 가능 금액을 검증 (부분 취소할때 사용하면 좋을듯)
		cancel_data.setChecksum(BigDecimal.valueOf(client_cancel_request_amount));
		Map<String, String> cancelMap = new HashMap<String, String>();
		cancelMap.put("cancel_desc", reason);
		cancelMap.put("paycode", paycode);
		cancelMap.put("imp_uid", imp_uid);
		
		service.paymentCancel(cancelMap);
		return client.cancelPaymentByImpUid(cancel_data);
	}
	
}
