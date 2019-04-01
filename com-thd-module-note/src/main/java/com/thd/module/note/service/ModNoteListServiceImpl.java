package com.thd.module.note.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.module.note.dao.ModNoteContentDao;
import com.thd.module.note.dao.ModNoteListDao;
import com.thd.module.note.pojo.ModNoteContent;
import com.thd.module.note.pojo.ModNoteList;
import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyStringUtils;
import com.thd.utils.myutils.bean.QueryBean;

@Service
@Transactional
public class ModNoteListServiceImpl implements ModNoteListService {
	@Autowired
	private ModNoteListDao modNoteListDao;
	@Autowired
	private ModNoteContentDao modNoteContentDao;
	@Autowired
	private JdbcDao jdbcDao;
	
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
	public void deleteModNoteListBatch(String ids){
		if(MyStringUtils.isEmpty(ids)){
			throw new RuntimeException("ids not be found");
		}
		String[] idsArray = ids.split(",");
		for(int i = 0 , j = idsArray.length ; i < j ; i++){
			String id = idsArray[i];
			if(MyStringUtils.isNotEmpty(id)){
				if(this.queryModNoteListById(id) == null){
					throw new RuntimeException("not found ModNoteList id:[" + id + "]");
				}
				this.deleteModNoteListById(id);
			}
		}
		
	};
	public ModNoteList saveModNoteList(ModNoteList modNoteList){
		if(modNoteList == null){
			throw new RuntimeException("ModNoteList can not be null" );
		}
		this.modNoteListDao.save(modNoteList);
		
		ModNoteContent modNoteContent = new ModNoteContent();
		
		modNoteContent.setNoteId(modNoteList.getNoteId());
		this.modNoteContentDao.save(modNoteContent);
		
		return modNoteList;
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
			" t.NOTE_ID as NOTE_ID, " + //0  主键 
		
			//0 标题
			  " t.NOTE_TITLE as NOTE_TITLE "
			+","  + 
			//1 概述
			  " t.NOTE_DESC as NOTE_DESC "
			+","  + 
			//2 分类
			  " t.NOTE_CLASSIFY as NOTE_CLASSIFY "
			+","  + 
			//3 是否删除
			  " t.IS_DELETE as IS_DELETE "
			+","  + 
			//4 到期日期
			  " date_format(t.EXPIRE_DATE,'%Y-%m-%d') as EXPIRE_DATE " 
			+","  + 
			//5 预警天数
			  " t.ALARM_DAYS as ALARM_DAYS "
			+","  + 
			//6 创建时间
			  " date_format(t.CRE_TIME,'%Y-%m-%d %H:%i:%S') as CRE_TIME " 
			+","  + 
			//7 创建人
			  " t.CRE_USER as CRE_USER "
			+","  + 
			//8 修改时间
			  " date_format(t.MOD_TIME,'%Y-%m-%d %H:%i:%S') as MOD_TIME " 
			+","  + 
			//9 修改人
			  " t.MOD_USER as MOD_USER "
			  + 
			
			" from MOD_NOTE_LIST t  where 1=1 ";
		
		
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
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("KEYWORLD"))){
			sql += " and (t.NOTE_TITLE like ? or t.NOTE_DESC like ? )";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("KEYWORLD").toString().trim() + "%");
			qb.getSqlParams().add("%" + qb.getQueryParams().get("KEYWORLD").toString().trim() + "%");
		}
			
		
		//处理和排序分页
		if(qb.getSortColumn() != null){
			String sortColumn = qb.getSortColumn().toString();
			if(MyStringUtils.isNotEmpty(sortColumn)){
				if(!sortColumn.toUpperCase().equals("undefined".toUpperCase())){
					sql += " order by " + sortColumn;
					
					if(qb.getSortOrder() != null){
						String sortOrder = qb.getSortOrder().toString();
						if(MyStringUtils.isNotEmpty(sortOrder)){
							
							if(sortOrder.toUpperCase().equals("descend".toUpperCase())){
								sql += " desc " ;
							}else{
								sql += " asc " ;
							}		
						}
					}
				}
			}
		}
		
		
		
		qb.setSql(sql);
		
		this.jdbcDao.query(qb);
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
}
