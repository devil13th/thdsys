package com.thd.base.test.thread.synchronizedtest;

import java.util.List;

public class Producer implements Runnable {
	private String name;
	private List<Product> l;
	private int summary = 0;
	public Producer(String name,List<Product> l){
		this.name = name;
		this.l = l;
	}
	@Override
	public void run() {
		while(ProductContainer.power){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized(l){
				while(l.size() >= ProductContainer.maxSize){
					try {
						l.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				summary++ ;
				Product p = new Product( "no" + summary);
				ProductContainer.l.add(p);
				System.out.println(this.name + " 生产:" + p  +  " 容量:" + l.size());
				l.notifyAll();
			}
		}
	}

}
