package com.tour.edu.model.service;

import java.util.List;
import java.util.Map;

import com.tour.edu.vo.PaymentsVo;


public interface IPaymentsService {

	// 결제내역 등록
	public int paymentInsert(Map<String, String> map);

	// 결제내역 전체 조회 (관리자)
	public List<PaymentsVo> paymentSelectAll();

	// 결제내역 이름으로 조회(관리자) / 전체내역 조회(사용자)
	public List<PaymentsVo> paymentsSelectByName(String userid);

	// 결제 전체내역 조회(사용자)
	public List<PaymentsVo> paymentSelectAllByMember(String userid);

	// 결제내역 상세조회
	public PaymentsVo paymentSelectOne(int paycode);

	// 결제내역 삭제(delflag)(관리자)
	public int paymentDelflag(int paycode);

	// 결제내역 수정(결제 취소 불가로 변경)(관리자)
	public int paymentCancelYN(int paycode);

	// 결제 취소
	public int paymentCancel(Map<String, String> map);
}
