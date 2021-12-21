package com.tour.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.EstimateVo;

@Repository
public class EstimateDaoImpl implements IEstimateDao {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	private final String NS="com.tour.edu.model.dao.EstimateDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<EstimateVo> EstimateSelectUserId(String userId) {
		logger.info("EstimateDaoImpl EstimateSelectUserId");
		return sqlSession.selectList(NS+"EstimateSelectUserId", userId);
	}

	@Override
	public int EstimateInsert(EstimateVo vo) {
		logger.info("EstimateDaoImpl EstimateInsert");
		return sqlSession.insert(NS+"EstimateInsert", vo);
	}

	@Override
	public int EstimateUpdate(EstimateVo vo) {
		logger.info("EstimateDaoImpl EstimateUpdate");
		return sqlSession.update(NS+"EstimateUpdate", vo);
	}

	@Override
	public int EstimateDelete(int offerCode) {
		logger.info("EstimateDaoImpl EstimateDelete");
		return sqlSession.delete(NS+"EstimateDelete", offerCode);
	}

}
