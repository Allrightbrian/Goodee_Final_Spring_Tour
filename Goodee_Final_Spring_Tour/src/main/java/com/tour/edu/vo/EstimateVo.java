package com.tour.edu.vo;

public class EstimateVo {
	//견적서
	private int offerCode;
	private int areaCode;
	private int sigunguCode;
	private String title;
	private String content;
	private int numOfAttr;
	private String userId;
	public int getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(int offerCode) {
		this.offerCode = offerCode;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public int getSigunguCode() {
		return sigunguCode;
	}
	public void setSigunguCode(int sigunguCode) {
		this.sigunguCode = sigunguCode;
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
	public int getNumOfAttr() {
		return numOfAttr;
	}
	public void setNumOfAttr(int numOfAttr) {
		this.numOfAttr = numOfAttr;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "EstimateVo [offerCode=" + offerCode + ", areaCode=" + areaCode + ", sigunguCode=" + sigunguCode
				+ ", title=" + title + ", content=" + content + ", numOfAttr=" + numOfAttr + ", userId=" + userId + "]";
	}
	public EstimateVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EstimateVo(int offerCode, int areaCode, int sigunguCode, String title, String content, int numOfAttr,
			String userId) {
		super();
		this.offerCode = offerCode;
		this.areaCode = areaCode;
		this.sigunguCode = sigunguCode;
		this.title = title;
		this.content = content;
		this.numOfAttr = numOfAttr;
		this.userId = userId;
	}
	
	
	
}
