package com.tour.edu.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tour.edu.vo.ReportVo;

@Repository
public class ReportDaoImpl implements IReportDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate session;
	private final String NS = "com.tour.edu.model.dao.ReportDaoImpl.";
	
	@Override
	public int writeReport(ReportVo vo) {
		logger.info("ReportDaoImpl 클래스의 writeReport 메소드 {}",vo);
		return session.insert(NS+"writeReport", vo);
	}

	@Override
	public List<ReportVo> selectAllReport() {
		logger.info("ReportDaoImpl 클래스의 selectAllReport 메소드 {}");
		List<ReportVo> voList = session.selectList(NS+"selectAllReport");
		return voList;
	}

	@Override
	public ReportVo selectOneReport(int report_num) {
		logger.info("ReportDaoImpl 클래스의 selectOneReport 메소드 {}",report_num);
		ReportVo vo = session.selectOne(NS+"selectOneReport", report_num);
		return vo;
	}

	@Override
	public int deleteReport(int report_num) {
		logger.info("ReportDaoImpl 클래스의 deleteReport 메소드 {}",report_num);
		return session.update(NS+"deleteReport", report_num);
	}

	@Override
	public int updateReport(ReportVo vo) {
		logger.info("ReportDaoImpl 클래스의 updateReport 메소드 {}",vo);
		return session.update(NS+"updateReport", vo);
	}

	@Override
	public int updateAnswerReport(ReportVo vo) {
		logger.info("ReportDaoImpl 클래스의 updateAnswerReport 메소드 {}",vo);
		return session.update(NS+"updateAnswerReport", vo);
	}

	@Override
	public int writeAnswerReport(ReportVo vo) {
		logger.info("ReportDaoImpl 클래스의 writeAnswerReport 메소드 {}",vo);
		return session.update(NS+"writeAnswerReport", vo);
	}

}
