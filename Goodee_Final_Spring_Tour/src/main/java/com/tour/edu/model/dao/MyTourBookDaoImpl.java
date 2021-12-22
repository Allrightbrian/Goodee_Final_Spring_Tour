package com.tour.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tour.edu.vo.MyTourBookVo;

@Repository
public class MyTourBookDaoImpl implements IMyTourBookDao {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	private final String NS="com.tour.edu.model.dao.MyTourBookDaoImpl.";
	private final String NS2="com.tour.edu.model.dao.MyTourDataDaoImpl.";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MyTourBookVo> MyTourSelectAll() {
		logger.info("MyTourBookDaoImpl MyTourSelectAll 실행");
		return sqlSession.selectList(NS+"MyTourBookSelectAll");
	}

	@Override
	public List<MyTourBookVo> MyTourBookSelectNo(int bookNo) {
		logger.info("MyTourBookDaoImpl MyTourBookSelectNo 실행");
		return sqlSession.selectList(NS+"MyTourBookSelectNo", bookNo);
	}

	@Override
	public List<MyTourBookVo> MyTourBookSelectTitle(String title) {
		logger.info("MyTourBookDaoImpl MyTourBookSelectTitle 실행");
		return sqlSession.selectList(NS+"MyTourBookSelectTitle", title);
	}

	@Override
	public List<MyTourBookVo> MyTourBookSelectRegdate(String regdate) {
		logger.info("MyTourBookDaoImpl MyTourBookSelectRegdate 실행");
		return sqlSession.selectList(NS+"MyTourBookSelectRegdate", regdate);
	}

	@Override
	public int MyTourBookInsert(MyTourBookVo myTourBookvo) {
		logger.info("MyTourBookDaoImpl MyTourBookInsert 실행");
		return sqlSession.insert(NS+"MyTourBookInsert", myTourBookvo);
	}

	@Override
	public int MyTourBookUpdate(MyTourBookVo myTourBookvo) {
		logger.info("MyTourBookDaoImpl MyTourBookUpdate 실행");
		return sqlSession.update(NS+"MyTourBookUpdate", myTourBookvo);
	}
	
	@Transactional
	@Override
	public int MyTourBookDelflag(int bookNo) {
		logger.info("MyTourBookDaoImpl MyTourBookDelflag 실행");
		int n=sqlSession.update(NS+"MyTourBookDelflag", bookNo);
		int m=sqlSession.delete(NS2+"MyTourBookDelete", bookNo);
		return n+m;
	}
	
	@Transactional
	@Override
	public int MyTourBookDelete(int bookNo) {
		logger.info("MyTourBookDaoImpl MyTourBookDelete 실행");
		int n=sqlSession.update(NS+"MyTourBookDelete", bookNo);
		int m=sqlSession.delete(NS2+"MyTourBookDelete", bookNo);
		return  n+m;
	}
	
}
