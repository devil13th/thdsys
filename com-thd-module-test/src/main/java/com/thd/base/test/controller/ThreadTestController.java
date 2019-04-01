package com.thd.base.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.base.test.thread.synchronizedtest.Consumer;
import com.thd.base.test.thread.synchronizedtest.Producer;
import com.thd.base.test.thread.synchronizedtest.ProductContainer;


@Controller
//@RestController
public class ThreadTestController {
	
	/**
	 * 控制页面
	 * http://127.0.0.1:8080/com-thd-project-devil13th/threadTest/index
	 * @param producerName
	 * @return
	 */
	@RequestMapping(value="/threadTest/index")
	public String index(){
		System.out.println("index");
		return "/threadtest/index";
	}
	
	
	/**
	 * 启动生产者
	 * http://127.0.0.1:8080/com-thd-project-devil13th/threadTest/beginProduct/a1
	 * @param producerName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/threadTest/beginProduct/{producerName}")
	public String beginProduct(@PathVariable String producerName){
		ProductContainer.power = true;
		Thread t = new Thread(new Producer(producerName,ProductContainer.l));
		t.start();
		return "success";
	}
	
	/**
	 * 启动消费者
	 * http://127.0.0.1:8080/com-thd-project-devil13th/threadTest/beginConsumer/b1
	 * @param producerName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/threadTest/beginConsumer/{consumerName}")
	public String beginConsumer(@PathVariable String consumerName){
		ProductContainer.power = true;
		Thread t = new Thread(new Consumer(consumerName,ProductContainer.l));
		t.start();
		return "success";
	}
	
	
	/**
	 * 停止生产消费
	 * http://127.0.0.1:8080/com-thd-project-devil13th/threadTest/exit
	 * @param producerName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/threadTest/exit")
	public String exit(){
		ProductContainer.power = false;
		return "success";
	}
}
