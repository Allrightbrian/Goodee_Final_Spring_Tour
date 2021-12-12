package com.tour.edu.vo;

public class Post_Vo {
	
	private int post_id;
	private String post_title;
	private String post_content;
	private String post_img_path;
	private int attrloc1;
	private int attrloc2;
	private int post_theme_id;
	private String post_delflag;
	private String post_regdate;
	private int post_like_count;
	private int post_view_count;
	private String id;
	private int bookno;

	public Post_Vo() {
	}

	public Post_Vo(int post_id, String post_title, String post_content, String post_img_path, int attrloc1,
			int attrloc2, int post_theme_id, String post_delflag, String post_regdate, int post_like_count,
			int post_view_count, String id, int bookno) {
		super();
		this.post_id = post_id;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_img_path = post_img_path;
		this.attrloc1 = attrloc1;
		this.attrloc2 = attrloc2;
		this.post_theme_id = post_theme_id;
		this.post_delflag = post_delflag;
		this.post_regdate = post_regdate;
		this.post_like_count = post_like_count;
		this.post_view_count = post_view_count;
		this.id = id;
		this.bookno = bookno;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getPost_img_path() {
		return post_img_path;
	}

	public void setPost_img_path(String post_img_path) {
		this.post_img_path = post_img_path;
	}

	public int getAttrloc1() {
		return attrloc1;
	}

	public void setAttrloc1(int attrloc1) {
		this.attrloc1 = attrloc1;
	}

	public int getAttrloc2() {
		return attrloc2;
	}

	public void setAttrloc2(int attrloc2) {
		this.attrloc2 = attrloc2;
	}

	public int getPost_theme_id() {
		return post_theme_id;
	}

	public void setPost_theme_id(int post_theme_id) {
		this.post_theme_id = post_theme_id;
	}

	public String getPost_delflag() {
		return post_delflag;
	}

	public void setPost_delflag(String post_delflag) {
		this.post_delflag = post_delflag;
	}

	public String getPost_regdate() {
		return post_regdate;
	}

	public void setPost_regdate(String post_regdate) {
		this.post_regdate = post_regdate;
	}

	public int getPost_like_count() {
		return post_like_count;
	}

	public void setPost_like_count(int post_like_count) {
		this.post_like_count = post_like_count;
	}

	public int getPost_view_count() {
		return post_view_count;
	}

	public void setPost_view_count(int post_view_count) {
		this.post_view_count = post_view_count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBookno() {
		return bookno;
	}

	public void setBookno(int bookno) {
		this.bookno = bookno;
	}

	@Override
	public String toString() {
		return "Post_Vo [post_id=" + post_id + ", post_title=" + post_title + ", post_content=" + post_content
				+ ", post_img_path=" + post_img_path + ", attrloc1=" + attrloc1 + ", attrloc2=" + attrloc2
				+ ", post_theme_id=" + post_theme_id + ", post_delflag=" + post_delflag + ", post_regdate="
				+ post_regdate + ", post_like_count=" + post_like_count + ", post_view_count=" + post_view_count
				+ ", id=" + id + ", bookno=" + bookno + "]";
	}

}
