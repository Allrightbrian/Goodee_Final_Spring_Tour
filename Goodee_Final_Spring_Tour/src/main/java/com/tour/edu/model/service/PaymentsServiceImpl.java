package com.tour.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.edu.model.dao.IPaymentsDao;
import com.tour.edu.vo.PaymentsVo;


@Service
public class PaymentsServiceImpl implements IPaymentsService{

	@Autowired
	private IPaymentsDao dao;
	
	@Override
	public int paymentInsert(Map<String, String> map) {
		return dao.paymentInsert(map);
	}

	@Override
	public List<PaymentsVo> paymentSelectAll() {
		return dao.paymentSelectAll();
	}

	@Override
	public List<PaymentsVo> paymentsSelectByName(String userid) {
		return dao.paymentsSelectByName(userid);
	}
	
	@Override
	public List<PaymentsVo> paymentSelectAllByMember(String userid) {
		return dao.paymentSelectAllByMember(userid);
	}
	
	@Override
	public PaymentsVo paymentSelectOne(int paycode) {
		return dao.paymentSelectOne(paycode);
	}

	@Override
	public int paymentDelflag(int paycode) {
		return dao.paymentDelflag(paycode);
	}

	@Override
	public int paymentCancelYN(int paycode) {
		return dao.paymentCancelYN(paycode);
	}

	@Override
	public int paymentCancel(Map<String, String> map) {
		return dao.paymentCancel(map);
	}

	



}
