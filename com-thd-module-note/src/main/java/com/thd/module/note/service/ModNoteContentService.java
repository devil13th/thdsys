package  com.thd.module.note.service;

import java.util.List;
import java.util.Map;

import com.thd.module.note.pojo.ModNoteContent;
import com.thd.utils.myutils.bean.QueryBean;

public interface ModNoteContentService {
	/**
	 * 查询所有 记事内容
	 * @return
	 */
	public List queryAllModNoteContent();
	/**
	 * 根据ID查询记事内容
	 * @param id 记事内容ID
	 * @return ModNoteContent对象
	 */
	public ModNoteContent queryModNoteContentById(java.lang.String id);
	/**
	 * 根据ID删除记事内容
	 * @param id 记事内容ID
	 */
	public void deleteModNoteContentById(java.lang.String id);
	/**
	 * 根据ID删除记事内容,多个id用","隔开
	 * @param ids
	 */
	public void deleteModNoteContentBatch(String ids);
	/**
	 * 保存记事内容
	 * @param modNoteContent ModNoteContent对象
	 */
	public ModNoteContent saveModNoteContent(ModNoteContent modNoteContent);
	/**
	 * 更新记事内容
	 * @param modNoteContent ModNoteContent对象
	 */
	public ModNoteContent updateModNoteContent(ModNoteContent modNoteContent);
	/**
	 * 新增或保存记事内容
	 * @param modNoteContent ModNoteContent对象
	 * @return
	 */
	public ModNoteContent saveOrUpdateModNoteContent(ModNoteContent modNoteContent);
	/**
	 * 通用查询
	 * @param modNoteContent ModNoteContent对象
	 * @return
	 */
	public void queryModNoteContent(QueryBean qb);
}
