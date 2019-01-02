/** 
 * Class Description:########
 * Date : 2017年1月3日 下午10:05:02
 * Auth : wanglei 
*/  

package com.thd.utils.myutils.bean;

import java.util.List;

public class TreeGrid {
	private String id;
	private String name;
	private String ck;
	private String leaf;
	private String code;
	public String getLeaf() {
		return leaf;
	}
	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCk() {
		return ck;
	}
	public void setCk(String ck) {
		this.ck = ck;
	}
	private List<TreeGrid> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TreeGrid> getChildren() {
		return children;
	}
	public void setChildren(List<TreeGrid> children) {
		this.children = children;
	}
}
