package com.thd.core.bean;

public class Page {
	
	public Page(){
		this.currentPage = 1;
		if(pageSize == 0){
			pageSize = 5;
		}
	}
	
	//最大页数
	private int maxPage;
	//当前页
	private int currentPage;
	//一页记录数
	private int pageSize;
	//最大记录数
	private int listSize;
	
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
}
