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
import com.thd.module.note.pojo.ModNoteContent;
import com.thd.module.note.pojo.ModNoteList;
import com.thd.module.note.service.ModNoteContentService;
import com.thd.module.note.service.ModNoteListService;
import com.thd.utils.myutils.bean.QueryBeanForWeb;


@Controller
@RequestMapping(value="/note/modNoteList")
public class ModNoteListController {
	
	@Autowired
	private ModNoteListService modNoteListService;
	@Autowired
	private ModNoteContentService modNoteContentService;
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public String api(){
		ResponseBean rb = new ResponseBean();
		return "/note/reactCodegenTest/api";
	}
	
	/**
	 * 查询所有ModNoteList
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllModNoteList(){
		ResponseBean rb = new ResponseBean();
		List l = this.modNoteListService.queryAllModNoteList();
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
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryModNoteList(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//封装 分页 排序 查询条件到QueryBeanForWeb对象
		QueryBeanForWeb qb = new QueryBeanForWeb(request);
		this.modNoteListService.queryModNoteList(qb);
		rb.setResult(qb);
		return rb.success();
	}
	
	/**
	 * 根据ID查询ModNoteList对象
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysPersonById(@PathVariable(name="id") String entityId ){
		ResponseBean rb = new ResponseBean();
		ModNoteList u = this.modNoteListService.queryModNoteListById(entityId);
		rb.setResult(u);
		return rb.success();
	}
	
	
	
	/**
	 * 新增ModNoteList
	 * @param modNoteList ModNoteList对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveModNoteList(@RequestBody ModNoteList modNoteList){
		ModNoteList u = this.modNoteListService.saveModNoteList(modNoteList);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 更新ModNoteList
	 * @param modNoteList ModNoteList对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateModNoteList(@RequestBody ModNoteList modNoteList){
		ModNoteList u = this.modNoteListService.updateModNoteList(modNoteList);
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
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteModNoteListById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("id not be found");
		}
		if(this.modNoteListService.queryModNoteListById(id) == null){
			throw new Exception("not found ModNoteList id:[" + id + "]");
		}
		this.modNoteListService.deleteModNoteListById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	/**
	 * 根据id删除ModNoteList 多个id用","隔开
	 * @param id ModNoteList对象ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteModNoteListBatch/{ids}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteModNoteListBatch(@PathVariable String ids) throws Exception {
		
		this.modNoteListService.deleteModNoteListBatch(ids);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	
	/**
	 * 根据ID查询ModNoteContent对象
	 * @return
	 */
	@RequestMapping(value="/modNoteContent/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryModNoteContentById(@PathVariable(name="id") String entityId ){
		ResponseBean rb = new ResponseBean();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ModNoteContent u = this.modNoteListService.queryModNoteContentById(entityId);
		rb.setResult(u);
		return rb.success();
	}
	
	@RequestMapping(value="/saveModNoteContent",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveModNoteContent(@RequestBody ModNoteContent modNoteContent ){
		ResponseBean rb = new ResponseBean();
		this.modNoteContentService.saveOrUpdateModNoteContent(modNoteContent);
		rb.setResult(modNoteContent);
		return rb.success();
	}
	
	
	
}
