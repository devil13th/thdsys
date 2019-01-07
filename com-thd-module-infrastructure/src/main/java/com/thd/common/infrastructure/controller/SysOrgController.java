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

import com.thd.common.infrastructure.dao.SysOrgDao;
import com.thd.common.infrastructure.pojo.SysOrg;
import com.thd.common.infrastructure.service.SysOrgService;
import com.thd.core.bean.ResponseBean;


@Controller
@RequestMapping(value="/infrastructure/sysOrg")
public class SysOrgController {
	
	@Autowired
	private SysOrgService sysOrgService;
	@Autowired
	private SysOrgDao sysOrgDao;
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public String api(){
		ResponseBean rb = new ResponseBean();
		return "/infrastructure/sysorg/api";
	}
	
	/**
	 * 查询所有SysOrg
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAllSysOrg(){
		ResponseBean rb = new ResponseBean();
		List l = this.sysOrgService.queryAllSysOrg();
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 查询所有SysOrg
	 * @return
	 */
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysOrg(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//List l = sysOrgDao.findAll();
		Map m = new HashMap();
		if(request.getParameter("orgName") != null){
			m.put("orgName", request.getParameter("orgName"));
		}
		List l = this.sysOrgService.querySysOrg(m);
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 根据ID查询SysOrg对象
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysPersonById(@PathVariable(name="id") String userId ){
		ResponseBean rb = new ResponseBean();
		SysOrg u = this.sysOrgService.querySysOrgById(userId);
		rb.setResult(u);
		return rb.success();
	}
	
	/**
	 * 根据id删除组织机构
	 * @param id 组织机构ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseBean> deleteSysOrgById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("id not be found");
		}
		if(this.sysOrgService.querySysOrgById(id) == null){
			throw new Exception("not found SysOrg id:[" + id + "]");
		}
		this.sysOrgService.deleteSysOrgById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	/**
	 * 新增组织机构
	 * @param sysOrg SysOrg对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> saveSysOrg(@RequestBody SysOrg sysOrg){
		SysOrg u = this.sysOrgService.saveSysOrg(sysOrg);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 更新组织机构
	 * @param sysOrg SysOrg对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateSysOrg(@RequestBody SysOrg sysOrg){
		SysOrg u = this.sysOrgService.updateSysOrg(sysOrg);
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 查询所有组织机构
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/queryOrgForSelect",method=RequestMethod.GET)
	public ResponseEntity<ResponseBean> queryOrgForSelect(HttpServletRequest request,String orgName){
		ResponseBean rb = new ResponseBean();
		Map m = new HashMap();
		m.put("orgName", orgName);
		List l = this.sysOrgService.querySysOrg(m);
		rb.setResult(l);	
		return rb.success();	
	};
	
}
