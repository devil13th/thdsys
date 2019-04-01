package  com.thd.module.note.service;

import java.util.List;
import java.util.Map;

import com.thd.module.note.pojo.ModNoteContent;
import com.thd.module.note.pojo.ModNoteList;
import com.thd.utils.myutils.bean.QueryBean;

public interface ModNoteListService {
	/**
	 * 查询所有 记事
	 * @return
	 */
	public List queryAllModNoteList();
	/**
	 * 根据ID查询记事
	 * @param id 记事ID
	 * @return ModNoteList对象
	 */
	public ModNoteList queryModNoteListById(java.lang.String id);
	/**
	 * 根据ID删除记事
	 * @param id 记事ID
	 */
	public void deleteModNoteListById(java.lang.String id);
	/**
	 * 根据ID删除记事,多个id用","隔开
	 * @param ids
	 */
	public void deleteModNoteListBatch(String ids);
	/**
	 * 保存记事
	 * @param modNoteList ModNoteList对象
	 */
	public ModNoteList saveModNoteList(ModNoteList modNoteList);
	/**
	 * 更新记事
	 * @param modNoteList ModNoteList对象
	 */
	public ModNoteList updateModNoteList(ModNoteList modNoteList);
	/**
	 * 新增或保存记事
	 * @param modNoteList ModNoteList对象
	 * @return
	 */
	public ModNoteList saveOrUpdateModNoteList(ModNoteList modNoteList);
	/**
	 * 通用查询
	 * @param modNoteList ModNoteList对象
	 * @return
	 */
	public void queryModNoteList(QueryBean qb);
	
	/**
	 * 根据ID查询记事内容
	 * @param id 记事内容ID
	 * @return ModNoteContent对象
	 */
	public ModNoteContent queryModNoteContentById(java.lang.String id);
	
}
