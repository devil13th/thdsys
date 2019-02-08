package com.thd.utils.myutils.bean;

public class TreeNodeForAntd {
	private String title;
	private String key;
	private Boolean isLeaf;
	public TreeNodeForAntd(String title, String key) {
		super();
		this.title = title;
		this.key = key;
		this.isLeaf = true;
	}
	public TreeNodeForAntd(String title, String key, Boolean isLeaf) {
		super();
		this.title = title;
		this.key = key;
		this.isLeaf = isLeaf;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Boolean getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
}
