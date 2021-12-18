package com.tour.edu.vo;

public class Comment_Vo {
	private int comment_id;
	private int comment_post_id;
	private String comment_content;
	private String comment_regdate;
	private String comment_delflag;
	private String id;

	public Comment_Vo(int comment_id, int comment_post_id, String comment_content, String comment_regdate,
			String comment_delflag, String id) {
		this.comment_id = comment_id;
		this.comment_post_id = comment_post_id;
		this.comment_content = comment_content;
		this.comment_regdate = comment_regdate;
		this.comment_delflag = comment_delflag;
		this.id = id;
	}

	public Comment_Vo() {
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getComment_post_id() {
		return comment_post_id;
	}

	public void setComment_post_id(int comment_post_id) {
		this.comment_post_id = comment_post_id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_regdate() {
		return comment_regdate;
	}

	public void setComment_regdate(String comment_regdate) {
		this.comment_regdate = comment_regdate;
	}

	public String getComment_delflag() {
		return comment_delflag;
	}

	public void setComment_delflag(String comment_delflag) {
		this.comment_delflag = comment_delflag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Comment_Vo [comment_id=" + comment_id + ", comment_post_id=" + comment_post_id + ", comment_content="
				+ comment_content + ", comment_regdate=" + comment_regdate + ", comment_delflag=" + comment_delflag
				+ ", id=" + id + "]";
	}

}
