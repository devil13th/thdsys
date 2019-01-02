package com.thd.utils.myutils.bean;
/**
 * Description: to html's tag option
 * @author ThirdteenDevil
 *
 */
public class Option {
	private String text;
	private String value;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public Option() {
	}
	public Option(String text, String value) {
		super();
		this.text = text;
		this.value = value;
	}
	
}
