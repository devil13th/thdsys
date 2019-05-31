package com.thd.concurrence.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thd.concurrence.bean.Counter;
import com.thd.concurrence.service.ConcurrenceService;
import com.thd.core.bean.ResponseBean;
import com.thd.core.controller.BaseController;

@RestController
@RequestMapping(value="/concurrence")
public class ConcurrenceController extends BaseController{
	
	private Logger log  = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ConcurrenceService concurrenceService ;
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ResponseEntity index(){
		ResponseBean<Integer> rb = new ResponseBean<Integer>();
		synchronized(this){
			Counter.i += 1 ; 
			System.out.println(Thread.currentThread().getName() + " : " + Counter.i);
			rb.setResult(Counter.i);
		}
		return rb.success();
	}
	
	@RequestMapping(value="/clear")
	public ResponseEntity clear(){
		ResponseBean<Integer> rb = new ResponseBean<Integer>();
		synchronized(this){
			Counter.i = 0;
			rb.setResult(Counter.i);
		}
		return rb.success();
	}
	
	@RequestMapping(value="/show")
	public ResponseEntity show(){
		ResponseBean<Integer> rb = new ResponseBean<Integer>();
		synchronized(this){
			rb.setResult(Counter.i);
		}
		return rb.success();
	}
	
	/**
	 * 使用数据库排它锁控制高并发的顺序执行
	 * @return
	 */
	@RequestMapping(value="/xlock")
	public ResponseEntity xlock(){
		ResponseBean<Integer> rb = new ResponseBean<Integer>();
		int r = concurrenceService.xlock(1);
		rb.setResult(r);
		System.out.println(r);
		return rb.success();
	}
	
	/**
	 * 使用数据库乐观锁控制高并发的顺序执行
	 * @return
	 */
	@RequestMapping(value="/optimisticlock")
	public ResponseEntity optimisticlock(){
		ResponseBean<Integer> rb = new ResponseBean<Integer>();
		try{
			int r = 0;
			while(true){
				r = concurrenceService.optimisticLock(1);
				if(r == 1){
					break;
				}
			}
			rb.setResult(r);
			System.out.println(r);
			return rb.success();
		}catch(Exception e){
			log.info(e.getMessage());
			rb.setResult(-1);
			return rb.failure();
		}
		
	}
	
	
	
	
	@RequestMapping(value="/doConcurrence2")
	public ResponseEntity doConcurrence2(){
		ResponseBean<Long> rb = new ResponseBean<Long>();
		long ct = concurrenceService.addForRedis();
		rb.setResult(ct);
		return rb.success();
	}
	
	@RequestMapping(value="/clearRedis")
	public ResponseEntity clearRedis(){
		ResponseBean<Long> rb = new ResponseBean<Long>();
		concurrenceService.clearRedis();
		rb.setResult(10l);
		return rb.success();
	}
	
	
	
}
