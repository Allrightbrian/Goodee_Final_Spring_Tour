package com.tour.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.edu.model.dao.ICalculateDao;
import com.tour.edu.vo.CalculateVo;

@Service
public class CalculateServiceImpl implements ICalculateService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ICalculateDao dao;
	
	@Override
	public List<CalculateVo> CalculateSelectAll() {
		logger.info("CalculateServiceImpl CalculateSelectAll실행");
		return dao.CalculateSelectAll();
	}

	@Override
	public List<CalculateVo> CalculateSelectResultCode(int resultCode) {
		logger.info("CalculateServiceImpl CalculateSelectResultCode실행");
		return dao.CalculateSelectResultCode(resultCode);
	}

	@Override
	public int CalculateInsert(CalculateVo vo) {
		logger.info("CalculateServiceImpl CalculateInsert실행");
		return dao.CalculateInsert(vo);
	}

	@Override
	public int CalculateUpdate(CalculateVo vo) {
		logger.info("CalculateServiceImpl CalculateUpdate실행");
		return dao.CalculateUpdate(vo);
	}

	@Override
	public int CalculateCntUp(CalculateVo vo) {
		logger.info("CalculateServiceImpl CalculateCntUp실행");
		return dao.CalculateCntUp(vo);
	}

	@Override
	public int CalculateDelete(int resultCode) {
		logger.info("CalculateServiceImpl CalculateDelete실행");
		return dao.CalculateDelete(resultCode);
	}
	
}
