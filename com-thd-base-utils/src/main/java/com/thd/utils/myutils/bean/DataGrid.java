/** 
 * Class Description:########
 * Date : 2017年4月2日 下午11:46:04
 * Auth : wanglei 
*/  

package com.thd.utils.myutils.bean;

import java.util.List;

public class DataGrid {
	//总条目数
	private int total;
	//数据集合
	private List rows;
	//footer集合
	private List footer;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public List getFooter() {
		return footer;
	}
	public void setFooter(List footer) {
		this.footer = footer;
	}
	
}
