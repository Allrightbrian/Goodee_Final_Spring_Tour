package com.tour.edu.vo;

import java.io.Serializable;

public class ReportVo implements Serializable{

	private static final long serialVersionUID = 7273857783200895831L;
	
	private int report_num;
	private String title;
	private String content;
	private int refer;
	private int step;
	private int depth;
	private String delflag;
	private String regdate;
	private String secretflag;
	private String userid;
	
	public int getReport_num() {
		return report_num;
	}
	public void setReport_num(int report_num) {
		this.report_num = report_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRefer() {
		return refer;
	}
	public void setRefer(int refer) {
		this.refer = refer;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getSecretflag() {
		return secretflag;
	}
	public void setSecretflag(String secretflag) {
		this.secretflag = secretflag;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public ReportVo(int report_num, String title, String content, int refer, int step, int depth, String delflag,
			String regdate, String secretflag, String userid) {
		super();
		this.report_num = report_num;
		this.title = title;
		this.content = content;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.delflag = delflag;
		this.regdate = regdate;
		this.secretflag = secretflag;
		this.userid = userid;
	}
	public ReportVo() {
		super();
	}
	@Override
	public String toString() {
		return "ReportVo [report_num=" + report_num + ", title=" + title + ", content=" + content + ", refer=" + refer
				+ ", step=" + step + ", depth=" + depth + ", delflag=" + delflag + ", regdate=" + regdate
				+ ", secretflag=" + secretflag + ", userid=" + userid + "]";
	}
	
	
	
}
