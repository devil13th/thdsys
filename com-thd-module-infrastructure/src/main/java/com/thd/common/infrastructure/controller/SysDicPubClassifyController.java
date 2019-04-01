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
import com.thd.common.infrastructure.service.SysDicPubClassifyService;
import com.thd.common.infrastructure.pojo.SysDicPubClassify;
import com.thd.core.bean.ResponseBean;
import com.thd.utils.myutils.bean.QueryBeanForWeb;


@Controller
@RequestMapping(value="/infrastructure/sysDicPubClassify")
public class SysDicPubClassifyController {
	
	@Autowired
	private SysDicPubClassifyService sysDicPubClassifyService;
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public String api(){
		ResponseBean rb = new ResponseBean();
		return "/infrastructure/sysDicPubClassify/api";
	}
	
	/**
	 * 查询所有SysDicPubClassify
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllSysDicPubClassify(){
		ResponseBean rb = new ResponseBean();
		List l = this.sysDicPubClassifyService.queryAllSysDicPubClassify();
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 查询SysDicPubClassify 使用QueryBeanForWeb封装分页排序和查询条件
	 * current : 当前页  整数  非必填
	 * pageSize : 每页行数 整数 非必填
	 * sort : 排序列名称  字段名称 非必填
	 * order : 排序规则 ASC DESC 非必填
	 * queryParams : 查询条件  json字符串  非必填
	 * @return 
	 */
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysDicPubClassify(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//封装 分页 排序 查询条件到QueryBeanForWeb对象
		QueryBeanForWeb qb = new QueryBeanForWeb(request);
		this.sysDicPubClassifyService.querySysDicPubClassify(qb);
		rb.setResult(qb);
		return rb.success();
	}
	
	/**
	 * 根据ID查询SysDicPubClassify对象
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysPersonById(@PathVariable(name="id") String entityId ){
		ResponseBean rb = new ResponseBean();
		SysDicPubClassify u = this.sysDicPubClassifyService.querySysDicPubClassifyById(entityId);
		rb.setResult(u);
		return rb.success();
	}
	
	
	
	/**
	 * 新增SysDicPubClassify
	 * @param sysDicPubClassify SysDicPubClassify对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveSysDicPubClassify(@RequestBody SysDicPubClassify sysDicPubClassify){
		SysDicPubClassify u = this.sysDicPubClassifyService.saveSysDicPubClassify(sysDicPubClassify);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 更新SysDicPubClassify
	 * @param sysDicPubClassify SysDicPubClassify对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateSysDicPubClassify(@RequestBody SysDicPubClassify sysDicPubClassify){
		SysDicPubClassify u = this.sysDicPubClassifyService.updateSysDicPubClassify(sysDicPubClassify);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	/**
	 * 根据id删除SysDicPubClassify
	 * @param id SysDicPubClassify对象ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteSysDicPubClassifyById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("id not be found");
		}
		if(this.sysDicPubClassifyService.querySysDicPubClassifyById(id) == null){
			throw new Exception("not found SysDicPubClassify id:[" + id + "]");
		}
		this.sysDicPubClassifyService.deleteSysDicPubClassifyById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	/**
	 * 根据id删除SysDicPubClassify 多个id用","隔开
	 * @param id SysDicPubClassify对象ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteSysDicPubClassifyBatch/{ids}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteSysDicPubClassifyBatch(@PathVariable String ids) throws Exception {
		
		this.sysDicPubClassifyService.deleteSysDicPubClassifyBatch(ids);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	
}
