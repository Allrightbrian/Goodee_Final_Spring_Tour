package com.tour.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.PaymentsVo;


@Repository
public class PaymentsDaoImpl implements IPaymentsDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.tour.edu.model.dao.PaymentsDaoImpl.";
	
	@Override
	public int paymentInsert(Map<String, String> map) {
		logger.info("PaymentsDaoImpl 결제내역 등록 {}", map);
		return sqlSession.insert(NS+"paymentInsert", map);
	}

	@Override
	public List<PaymentsVo> paymentSelectAll() {
		logger.info("PaymentsDaoImpl 결제내역 전체조회");
		return sqlSession.selectList(NS+"paymentSelectAll");
	}

	@Override
	public List<PaymentsVo> paymentsSelectByName(String userid) {
		logger.info("PaymentsDaoImpl 결제내역 이름으로 조회 {}", userid);
		return sqlSession.selectList(NS+"paymentsSelectByName", userid);
	}
	
	@Override
	public List<PaymentsVo> paymentSelectAllByMember(String userid) {
		logger.info("PaymentsDaoImpl 사용자 결제내역 전체조회", userid);
		return sqlSession.selectList(NS+"paymentSelectAllByMember", userid);
	}

	@Override
	public PaymentsVo paymentSelectOne(int paycode) {
		logger.info("PaymentsDaoImpl 결제내역 상세 조회 {}", paycode);
		return sqlSession.selectOne(NS+"paymentSelectOne", paycode);
	}
	
	@Override
	public int paymentDelflag(int paycode) {
		logger.info("PaymentsDaoImpl 결제내역 상세 조회 {}", paycode);
		return sqlSession.update(NS+"paymentDelflag", paycode);
	}

	@Override
	public int paymentCancelYN(int paycode) {
		logger.info("PaymentsDaoImpl 결제내역 상세 조회 {}", paycode);
		return sqlSession.update(NS+"paymentCancelYN", paycode);
	}

	@Override
	public int paymentCancel(Map<String, String> map) {
		logger.info("PaymentsDaoImpl 결제취소 {}", map);
		return sqlSession.update(NS+"paymentCancel", map);
	}

	


}
