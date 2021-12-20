package com.tour.edu.vo;

public class CalculateVo {
	//산출서
	private int resultCode;
	private int offerCode;
	private String route;
	private String title;
	private String content;
	private int viewCnt;
	private String userId;
	public CalculateVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CalculateVo(int resultCode, int offerCode, String route, String title, String content, int viewCnt,
			String userId) {
		super();
		this.resultCode = resultCode;
		this.offerCode = offerCode;
		this.route = route;
		this.title = title;
		this.content = content;
		this.viewCnt = viewCnt;
		this.userId = userId;
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public int getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(int offerCode) {
		this.offerCode = offerCode;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
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
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
