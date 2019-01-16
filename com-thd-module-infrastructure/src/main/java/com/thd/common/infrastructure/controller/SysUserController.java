package com.thd.common.infrastructure.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.common.infrastructure.dao.SysUserDao;
import com.thd.common.infrastructure.pojo.SysUser;
import com.thd.common.infrastructure.service.SysUserService;
import com.thd.core.bean.ResponseBean;
import com.thd.utils.myutils.bean.QueryBeanForWeb;


@Controller
@RequestMapping(value="/infrastructure/sysUser")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserDao sysUserDao;
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public String api(){
		ResponseBean rb = new ResponseBean();
		return "/infrastructure/sysuser/api";
	}
	
	/**
	 * 查询所有SysUser
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllSysUser(){
		ResponseBean rb = new ResponseBean();
		List l = this.sysUserService.queryAllSysUser();
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 查询SysUser 使用QueryBeanForWeb封装分页排序和查询条件
	 * current : 当前页  整数  非必填
	 * pageSize : 每页行数 整数 非必填
	 * sort : 排序列名称  字段名称 非必填
	 * order : 排序规则 ASC DESC 非必填
	 * queryParams : 查询条件  json字符串  非必填
	 * @return 
	 */
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysUser(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//封装 分页 排序 查询条件到QueryBeanForWeb对象
		QueryBeanForWeb qb = new QueryBeanForWeb(request);
		this.sysUserService.querySysUser(qb);
		rb.setResult(qb);
		return rb.success();
	}
	
	/**
	 * 根据ID查询SysUser对象
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysPersonById(@PathVariable(name="id") String userId ){
		ResponseBean rb = new ResponseBean();
		SysUser u = this.sysUserService.querySysUserById(userId);
		rb.setResult(u);
		return rb.success();
	}
	
	
	
	/**
	 * 新增用户
	 * @param sysUser SysUser对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveSysUser(@RequestBody SysUser sysUser){
		SysUser u = this.sysUserService.saveSysUser(sysUser);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 更新用户
	 * @param sysUser SysUser对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateSysUser(@RequestBody SysUser sysUser){
		SysUser u = this.sysUserService.updateSysUser(sysUser);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	/**
	 * 根据id删除用户
	 * @param id 用户ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteSysUserById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("id not be found");
		}
		if(this.sysUserService.querySysUserById(id) == null){
			throw new Exception("not found SysUser id:[" + id + "]");
		}
		this.sysUserService.deleteSysUserById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	
}
