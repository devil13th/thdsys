/** 
 * Class Description:########
 * Date : 2017年1月6日 下午10:55:32
 * Auth : wanglei 
*/  

package com.thd.utils.myutils.bean;

import java.util.ArrayList;
import java.util.List;

public class PropertyGrid {
	private Integer total;
	private List<PropertyGridItem> rows = new ArrayList<PropertyGridItem>();
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<PropertyGridItem> getRows() {
		return rows;
	}
	public void setRows(List<PropertyGridItem> rows) {
		this.rows = rows;
	}
	
}
