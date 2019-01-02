/** 
 * Class Description:########
 * Date : 2017年5月9日 下午11:24:21
 * Auth : wanglei 
*/  

package com.thd.utils.myutils.bean;

import java.util.List;

public class EasyUiTreeBean {
	private String id;
	private String text;
	private String parentId;
	//状态 closed , open
	private String state;
	private List<EasyUiTreeBean> children;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<EasyUiTreeBean> getChildren() {
		return children;
	}
	public void setChildren(List<EasyUiTreeBean> children) {
		this.children = children;
	}

}
