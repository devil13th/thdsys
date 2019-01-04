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

import com.thd.common.infrastructure.dao.SysDicPubDao;
import com.thd.common.infrastructure.pojo.SysDicPub;
import com.thd.common.infrastructure.service.SysDicPubService;
import com.thd.core.bean.ResponseBean;


@Controller
@RequestMapping(value="/infrastructure/sysDicPub")
public class SysDicPubController {
	@Autowired
	private SysDicPubService sysDicPubService;
	@Autowired
	private SysDicPubDao sysDicPubDao;
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public String api(){
		ResponseBean rb = new ResponseBean();
		return "/infrastructure/sysdicpub/api";
	}
	
	/**
	 * 查询所有SysDicPub
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllSysDicPub(){
		ResponseBean rb = new ResponseBean();
		List l = this.sysDicPubService.queryAllSysDicPub();
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 查询所有SysDicPub
	 * @return
	 */
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysDicPub(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//List l = sysDicPubDao.findAll();
		Map m = new HashMap();
		if(request.getParameter("dicName") != null){
			m.put("dicName", request.getParameter("dicName"));
		}
		List l = this.sysDicPubService.querySysDicPub(m);
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 根据ID查询SysDicPub对象
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysPersonById(@PathVariable(name="id") String dicId ){
		ResponseBean rb = new ResponseBean();
		SysDicPub u = this.sysDicPubService.querySysDicPubById(dicId);
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
	public ResponseEntity<ResponseBean> deleteSysDicPubById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("id not be found");
		}
		if(this.sysDicPubService.querySysDicPubById(id) == null){
			throw new Exception("not found SysDicPub id:[" + id + "]");
		}
		this.sysDicPubService.deleteSysDicPubById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	/**
	 * 新增用户
	 * @param sysDicPub SysDicPub对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveSysDicPub(@RequestBody SysDicPub sysDicPub){
		SysDicPub u = this.sysDicPubService.saveSysDicPub(sysDicPub);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 更新用户
	 * @param sysDicPub SysDicPub对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateSysDicPub(@RequestBody SysDicPub sysDicPub){
		SysDicPub u = this.sysDicPubService.updateSysDicPub(sysDicPub);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	
	
	
	
}
