package com.tour.edu.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tour.edu.model.dao.IReportDao;
import com.tour.edu.vo.ReportVo;

@Service
public class ReportServiceImpl implements IReportService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IReportDao dao;
	
	@Override
	public int writeReport(ReportVo vo) {
		return dao.writeReport(vo);
	}

	@Override
	public List<ReportVo> selectAllReport() {
		return dao.selectAllReport();
	}

	@Override
	public ReportVo selectOneReport(int report_num) {
		return dao.selectOneReport(report_num);
	}

	@Override
	public int deleteReport(int report_num) {
		return dao.deleteReport(report_num);
	}

	@Override
	public int updateReport(ReportVo vo) {
		return dao.updateReport(vo);
	}

	@Override
	@Transactional
	public int answerReport(ReportVo vo) {
		logger.info("서비스의 AnswerReport 메소드 - 트랜잭션 처리");
		int m = dao.updateAnswerReport(vo);
		int n = dao.writeAnswerReport(vo);
		return m+n;
	}

	

}
