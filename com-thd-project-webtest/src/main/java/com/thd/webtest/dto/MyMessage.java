package com.thd.webtest.dto;

import java.io.Serializable;

public class MyMessage implements Serializable{
	private String message;
	private String name;
	private Integer age;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String toString(){
		return this.name + " " + this.age + " " + this.message ;
	}
	
}
