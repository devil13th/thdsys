package com.thd.mybatis.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.mybatis.entity.User;
import com.thd.mybatis.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/insert")
	public ResponseEntity<String> save(){
		ResponseEntity<String> re = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		User u = new User();
		u.setId(UUID.randomUUID().toString().replace("-", ""));
		u.setName("devil13th");
		u.setSex(2);
		userService.save(u);
		return re;
	}
	
	@ResponseBody
	@RequestMapping(value="/getOneMap/{id}")
	public ResponseEntity<Map> getOneMap(@PathVariable Long id){
		Map m = userService.queryById(id);
		ResponseEntity<Map> re = new ResponseEntity<Map>(m,HttpStatus.OK);
		return re;
	}
	
}
