package com.thd.base.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.base.test.cfgbean.YmlCfg;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private YmlCfg ymlCfg;
	
	@RequestMapping("/test01")
	public String test01(){
		System.out.println("hello test01234");
		
		System.out.println(ymlCfg.getProjectName());
		return "/index";
	}
	
	@RequestMapping("/test02")
	@ResponseBody
	public String test02(){
		System.out.println("hello test02");
		return "s";
	}
}
