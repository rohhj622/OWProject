package com.prjct.hj.domain;

public class PostVO{
	private int post_idx; //Auto Increase
	private String mem_id; //member Table 참조
	private String post_title;
	private String post_content;
	private String post_date;
	private String post_sido;
	private String post_gugun;
	private String post_theme;
	private String post_views;
	
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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
	public String getPost_date() {
		return post_date;
	}
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	public String getPost_sido() {
		return post_sido;
	}
	public void setPost_sido(String post_sido) {
		this.post_sido = post_sido;
	}
	public String getPost_gugun() {
		return post_gugun;
	}
	public void setPost_gugun(String post_gugun) {
		this.post_gugun = post_gugun;
	}
	public String getPost_theme() {
		return post_theme;
	}
	public void setPost_theme(String post_theme) {
		this.post_theme = post_theme;
	}
	public String getPost_views() {
		return post_views;
	}
	public void setPost_views(String post_views) {
		this.post_views = post_views;
	}

	
}
