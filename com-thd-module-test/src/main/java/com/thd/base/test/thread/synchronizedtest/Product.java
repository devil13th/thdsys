package com.thd.base.test.thread.synchronizedtest;

public class Product {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Product(String name){
		this.name = name;
	}
	public String toString(){
		return this.name;
	}
}
