/** 
 * Class Description:########
 * Date : 2017年1月6日 下午10:56:20
 * Auth : wanglei 
*/  

package com.thd.utils.myutils.bean;

public class PropertyGridItem {
	private String name;
	private String value;
	private String group;
	private String editor;
	
	public PropertyGridItem(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public PropertyGridItem(String name, String value, String group,
			String editor) {
		super();
		this.name = name;
		this.value = value;
		this.group = group;
		this.editor = editor;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
