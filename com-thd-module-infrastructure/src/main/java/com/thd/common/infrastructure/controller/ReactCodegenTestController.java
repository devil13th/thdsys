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
import com.thd.common.infrastructure.service.ReactCodegenTestService;
import com.thd.common.infrastructure.pojo.ReactCodegenTest;
import com.thd.core.bean.ResponseBean;
import com.thd.utils.myutils.bean.QueryBeanForWeb;


@Controller
@RequestMapping(value="/infrastructure/reactCodegenTest")
public class ReactCodegenTestController {
	
	@Autowired
	private ReactCodegenTestService reactCodegenTestService;
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public String api(){
		ResponseBean rb = new ResponseBean();
		return "/infrastructure/reactCodegenTest/api";
	}
	
	/**
	 * 查询所有ReactCodegenTest
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllReactCodegenTest(){
		ResponseBean rb = new ResponseBean();
		List l = this.reactCodegenTestService.queryAllReactCodegenTest();
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 查询ReactCodegenTest 使用QueryBeanForWeb封装分页排序和查询条件
	 * current : 当前页  整数  非必填
	 * pageSize : 每页行数 整数 非必填
	 * sort : 排序列名称  字段名称 非必填
	 * order : 排序规则 ASC DESC 非必填
	 * queryParams : 查询条件  json字符串  非必填
	 * @return 
	 */
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryReactCodegenTest(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//封装 分页 排序 查询条件到QueryBeanForWeb对象
		QueryBeanForWeb qb = new QueryBeanForWeb(request);
		this.reactCodegenTestService.queryReactCodegenTest(qb);
		rb.setResult(qb);
		return rb.success();
	}
	
	/**
	 * 根据ID查询ReactCodegenTest对象
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysPersonById(@PathVariable(name="id") String entityId ){
		ResponseBean rb = new ResponseBean();
		ReactCodegenTest u = this.reactCodegenTestService.queryReactCodegenTestById(entityId);
		rb.setResult(u);
		return rb.success();
	}
	
	
	
	/**
	 * 新增ReactCodegenTest
	 * @param reactCodegenTest ReactCodegenTest对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveReactCodegenTest(@RequestBody ReactCodegenTest reactCodegenTest){
		ReactCodegenTest u = this.reactCodegenTestService.saveReactCodegenTest(reactCodegenTest);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 更新ReactCodegenTest
	 * @param reactCodegenTest ReactCodegenTest对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateReactCodegenTest(@RequestBody ReactCodegenTest reactCodegenTest){
		ReactCodegenTest u = this.reactCodegenTestService.updateReactCodegenTest(reactCodegenTest);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	/**
	 * 根据id删除ReactCodegenTest
	 * @param id ReactCodegenTest对象ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteReactCodegenTestById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("id not be found");
		}
		if(this.reactCodegenTestService.queryReactCodegenTestById(id) == null){
			throw new Exception("not found ReactCodegenTest id:[" + id + "]");
		}
		this.reactCodegenTestService.deleteReactCodegenTestById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	/**
	 * 根据id删除ReactCodegenTest 多个id用","隔开
	 * @param id ReactCodegenTest对象ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteReactCodegenTestBatch/{ids}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteReactCodegenTestBatch(@PathVariable String ids) throws Exception {
		
		this.reactCodegenTestService.deleteReactCodegenTestBatch(ids);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	
}
