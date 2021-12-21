package com.tour.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.edu.model.dao.IEstimateDao;
import com.tour.edu.vo.EstimateVo;

@Service
public class EstimateServiceImpl implements IEstimateService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IEstimateDao dao;
	
	@Override
	public List<EstimateVo> EstimateSelectUserId(String userId) {
		logger.info("EstimateServiceImpl EstimateServiceImpl실행");
		return dao.EstimateSelectUserId(userId);
	}

	@Override
	public int EstimateInsert(EstimateVo vo) {
		logger.info("EstimateServiceImpl EstimateInsert실행");
		return dao.EstimateInsert(vo);
	}

	@Override
	public int EstimateUpdate(EstimateVo vo) {
		logger.info("EstimateServiceImpl EstimateUpdate실행");
		return dao.EstimateUpdate(vo);
	}

	@Override
	public int EstimateDelete(int offerCode) {
		logger.info("EstimateServiceImpl EstimateDelete실행");
		return dao.EstimateDelete(offerCode);
	}

}
