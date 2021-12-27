package com.tour.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.edu.model.service.IReportService;
import com.tour.edu.vo.MemberVo;
import com.tour.edu.vo.ReportVo;

@Controller
public class ReportController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IReportService service;
	
	@RequestMapping(value = "/writeReportForm.do", method = RequestMethod.GET)
	public String writeReportForm() {
		logger.info("ReportController 클래스의 writeReportForm메소드 실행 : ");
		
		return "report/writeReportForm";
	}
	
	@RequestMapping(value="/writeReport.do", method=RequestMethod.POST)
	public String writeReport(ReportVo report, HttpSession session, String secretflag){
		logger.info("ReportController 클래스의 writeReport메소드 실행 : {}", report);
		MemberVo vo = (MemberVo)session.getAttribute("member");
		report.setUserid(vo.getId());
		logger.info("비밀글여부 : {}",report.getSecretflag());
		int n = service.writeReport(report);
		if(n ==1) {
			return "redirect:/selectAllReport.do";
		}
		return "";
	}
	
	@RequestMapping(value="/selectAllReport.do", method=RequestMethod.GET)
	public String selectAllReport(HttpServletRequest req) {
		logger.info("ReportController 클래스의 selectAllReport메소드 실행 : ");
		List<ReportVo> reportList = service.selectAllReport();
		req.setAttribute("reportList", reportList);
		return "report/reportList";
	}
	
	@RequestMapping(value="/selectOneReport.do", method=RequestMethod.GET)
	public String selectOneReport(int report_num, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
		logger.info("ReportController 클래스의 selectOneReport메소드 실행 : {}", report_num);
		ReportVo report = service.selectOneReport(report_num);
		MemberVo member = (MemberVo)session.getAttribute("member");
		ReportVo report2 = service.selectOneReport(report.getRefer());
		
		if (report.getSecretflag().equals("Y") && !member.getId().equals(report.getUserid()) && !member.getManager().equals("Y") && !report2.getUserid().equals(member.getId())) {
			resp.setContentType("text/html; charset=UTF-8;");
			PrintWriter writer = resp.getWriter();
			writer.println("<script>alert('비밀글은 작성자만 볼 수 있습니다.')</script>");
			writer.println("<script>history.back();</script>");
			writer.flush();
			writer.close();
			return null;
		}else {
			req.setAttribute("report", report);
			req.setAttribute("reportRef", report2);
			return "report/reportDetail";
		}
	}
	
	@RequestMapping(value="/deleteReport.do", method=RequestMethod.GET)
	public String deleteReport(int report_num) {
		logger.info("ReportController 클래스의 deleteReport메소드 실행 : {}",report_num);
		int n = service.deleteReport(report_num);
		
		if(n == 1) {
			return "redirect:/selectAllReport.do";
		}
		return "redirect:/main.do";
	}
	
	@RequestMapping(value="/updateReport.do", method=RequestMethod.POST)
	@ResponseBody
	public String updateReport(ReportVo vo) {
		logger.info("ReportController 클래스의 updateReport메소드 실행 : ");
		int n = service.updateReport(vo);
		logger.info("ReportController 클래스의 updateReport메소드 변수 n = {} ",n);
		if(n == 1) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping(value="/answerReport.do", method=RequestMethod.POST)
	public String answerReport(ReportVo vo, HttpSession session) {
		logger.info("ReportController 클래스의 answerReport메소드 실행 : {}", vo);
		MemberVo member = (MemberVo)session.getAttribute("member");
		vo.setUserid(member.getId());
		int n = service.answerReport(vo);
		logger.info("업데이트한 값 결과 : {}", n);
		if(n > 0) {
			return "redirect:/selectAllReport.do";
		}
		return "redirect:/main.do";
	}
	
	@RequestMapping(value="/answerReportForm.do", method=RequestMethod.GET)
	public String answerReportForm(int report_num, HttpServletRequest res) {
		logger.info("ReportController 클래스의 answerReportForm메소드 실행 : ");
		ReportVo report = service.selectOneReport(report_num);
		res.setAttribute("report", report);
		return "report/answerReportForm";
	}
}










