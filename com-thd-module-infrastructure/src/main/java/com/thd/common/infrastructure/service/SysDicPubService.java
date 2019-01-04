package com.thd.common.infrastructure.service;

import java.util.List;
import java.util.Map;

import com.thd.common.infrastructure.pojo.SysDicPub;
import com.thd.common.infrastructure.pojo.SysUser;

public interface SysDicPubService {
	/**
	 * 查询所有公共字典
	 * @return
	 */
	public List queryAllSysDicPub();
	/**
	 * 根据ID查询公共字典
	 * @param id 公共字典ID
	 * @return SysUse对象
	 */
	public SysDicPub querySysDicPubById(String id);
	/**
	 * 根据ID删除公共字典
	 * @param id 用户ID
	 */
	public void deleteSysDicPubById(String id);
	/**
	 * 保存公共字典
	 * @param user SysUser对象
	 */
	public SysDicPub saveSysDicPub(SysDicPub sysDicPub);
	/**
	 * 更新公共字典
	 * @param user SysUser对象
	 */
	public SysDicPub updateSysDicPub(SysDicPub sysDicPub);
	/**
	 * 新增或保存公共字典
	 * @param sysDicPub SysDicPub对象
	 * @return
	 */
	public SysDicPub saveOrUpdateSysDicPub(SysDicPub sysDicPub);
	/**
	 * 查询用户
	 * @param m 查询条件
	 * @return
	 */
	public List querySysDicPub(Map m);
}
