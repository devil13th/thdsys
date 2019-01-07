package com.thd.common.infrastructure.service;

import java.util.List;
import java.util.Map;

import com.thd.common.infrastructure.pojo.SysOrg;

public interface SysOrgService {
	/**
	 * 查询所有组织机构
	 * @return
	 */
	public List queryAllSysOrg();
	/**
	 * 根据ID查询组织机构
	 * @param id 组织机构ID
	 * @return SysUse对象
	 */
	public SysOrg querySysOrgById(String id);
	/**
	 * 根据ID删除组织机构
	 * @param id 组织机构ID
	 */
	public void deleteSysOrgById(String id);
	/**
	 * 保存组织机构 
	 * @param user SysOrg对象
	 */
	public SysOrg saveSysOrg(SysOrg sysOrg);
	/**
	 * 更新组织机构
	 * @param user SysOrg对象
	 */
	public SysOrg updateSysOrg(SysOrg sysOrg);
	/**
	 * 新增或保存组织机构
	 * @param sysOrg SysOrg对象
	 * @return
	 */
	public SysOrg saveOrUpdateSysOrg(SysOrg sysOrg);
	/**
	 * 查询组织机构
	 * @param m 查询条件
	 * @return
	 */
	public List querySysOrg(Map m);
	
	
}
