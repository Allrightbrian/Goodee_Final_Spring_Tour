package com.tour.edu.model.dao;

import java.util.List;

import com.tour.edu.vo.ReportVo;

public interface IReportDao {
	public int writeReport(ReportVo vo);
	public List<ReportVo> selectAllReport();
	public ReportVo selectOneReport(int report_num);
	public int deleteReport(int report_num);
	public int updateReport(ReportVo vo);
	public int updateAnswerReport(ReportVo vo);
	public int writeAnswerReport(ReportVo vo);
}
