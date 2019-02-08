package  com.thd.common.infrastructure.service;

import java.util.List;
import java.util.Map;

import com.thd.common.infrastructure.pojo.SysDicPub;
import com.thd.utils.myutils.bean.QueryBean;

public interface SysDicPubService {
	/**
	 * 查询字典分类
	 * @param name 字典分类名称或ID
	 * @return
	 */
	public List queryDicClassify(String name);
	/**
	 * 查询所有 公共字典
	 * @return
	 */
	public List queryAllSysDicPub();
	/**
	 * 根据ID查询公共字典
	 * @param id 公共字典ID
	 * @return SysDicPub对象
	 */
	public SysDicPub querySysDicPubById(java.lang.String id);
	/**
	 * 根据ID删除公共字典
	 * @param id 公共字典ID
	 */
	public void deleteSysDicPubById(java.lang.String id);
	/**
	 * 根据ID删除公共字典,多个id用","隔开
	 * @param ids
	 */
	public void deleteSysDicPubBatch(String ids);
	/**
	 * 保存公共字典
	 * @param sysDicPub SysDicPub对象
	 */
	public SysDicPub saveSysDicPub(SysDicPub sysDicPub);
	/**
	 * 更新公共字典
	 * @param sysDicPub SysDicPub对象
	 */
	public SysDicPub updateSysDicPub(SysDicPub sysDicPub);
	/**
	 * 新增或保存公共字典
	 * @param sysDicPub SysDicPub对象
	 * @return
	 */
	public SysDicPub saveOrUpdateSysDicPub(SysDicPub sysDicPub);
	/**
	 * 通用查询
	 * @param sysDicPub SysDicPub对象
	 * @return
	 */
	public void querySysDicPub(QueryBean qb);
	/**
	 * Map条件查询(有无排序在本方法的SQL汇总写死)
	 * @param m 查询条件
	 * @return 查询列表
	 */
	public List queryList(Map<String,String> m);
}
