package com.thd.base.test.thread.synchronizedtest;

import java.util.List;

public class Consumer implements Runnable {
	private String name;
	private List<Product> l;
	private int summary = 0;
	public Consumer(String name,List<Product> l){
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
				while(l.size() <= 0){
					try {
						l.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Product p = l.get(l.size()-1);
				l.remove(l.size() - 1);
				System.out.println(this.name + " 消费:" + p  +  " 容量:" + l.size());
				l.notifyAll();
			}
		}
	}

}
