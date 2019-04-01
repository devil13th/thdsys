package com.thd.webtest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thd.core.bean.ResponseBean;
import com.thd.core.controller.BaseController;
@RestController
public class WebTestController extends BaseController {
	@RequestMapping(value="/webtest/text")
	public ResponseEntity<ResponseBean> test(){
		System.out.println("SUCCESS");
		ResponseBean rb = new ResponseBean();
		rb.setResult("success");
		return rb.success();
	}
}
