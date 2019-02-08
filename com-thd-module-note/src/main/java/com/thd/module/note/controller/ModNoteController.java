package com.thd.module.note.controller;

import java.util.List;

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

import com.thd.core.bean.ResponseBean;
import com.thd.module.note.pojo.ModNoteClassify;
import com.thd.module.note.pojo.ModNoteContent;
import com.thd.module.note.pojo.ModNoteList;
import com.thd.module.note.service.ModNoteService;
import com.thd.utils.myutils.bean.QueryBeanForWeb;
@Controller
@RequestMapping(value="/note")
public class ModNoteController {

	@Autowired
	private ModNoteService modNoteService;
	
	
	
	/**
	 * 根据ID查询ModNoteContent对象
	 * @return
	 */
	@RequestMapping(value="/ModNoteContent/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryModNoteContentById(@PathVariable(name="id") String entityId ){
		ResponseBean rb = new ResponseBean();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ModNoteContent u = this.modNoteService.queryModNoteContentById(entityId);
		rb.setResult(u);
		return rb.success();
	}
	
	/**
	 * 新增或修改ModNoteContent
	 * @param modNoteContent ModNoteContent对象
	 * @return
	 */
	@RequestMapping(value="/ModNoteContent",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveOrUpdateModNoteContent(@RequestBody ModNoteContent modNoteContent){
		ModNoteContent u = this.modNoteService.saveOrUpdateModNoteContent(modNoteContent);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/modNoteListApi",method=RequestMethod.GET)
	public String modNoteListApi(){
		ResponseBean rb = new ResponseBean();
		return "/note/modNoteList/api";
	}
	
	/**
	 * 查询所有ModNoteList
	 * @return
	 */
	@RequestMapping(value="/ModNoteList",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllModNoteList(){
		ResponseBean rb = new ResponseBean();
		List l = this.modNoteService.queryAllModNoteList();
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 查询ModNoteList 使用QueryBeanForWeb封装分页排序和查询条件
	 * current : 当前页  整数  非必填
	 * pageSize : 每页行数 整数 非必填
	 * sort : 排序列名称  字段名称 非必填
	 * order : 排序规则 ASC DESC 非必填
	 * queryParams : 查询条件  json字符串  非必填
	 * @return 
	 */
	@RequestMapping(value="/ModNoteList/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryModNoteList(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//封装 分页 排序 查询条件到QueryBeanForWeb对象
		QueryBeanForWeb qb = new QueryBeanForWeb(request);
		this.modNoteService.queryModNoteList(qb);
		rb.setResult(qb);
		return rb.success();
	}
	
	/**
	 * 根据ID查询ModNoteList对象
	 * @return
	 */
	@RequestMapping(value="/ModNoteList/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryModNoteListById(@PathVariable(name="id") String entityId ){
		ResponseBean rb = new ResponseBean();
		ModNoteList u = this.modNoteService.queryModNoteListById(entityId);
		rb.setResult(u);
		return rb.success();
	}
	
	
	
	/**
	 * 新增ModNoteList
	 * @param modNoteList ModNoteList对象
	 * @return
	 */
	@RequestMapping(value="/ModNoteList",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveModNoteList(@RequestBody ModNoteList modNoteList){
		ModNoteList u = this.modNoteService.saveModNoteList(modNoteList);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 更新ModNoteList
	 * @param modNoteList ModNoteList对象
	 * @return
	 */
	@RequestMapping(value="/ModNoteList",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateModNoteList(@RequestBody ModNoteList modNoteList){
		ModNoteList u = this.modNoteService.updateModNoteList(modNoteList);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	/**
	 * 根据id删除ModNoteList
	 * @param id ModNoteList对象ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/ModNoteList/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteModNoteListById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("id not be found");
		}
		if(this.modNoteService.queryModNoteListById(id) == null){
			throw new Exception("not found ModNoteList id:[" + id + "]");
		}
		this.modNoteService.deleteModNoteListById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/ModNoteClassify/api",method=RequestMethod.GET)
	public String api(){
		ResponseBean rb = new ResponseBean();
		return "/note/modNoteClassify/api";
	}
	
	/**
	 * 查询所有ModNoteClassify
	 * @return
	 */
	@RequestMapping(value="/ModNoteClassify/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllModNoteClassify(){
		ResponseBean rb = new ResponseBean();
		List l = this.modNoteService.queryAllModNoteClassify();
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 查询ModNoteClassify 使用QueryBeanForWeb封装分页排序和查询条件
	 * current : 当前页  整数  非必填
	 * pageSize : 每页行数 整数 非必填
	 * sort : 排序列名称  字段名称 非必填
	 * order : 排序规则 ASC DESC 非必填
	 * queryParams : 查询条件  json字符串  非必填
	 * @return 
	 */
	@RequestMapping(value="/ModNoteClassify/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryModNoteClassify(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//封装 分页 排序 查询条件到QueryBeanForWeb对象
		QueryBeanForWeb qb = new QueryBeanForWeb(request);
		this.modNoteService.queryModNoteClassify(qb);
		rb.setResult(qb);
		return rb.success();
	}
	
	/**
	 * 根据ID查询ModNoteClassify对象
	 * @return
	 */
	@RequestMapping(value="/ModNoteClassify/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysPersonById(@PathVariable(name="id") String entityId ){
		ResponseBean rb = new ResponseBean();
		ModNoteClassify u = this.modNoteService.queryModNoteClassifyById(entityId);
		rb.setResult(u);
		return rb.success();
	}
	
	
	
	/**
	 * 新增用户
	 * @param modNoteClassify ModNoteClassify对象
	 * @return
	 */
	@RequestMapping(value="/ModNoteClassify/",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveModNoteClassify(@RequestBody ModNoteClassify modNoteClassify){
		ModNoteClassify u = this.modNoteService.saveModNoteClassify(modNoteClassify);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 更新用户
	 * @param modNoteClassify ModNoteClassify对象
	 * @return
	 */
	@RequestMapping(value="/ModNoteClassify/",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateModNoteClassify(@RequestBody ModNoteClassify modNoteClassify){
		ModNoteClassify u = this.modNoteService.updateModNoteClassify(modNoteClassify);
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
	@RequestMapping(value="/ModNoteClassify/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteModNoteClassifyById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("id not be found");
		}
		if(this.modNoteService.queryModNoteClassifyById(id) == null){
			throw new Exception("not found ModNoteClassify id:[" + id + "]");
		}
		this.modNoteService.deleteModNoteClassifyById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	
	
	
	
	/**
	 * 根据treecode根节点
	 * @return
	 */
	@RequestMapping(value="/queryRoot",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryRoot(){
		ResponseBean rb = new ResponseBean();
		List roots = this.modNoteService.queryRoot();
		rb.setResult(roots);
		return rb.success();
	}
	
	
	/**
	 * 根据treecode查询ModNoteClassify列表
	 * @return
	 */
	@RequestMapping(value="/queryNextNodes/{treeCode}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryNextNodes(@PathVariable(name="treeCode") String code ){
		ResponseBean rb = new ResponseBean();
		List l = this.modNoteService.queryNextNodes(code);
		rb.setResult(l);
		return rb.success();
	}
}
