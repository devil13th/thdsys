package com.thd.module.note.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.core.dao.JdbcDao;
import com.thd.module.note.dao.ModNoteClassifyDao;
import com.thd.module.note.dao.ModNoteContentDao;
import com.thd.module.note.dao.ModNoteListDao;
import com.thd.module.note.pojo.ModNoteClassify;
import com.thd.module.note.pojo.ModNoteContent;
import com.thd.module.note.pojo.ModNoteList;
import com.thd.utils.myutils.MyListUtils;
import com.thd.utils.myutils.MyStringUtils;
import com.thd.utils.myutils.bean.QueryBean;
import com.thd.utils.myutils.bean.StaticVar;
@Service
@Transactional
public class ModNoteServiceImpl implements ModNoteService {
	@Autowired
	private ModNoteClassifyDao modNoteClassifyDao;
	@Autowired
	private ModNoteListDao modNoteListDao;
	@Autowired
	private ModNoteContentDao modNoteContentDao;
	
	
	@Autowired
	private JdbcDao jdbcDao;
	// ----------------------------- mod_note_content ------------------------- //
	public List queryAllModNoteContent(){
		return modNoteContentDao.findAll();
	};
	public ModNoteContent queryModNoteContentById(String id) {
		
		Optional<ModNoteContent> r = modNoteContentDao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
		//此方法是懒加载
		//return modNoteContentDao.getOne(id);
	}
	public void deleteModNoteContentById(String id){
		this.modNoteContentDao.deleteById(id);
	};
	public ModNoteContent saveModNoteContent(ModNoteContent modNoteContent){
		if(modNoteContent == null){
			throw new RuntimeException("ModNoteContent can not be null" );
		}
		return this.modNoteContentDao.save(modNoteContent);
	};
	public ModNoteContent updateModNoteContent(ModNoteContent modNoteContent){
		if(modNoteContent == null){
			throw new RuntimeException("ModNoteContent can not be null" );
		}
		if(MyStringUtils.isEmpty(modNoteContent.getNoteId())){
			throw new RuntimeException("ModNoteContent's id can not be null" );
		}
		ModNoteContent u = this.queryModNoteContentById(modNoteContent.getNoteId());
		if(u != null){
			return this.modNoteContentDao.saveAndFlush(modNoteContent);
		}else{
			throw new RuntimeException("ModNoteContent not be found id:[" + modNoteContent.getNoteId() + "]");
		}
		
	}
	public ModNoteContent saveOrUpdateModNoteContent(ModNoteContent modNoteContent){
		return this.modNoteContentDao.saveAndFlush(modNoteContent);
	}
	
	
	public void queryModNoteContent(QueryBean qb){
		String sql = "select "+
			" t.NOTE_ID as NOTE_ID, " + //0  主键 
			" t.NOTE_CONTENT as NOTE_CONTENT " + //0 记事内容 			
			
			" from MOD_NOTE_CONTENT t  where 1=1 ";
		
		
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("NOTE_ID"))){
			sql += " and t.NOTE_ID like ? ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("NOTE_ID").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("NOTE_CONTENT"))){
			sql += " and upper(t.NOTE_CONTENT) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("NOTE_CONTENT").toString().trim() + "%");
		}
			
		
		
		
		qb.setSql(sql);
		
		this.jdbcDao.query(qb);
	};
	// ----------------------------- mod_note_list ------------------------- //
	public List queryAllModNoteList(){
		return modNoteListDao.findAll();
	};
	public ModNoteList queryModNoteListById(String id) {
		
		Optional<ModNoteList> r = modNoteListDao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
		//此方法是懒加载
		//return modNoteListDao.getOne(id);
	}
	public void deleteModNoteListById(String id){
		this.modNoteListDao.deleteById(id);
	};
	public ModNoteList saveModNoteList(ModNoteList modNoteList){
		if(modNoteList == null){
			throw new RuntimeException("ModNoteList can not be null" );
		}
		return this.modNoteListDao.save(modNoteList);
	};
	public ModNoteList updateModNoteList(ModNoteList modNoteList){
		if(modNoteList == null){
			throw new RuntimeException("ModNoteList can not be null" );
		}
		if(MyStringUtils.isEmpty(modNoteList.getNoteId())){
			throw new RuntimeException("ModNoteList's id can not be null" );
		}
		ModNoteList u = this.queryModNoteListById(modNoteList.getNoteId());
		if(u != null){
			return this.modNoteListDao.saveAndFlush(modNoteList);
		}else{
			throw new RuntimeException("ModNoteList not be found id:[" + modNoteList.getNoteId() + "]");
		}
		
	}
	public ModNoteList saveOrUpdateModNoteList(ModNoteList modNoteList){
		return this.modNoteListDao.saveAndFlush(modNoteList);
	}
	
	
	public void queryModNoteList(QueryBean qb){
		String sql = "select "+
			" t.NOTE_ID as NOTE_ID, " + //0   
			" t.NOTE_TITLE as NOTE_TITLE, " + //0  			
			" t.NOTE_DESC as NOTE_DESC, " + //1  			
			" c.CLASSIFY_NAME as CLASSIFY_NAME, " + //2
			" t.IS_DELETE as IS_DELETE, " + //3  			
			" date_format(t.EXPIRE_DATE,'%Y-%m-%d') as EXPIRE_DATE, " + //4  			
			" t.ALARM_DAYS as ALARM_DAYS, " + //5  			
			" date_format(t.CRE_TIME,'%Y-%m-%d %H:%i:%s') as CRE_TIME, " + //6  			
			" t.CRE_USER as CRE_USER, " + //7  			
			" date_format(t.MOD_TIME,'%Y-%m-%d %H:%i:%s') as MOD_TIME, " + //8  			
			" t.MOD_USER as MOD_USER " + //9  			
			


			" from MOD_NOTE_LIST t  "+ 
			" left join MOD_NOTE_CLASSIFY c on t.NOTE_CLASSIFY = c.CLASSIFY_ID where 1=1 ";
		
		
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("NOTE_ID"))){
			sql += " and t.NOTE_ID like ? ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("NOTE_ID").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("NOTE_TITLE"))){
			sql += " and upper(t.NOTE_TITLE) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("NOTE_TITLE").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("NOTE_DESC"))){
			sql += " and upper(t.NOTE_DESC) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("NOTE_DESC").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("NOTE_CLASSIFY"))){
			sql += " and upper(t.NOTE_CLASSIFY) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("NOTE_CLASSIFY").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("IS_DELETE"))){
			sql += " and upper(t.IS_DELETE) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("IS_DELETE").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("EXPIRE_DATE"))){
			sql += " and t.EXPIRE_DATE = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("EXPIRE_DATE").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("ALARM_DAYS"))){
			sql += " and t.ALARM_DAYS = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("ALARM_DAYS").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CRE_TIME"))){
			sql += " and t.CRE_TIME = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("CRE_TIME").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CRE_USER"))){
			sql += " and upper(t.CRE_USER) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CRE_USER").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("MOD_TIME"))){
			sql += " and t.MOD_TIME = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("MOD_TIME").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("MOD_USER"))){
			sql += " and upper(t.MOD_USER) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("MOD_USER").toString().trim() + "%");
		}
			
		
		if(MyStringUtils.isNotEmpty(qb.getSortColumn())){
			sql += "order by " + qb.getSortColumn() + " ";
			
			String order = "desc";
			String sortOrder = qb.getSortOrder();
			if(MyStringUtils.isNotEmpty(sortOrder)){
				if(sortOrder.toUpperCase().equals("DESCEND")){
					sql += " desc ";
				}else{
					sql += " asc ";
				}
			}
		}
		
		qb.setSql(sql);
		
		this.jdbcDao.query(qb);
	};
	
	
	// ----------------------------- mod_note_classify ------------------------- //
	
	public List queryAllModNoteClassify(){
		return modNoteClassifyDao.findAll();
	};
	public ModNoteClassify queryModNoteClassifyById(String id) {
		
		Optional<ModNoteClassify> r = modNoteClassifyDao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
		//此方法是懒加载
		//return modNoteClassifyDao.getOne(id);
	}
	public void deleteModNoteClassifyById(String id){
		this.modNoteClassifyDao.deleteById(id);
	};
	public ModNoteClassify saveModNoteClassify(ModNoteClassify modNoteClassify){
		if(modNoteClassify == null){
			throw new RuntimeException("ModNoteClassify can not be null" );
		}
		return this.modNoteClassifyDao.save(modNoteClassify);
	};
	public ModNoteClassify updateModNoteClassify(ModNoteClassify modNoteClassify){
		if(modNoteClassify == null){
			throw new RuntimeException("ModNoteClassify can not be null" );
		}
		if(MyStringUtils.isEmpty(modNoteClassify.getClassifyId())){
			throw new RuntimeException("ModNoteClassify's id can not be null" );
		}
		ModNoteClassify u = this.queryModNoteClassifyById(modNoteClassify.getClassifyId());
		if(u != null){
			return this.modNoteClassifyDao.saveAndFlush(modNoteClassify);
		}else{
			throw new RuntimeException("ModNoteClassify not be found id:[" + modNoteClassify.getClassifyId() + "]");
		}
		
	}
	public ModNoteClassify saveOrUpdateModNoteClassify(ModNoteClassify modNoteClassify){
		return this.modNoteClassifyDao.saveAndFlush(modNoteClassify);
	}
	
	
	public void queryModNoteClassify(QueryBean qb){
		String sql = "select "+
			" t.CLASSIFY_ID as CLASSIFY_ID, " + //0  分类标识 
			" t.CLASSIFY_NAME as CLASSIFY_NAME, " + //0 名称 			
			" t.CLASSIFY_TREE_CODE as CLASSIFY_TREE_CODE, " + //1 树码 			
			" t.CLASSIFY_SORT as CLASSIFY_SORT, " + //2 排序号 			
			" t.CLASSIFY_MEMO as CLASSIFY_MEMO, " + //3 备注 			
			" t.IS_LEAF as IS_LEAF, " + //4 是否叶子节点 1是 0否 			
			" t.IS_DELETE as IS_DELETE, " + //5 是否删除 1否 0是 			
			" t.CRE_TIME as CRE_TIME, " + //6 创建时间 			
			" t.CRE_USER as CRE_USER, " + //7 创建人 			
			" t.MOD_TIME as MOD_TIME, " + //8 修改时间 			
			" t.MOD_USER as MOD_USER " + //9 修改人 			
			
			" from MOD_NOTE_CLASSIFY t  where 1=1 ";
		
		
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CLASSIFY_ID"))){
			sql += " and t.CLASSIFY_ID like ? ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CLASSIFY_ID").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CLASSIFY_NAME"))){
			sql += " and upper(t.CLASSIFY_NAME) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CLASSIFY_NAME").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CLASSIFY_TREE_CODE"))){
			sql += " and upper(t.CLASSIFY_TREE_CODE) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CLASSIFY_TREE_CODE").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CLASSIFY_SORT"))){
			sql += " and upper(t.CLASSIFY_SORT) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CLASSIFY_SORT").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CLASSIFY_MEMO"))){
			sql += " and upper(t.CLASSIFY_MEMO) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CLASSIFY_MEMO").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("IS_LEAF"))){
			sql += " and upper(t.IS_LEAF) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("IS_LEAF").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("IS_DELETE"))){
			sql += " and upper(t.IS_DELETE) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("IS_DELETE").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CRE_TIME"))){
			sql += " and t.CRE_TIME = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("CRE_TIME").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CRE_USER"))){
			sql += " and upper(t.CRE_USER) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CRE_USER").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("MOD_TIME"))){
			sql += " and t.MOD_TIME = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("MOD_TIME").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("MOD_USER"))){
			sql += " and upper(t.MOD_USER) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("MOD_USER").toString().trim() + "%");
		}
			
		
		
		
		qb.setSql(sql);
		
		this.jdbcDao.query(qb);
	}
	
	
	
	
	
	
	@Override
	public List queryNextNodes(String code) {
		String sql = "select " +
				" t.CLASSIFY_ID as CLASSIFY_ID, " + //0  分类标识 
				" t.CLASSIFY_NAME as CLASSIFY_NAME, " + //0 名称 			
				" t.CLASSIFY_TREE_CODE as CLASSIFY_TREE_CODE, " + //1 树码 			
				" t.CLASSIFY_SORT as CLASSIFY_SORT, " + //2 排序号 			
				" t.CLASSIFY_MEMO as CLASSIFY_MEMO, " + //3 备注 			
				" t.IS_LEAF as IS_LEAF, " + //4 是否叶子节点 1是 0否 			
				" t.IS_DELETE as IS_DELETE, " + //5 是否删除 1否 0是 			
				" t.CRE_TIME as CRE_TIME, " + //6 创建时间 			
				" t.CRE_USER as CRE_USER, " + //7 创建人 			
				" t.MOD_TIME as MOD_TIME, " + //8 修改时间 			
				" t.MOD_USER as MOD_USER " + //9 修改人
				" from MOD_NOTE_CLASSIFY t  where is_delete = '" + StaticVar.ISDELETE_UNDELETED+ "' ";
		sql += " and t.CLASSIFY_TREE_CODE like '" + code + ".%' and t.CLASSIFY_TREE_CODE not like '" + code + ".%.%'";
		return this.jdbcDao.query(sql);
	}
	@Override
	public ModNoteClassify queryNodeByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String queryMaxTreeCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String makeChildCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void saveNode(ModNoteClassify modNoteClassify) {
		// TODO Auto-generated method stub
		
	};
	
	public List queryRoot(){
		String sql = " select "
				+ " CLASSIFY_ID as CLASSIFY_ID,"
				+ " CLASSIFY_NAME as CLASSIFY_NAME, "
				+ " IS_LEAF as IS_LEAF "
				+ " from mod_note_classify t "
				+ " where classify_tree_code = 'root' ";
		List l = this.jdbcDao.query(sql);
		return l;
	};

}
