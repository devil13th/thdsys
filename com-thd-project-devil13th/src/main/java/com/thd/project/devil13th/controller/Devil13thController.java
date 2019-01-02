package com.thd.project.devil13th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.Application;
import com.thd.common.infrastructure.service.SysUserService;

@Controller
@RequestMapping(value="/devil13th")
public class Devil13thController {
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value="/test")
	@ResponseBody
	public String test(){
		return "aa";
	}

}
