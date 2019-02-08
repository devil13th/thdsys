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

import com.thd.common.infrastructure.pojo.SysDicPub;
import com.thd.common.infrastructure.service.SysDicPubService;
import com.thd.core.bean.ResponseBean;
import com.thd.utils.myutils.bean.QueryBeanForWeb;


@Controller
@RequestMapping(value="/infrastructure/sysDicPub")
public class SysDicPubController {
	
	@Autowired
	private SysDicPubService sysDicPubService;
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public String api(){
		ResponseBean rb = new ResponseBean();
		return "/infrastructure/sysDicPub/api";
	}
	
	
	/**
	 * 查询SysDicPubClassify
	 * @return
	 */
	@RequestMapping(value="/querySysDicPubClassify",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllSysDicPub(HttpServletRequest request){
		String name = request.getParameter("name");
		
		ResponseBean rb = new ResponseBean();
		List l = this.sysDicPubService.queryDicClassify(name);
		rb.setResult(l);
		return rb.success();
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
	 * 查询SysDicPub 使用QueryBeanForWeb封装分页排序和查询条件
	 * current : 当前页  整数  非必填
	 * pageSize : 每页行数 整数 非必填
	 * sort : 排序列名称  字段名称 非必填
	 * order : 排序规则 ASC DESC 非必填
	 * queryParams : 查询条件  json字符串  非必填
	 * @return 
	 */
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysDicPub(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//封装 分页 排序 查询条件到QueryBeanForWeb对象
		QueryBeanForWeb qb = new QueryBeanForWeb(request);
		this.sysDicPubService.querySysDicPub(qb);
		rb.setResult(qb);
		return rb.success();
	}
	
	/**
	 * 根据ID查询SysDicPub对象
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysPersonById(@PathVariable(name="id") String entityId ){
		ResponseBean rb = new ResponseBean();
		SysDicPub u = this.sysDicPubService.querySysDicPubById(entityId);
		rb.setResult(u);
		return rb.success();
	}
	
	
	
	/**
	 * 新增SysDicPub
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
	 * 更新SysDicPub
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
	
	/**
	 * 根据id删除SysDicPub
	 * @param id SysDicPub对象ID
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
	 * 根据id删除SysDicPub 多个id用","隔开
	 * @param id SysDicPub对象ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteSysDicPubBatch/{ids}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteSysDicPubBatch(@PathVariable String ids) throws Exception {
		
		this.sysDicPubService.deleteSysDicPubBatch(ids);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	@ResponseBody
	@RequestMapping(value="/testQueryList")
	//http://127.0.0.1:8080/thd/infrastructure/sysDicPub/testQueryList
	public  ResponseEntity<ResponseBean> testQueryList(Map<String,String> m){
		ResponseBean rb = new ResponseBean();
		List l = this.sysDicPubService.queryList(m);
		rb.setResult(l);
		return rb.success();
	}
	
	
}
