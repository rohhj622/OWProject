package com.prjct.hj.domain;

public class AttachedFileVO{
	private int af_idx;
	private int post_idx;
	private String af_originalName;
	private String af_reName;
	private long af_fileSize;
	private String af_date;
	private String af_creaID;
	private String af_isDel;
	
	
	public int getAf_idx() {
		return af_idx;
	}
	public void setAf_idx(int af_idx) {
		this.af_idx = af_idx;
	}
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	public String getAf_originalName() {
		return af_originalName;
	}
	public void setAf_originalName(String af_originalName) {
		this.af_originalName = af_originalName;
	}
	public String getAf_reName() {
		return af_reName;
	}
	public void setAf_reName(String af_reName) {
		this.af_reName = af_reName;
	}
	public long getAf_fileSize() {
		return af_fileSize;
	}
	public void setAf_fileSize(long af_fileSize) {
		this.af_fileSize = af_fileSize;
	}
	public String getAf_date() {
		return af_date;
	}
	public void setAf_date(String af_date) {
		this.af_date = af_date;
	}
	public String getAf_creaID() {
		return af_creaID;
	}
	public void setAf_creaID(String af_creaID) {
		this.af_creaID = af_creaID;
	}
	public String getAf_isDel() {
		return af_isDel;
	}
	public void setAf_isDel(String af_isDel) {
		this.af_isDel = af_isDel;
	}
	
}
