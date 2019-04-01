package com.thd.module.note.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.module.note.dao.ModNoteContentDao;
import com.thd.module.note.pojo.ModNoteContent;
import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyStringUtils;
import com.thd.utils.myutils.bean.QueryBean;

@Service
@Transactional
public class ModNoteContentServiceImpl implements ModNoteContentService {
	@Autowired
	private ModNoteContentDao modNoteContentDao;
	@Autowired
	private JdbcDao jdbcDao;
	
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
	public void deleteModNoteContentBatch(String ids){
		if(MyStringUtils.isEmpty(ids)){
			throw new RuntimeException("ids not be found");
		}
		String[] idsArray = ids.split(",");
		for(int i = 0 , j = idsArray.length ; i < j ; i++){
			String id = idsArray[i];
			if(MyStringUtils.isNotEmpty(id)){
				if(this.queryModNoteContentById(id) == null){
					throw new RuntimeException("not found ModNoteContent id:[" + id + "]");
				}
				this.deleteModNoteContentById(id);
			}
		}
		
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
		
			//0 记事内容
			  " t.NOTE_CONTENT as NOTE_CONTENT "
			  + 
			
			" from MOD_NOTE_CONTENT t  where 1=1 ";
		
		
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("NOTE_ID"))){
			sql += " and t.NOTE_ID like ? ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("NOTE_ID").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("NOTE_CONTENT"))){
			sql += " and upper(t.NOTE_CONTENT) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("NOTE_CONTENT").toString().trim() + "%");
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
}
