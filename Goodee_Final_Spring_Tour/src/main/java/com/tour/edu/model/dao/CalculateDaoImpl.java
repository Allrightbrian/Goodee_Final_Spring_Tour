package com.tour.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.CalculateVo;

@Repository
public class CalculateDaoImpl implements ICalculateDao {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	private final String NS="com.tour.edu.model.dao.CalculateDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CalculateVo> CalculateSelectAll() {
		logger.info("CalculateDaoImpl CalculateSelectAll 실행");
		return sqlSession.selectList(NS+"CalculateSelectAll");
	}

	@Override
	public List<CalculateVo> CalculateSelectResultCode(int resultCode) {
		logger.info("CalculateDaoImpl CalculateSelectResultCode 실행");
		return sqlSession.selectList(NS+"CalculateSelectResultCode",resultCode);
	}

	@Override
	public int CalculateInsert(CalculateVo vo) {
		logger.info("CalculateDaoImpl CalculateInsert 실행");
		return sqlSession.insert(NS+"CalculateInsert", vo);
	}

	@Override
	public int CalculateUpdate(CalculateVo vo) {
		logger.info("CalculateDaoImpl CalculateUpdate 실행");
		return sqlSession.update(NS+"CalculateUpdate", vo);
	}

	@Override
	public int CalculateCntUp(CalculateVo vo) {
		logger.info("CalculateDaoImpl CalculateCntUp 실행");
		return sqlSession.update(NS+"CalculateCntUp", vo);
	}

	@Override
	public int CalculateDelete(int resultCode) {
		logger.info("CalculateDaoImpl CalculateDelete 실행");
		return sqlSession.delete(NS+"CalculateDelete", resultCode);
	}

	
}
