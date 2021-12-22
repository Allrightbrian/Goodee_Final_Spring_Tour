package com.tour.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.MyTourDataVo;

@Repository
public class MyTourDataDaoImpl implements IMyTourDataDao {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	private final String NS="com.tour.edu.model.dao.MyTourDataDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MyTourDataVo> MyTourDataAll() {
		logger.info("MyTourDataDaoImpl MyTourDataAll 실행 list: {}", sqlSession.selectList(NS+"MyTourDataAll"));
		return sqlSession.selectList(NS+"MyTourDataAll");
	}

	@Override
	public int MyTourDataInsert(MyTourDataVo vo) {
		logger.info("MyTourDataDaoImpl MyTourDataInsert 실행 MyTourDataVo: {}", vo);
		return sqlSession.insert(NS+"MyTourDataInsert", vo);
	}

	@Override
	public int MyTourDataDeleteDataNo(int dataNo) {
		logger.info("MyTourDataDaoImpl MyTourDataDeleteDataNo 실행 dataNo: {}", dataNo);
		return sqlSession.delete(NS+"MyTourDataDeleteDataNo", dataNo);
	}

	@Override
	public int MyTourDataDeleteBookNo(int bookNo) {
		logger.info("MyTourDataDaoImpl MyTourDataDeleteBookNo 실행 bookNo: {}",bookNo);
		return sqlSession.delete(NS+"MyTourDataDeleteBookNo", bookNo);
	}

	@Override
	public int MyTourDataUpdate(MyTourDataVo vo) {
		logger.info("MyTourDataDaoImpl MyTourDataUpdate 실행 MyTourDataVo: {}",vo);
		return sqlSession.delete(NS+"MyTourDataUpdate", vo);
	}

	@Override
	public List<MyTourDataVo> MyTourDataBookNo(int bookNo) {
		logger.info("MyTourDataDaoImpl MyTourDataBookNo 실행 MyTourDataVo: {}", bookNo);
		List<MyTourDataVo> lists=sqlSession.selectList(NS+"MyTourDataBookNo", bookNo);
		return lists;
	}

	@Override
	public int MyTourDataTourOrderUpdate(MyTourDataVo vo) {
		logger.info("MyTourDataDaoImpl MyTourDataBookNo 실행 MyTourDataVo: {}", vo);
		
		return sqlSession.update(NS+"MyTourDataTourOrderUpdate", vo);
	}

}
