package com.thd.webtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thd.core.bean.ResponseBean;
import com.thd.core.controller.BaseController;
import com.thd.webtest.service.WebTestService;
@RestController
@RequestMapping(value="/webtest")
public class WebTestController extends BaseController {
	@Autowired
	private WebTestService webTestService;
	@RequestMapping(value="/text")
	public ResponseEntity<ResponseBean> test(){
		System.out.println("SUCCESS");
		ResponseBean rb = new ResponseBean();
		rb.setResult("success");
		return rb.success();
	}
	
	
	@RequestMapping(value="/testDbLock")
	public ResponseEntity<ResponseBean> testDbLock(){
		System.out.println("testDbLock");
		
		webTestService.testDbLock();
		
		ResponseBean rb = new ResponseBean();
		rb.setResult("success");
		return rb.success();
		
	}
}
