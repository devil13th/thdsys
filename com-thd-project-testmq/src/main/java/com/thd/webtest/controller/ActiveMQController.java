package com.thd.webtest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thd.core.bean.ResponseBean;
import com.thd.core.controller.BaseController;
import com.thd.webtest.service.PTPReceive;
import com.thd.webtest.service.PTPSend;
@RestController
@RequestMapping(value="/activemq")
public class ActiveMQController extends BaseController {
	
	
    //开关
    public static boolean POWER = true;
    
    
	@RequestMapping(value="/test")
	public ResponseEntity<ResponseBean> test(){
		System.out.println("SUCCESS");
		ResponseBean rb = new ResponseBean();
		rb.setResult("success");
		return rb.success();
	}
	
	
	@RequestMapping(value="/sendMessage")
	/**
	 * 发送消息
	 * http://127.0.0.1:8001/webtest/activemq/sendMessage
	 * @return
	 */
	public ResponseEntity<ResponseBean> sendMessage(){
		this.getLogger().info("sendMessage()");
		
		System.out.println("创建消息生产者");
		PTPSend ps = new PTPSend();
		ps.start();

		ResponseBean rb = new ResponseBean();
		rb.setResult("success");
		return rb.success();
	} 
	
	
	
	@RequestMapping(value="/receiverMessage")
	/**
	 * 接受消息
	 * http://127.0.0.1:8001/webtest/activemq/receiverMessage
	 * @return
	 */
	public ResponseEntity<ResponseBean> MessageReceiver(){
		System.out.println("创建消息消费者");
		PTPReceive pr = new PTPReceive();
		pr.start();
        
        
        ResponseBean rb = new ResponseBean();
		rb.setResult("success");
		return rb.success();
		
	}
	
	
	
	@RequestMapping(value="/exit")
	/**
	 * 结束接受消息
	 * http://127.0.0.1:8001/webtest/activemq/exit
	 * @return
	 */
	public ResponseEntity<ResponseBean> exit(){
		POWER = false;
		ResponseBean rb = new ResponseBean();
		rb.setResult("success");
		return rb.success();
	}
	
	@RequestMapping(value="/begin")
	/**
	 * 开始接受消息
	 * http://127.0.0.1:8001/webtest/activemq/begin
	 * @return
	 */
	public ResponseEntity<ResponseBean> begin(){
		POWER = true;
		ResponseBean rb = new ResponseBean();
		rb.setResult("success");
		return rb.success();
	}
}
