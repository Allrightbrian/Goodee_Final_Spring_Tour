package com.tour.edu.vo;

public class MyTourBookVo {
	
	private int bookNo;
	private String title;
	private String aurthor;
	private String regdate;
	private String keyword;
	private String delflag;
	public MyTourBookVo(int bookNo, String title, String aurthor, String regdate, String keyword, String delflag) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.aurthor = aurthor;
		this.regdate = regdate;
		this.keyword = keyword;
		this.delflag = delflag;
	}
	public MyTourBookVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MyTourBookVo [bookNo=" + bookNo + ", title=" + title + ", aurthor=" + aurthor + ", regdate=" + regdate
				+ ", keyword=" + keyword + ", delflag=" + delflag + "]";
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAurthor() {
		return aurthor;
	}
	public void setAurthor(String aurthor) {
		this.aurthor = aurthor;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	
	
	
}
