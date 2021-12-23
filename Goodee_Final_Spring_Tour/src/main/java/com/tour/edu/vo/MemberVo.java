package com.tour.edu.vo;

public class MemberVo {
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	private String joindate;
	private String profile_img_path;
	private String delflag;
	private String manager;
	private String final_login;
	private String panalty;
	private String panalty_end_date;
	private String dormancyflag;
	private String snsjoin;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getProfile_img_path() {
		return profile_img_path;
	}
	public void setProfile_img_path(String profile_img_path) {
		this.profile_img_path = profile_img_path;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getFinal_login() {
		return final_login;
	}
	public void setFinal_login(String final_login) {
		this.final_login = final_login;
	}
	public String getPanalty() {
		return panalty;
	}
	public void setPanalty(String panalty) {
		this.panalty = panalty;
	}
	public String getPanalty_end_date() {
		return panalty_end_date;
	}
	public void setPanalty_end_date(String panalty_end_date) {
		this.panalty_end_date = panalty_end_date;
	}
	public String getDormancyflag() {
		return dormancyflag;
	}
	public void setDormancyflag(String dormancyflag) {
		this.dormancyflag = dormancyflag;
	}
	public String getSnsjoin() {
		return snsjoin;
	}
	public void setSnsjoin(String snsjoin) {
		this.snsjoin = snsjoin;
	}
	public MemberVo() {
		super();
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", password=" + password + ", name=" + name + ", nickname=" + nickname
				+ ", phone=" + phone + ", email=" + email + ", joindate=" + joindate + ", profile_img_path="
				+ profile_img_path + ", delflag=" + delflag + ", manager=" + manager + ", final_login=" + final_login
				+ ", panalty=" + panalty + ", panalty_end_date=" + panalty_end_date + ", dormancyflag=" + dormancyflag
				+ ", snsjoin=" + snsjoin + "]";
	}
	
	
}
