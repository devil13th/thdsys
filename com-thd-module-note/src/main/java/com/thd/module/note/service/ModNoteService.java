package com.thd.module.note.service;

import java.util.List;

import com.thd.module.note.pojo.ModNoteClassify;
import com.thd.module.note.pojo.ModNoteContent;
import com.thd.module.note.pojo.ModNoteList;
import com.thd.utils.myutils.bean.QueryBean;
import com.thd.utils.myutils.bean.TreeNodeForAntd;

public interface ModNoteService {
	// ----------------------------- mod_note_content ------------------------- //
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
	
	// ----------------------------- mod_note_list ------------------------- //
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
	
	
	
	// ----------------------------- mod_note_classify ------------------------- //
	
	
	/**
	 * 查询所有 记事分类
	 * @return
	 */
	public List queryAllModNoteClassify();
	/**
	 * 根据ID查询记事分类
	 * @param id 记事分类ID
	 * @return ModNoteClassify对象
	 */
	public ModNoteClassify queryModNoteClassifyById(java.lang.String id);
	/**
	 * 根据ID删除记事分类
	 * @param id 记事分类ID
	 */
	public void deleteModNoteClassifyById(java.lang.String id);
	/**
	 * 保存记事分类
	 * @param modNoteClassify ModNoteClassify对象
	 */
	public ModNoteClassify saveModNoteClassify(ModNoteClassify modNoteClassify);
	/**
	 * 更新记事分类
	 * @param modNoteClassify ModNoteClassify对象
	 */
	public ModNoteClassify updateModNoteClassify(ModNoteClassify modNoteClassify);
	/**
	 * 新增或保存记事分类
	 * @param modNoteClassify ModNoteClassify对象
	 * @return
	 */
	public ModNoteClassify saveOrUpdateModNoteClassify(ModNoteClassify modNoteClassify);
	/**
	 * 通用查询
	 * @param modNoteClassify ModNoteClassify对象
	 * @return
	 */
	public void queryModNoteClassify(QueryBean qb);
	
	
	//-------------------------------- 树形目录相关内容------------------------
	
	
	/**
	 * 根据树形代码获取下级子节点
	 * @param code 树形代码
	 * @return 子节点集合
	 */
	public List queryNextNodes(String code);
	
	/**
	 * 根据树形代码查询节点对象
	 * @param code 树形代码
	 * @return 节点对象
	 */
	public ModNoteClassify queryNodeByCode(String code);
	
	/**
	 * 查询最大属性代码的子节点
	 * @param code 树形代码
	 * @return 子节点中最大的属性代码
	 */
	public String queryMaxTreeCode(String code);
	
	/**
	 * 根据树形代码生成子节点代码
	 * @param code 树形代码
	 * @return 子节点代码
	 */
	public String makeChildCode(String code);
	/**
	 * 保存节点对象
	 * @return
	 */
	public void saveNode(ModNoteClassify modNoteClassify);
	/**
	 * 查询根节点
	 * @return
	 */
	public List queryRoot();
}
