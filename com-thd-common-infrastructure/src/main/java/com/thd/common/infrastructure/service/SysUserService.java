package com.thd.common.infrastructure.service;

import java.util.List;
import java.util.Map;

import com.thd.common.infrastructure.pojo.SysUser;

public interface SysUserService {
	/**
	 * 查询所有用户
	 * @return
	 */
	public List queryAllSysUser();
	/**
	 * 根据ID查询用户
	 * @param id 用户ID
	 * @return SysUse对象
	 */
	public SysUser querySysUserById(String id);
	/**
	 * 根据ID删除用户
	 * @param id 用户ID
	 */
	public void deleteSysUserById(String id);
	/**
	 * 保存用户 
	 * @param user SysUser对象
	 */
	public SysUser saveSysUser(SysUser sysUser);
	/**
	 * 更新用户
	 * @param user SysUser对象
	 */
	public SysUser updateSysUser(SysUser sysUser);
	/**
	 * 新增或保存用户
	 * @param sysUser SysUser对象
	 * @return
	 */
	public SysUser saveOrUpdateSysUser(SysUser sysUser);
	/**
	 * 查询用户
	 * @param m 查询条件
	 * @return
	 */
	public List querySysUser(Map m);
}
