package  com.thd.common.infrastructure.service;

import java.util.List;
import java.util.Map;

import com.thd.common.infrastructure.pojo.SysDicPubClassify;
import com.thd.utils.myutils.bean.QueryBean;

public interface SysDicPubClassifyService {
	/**
	 * 查询所有 公共字典分类
	 * @return
	 */
	public List queryAllSysDicPubClassify();
	/**
	 * 根据ID查询公共字典分类
	 * @param id 公共字典分类ID
	 * @return SysDicPubClassify对象
	 */
	public SysDicPubClassify querySysDicPubClassifyById(java.lang.String id);
	/**
	 * 根据ID删除公共字典分类
	 * @param id 公共字典分类ID
	 */
	public void deleteSysDicPubClassifyById(java.lang.String id);
	/**
	 * 根据ID删除公共字典分类,多个id用","隔开
	 * @param ids
	 */
	public void deleteSysDicPubClassifyBatch(String ids);
	/**
	 * 保存公共字典分类
	 * @param sysDicPubClassify SysDicPubClassify对象
	 */
	public SysDicPubClassify saveSysDicPubClassify(SysDicPubClassify sysDicPubClassify);
	/**
	 * 更新公共字典分类
	 * @param sysDicPubClassify SysDicPubClassify对象
	 */
	public SysDicPubClassify updateSysDicPubClassify(SysDicPubClassify sysDicPubClassify);
	/**
	 * 新增或保存公共字典分类
	 * @param sysDicPubClassify SysDicPubClassify对象
	 * @return
	 */
	public SysDicPubClassify saveOrUpdateSysDicPubClassify(SysDicPubClassify sysDicPubClassify);
	/**
	 * 通用查询
	 * @param sysDicPubClassify SysDicPubClassify对象
	 * @return
	 */
	public void querySysDicPubClassify(QueryBean qb);
}
