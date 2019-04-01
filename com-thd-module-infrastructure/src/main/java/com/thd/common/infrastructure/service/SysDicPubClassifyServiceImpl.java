package com.thd.common.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.common.infrastructure.dao.SysDicPubClassifyDao;
import com.thd.common.infrastructure.pojo.SysDicPubClassify;
import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyStringUtils;
import com.thd.utils.myutils.bean.QueryBean;

@Service
@Transactional
public class SysDicPubClassifyServiceImpl implements SysDicPubClassifyService {
	@Autowired
	private SysDicPubClassifyDao sysDicPubClassifyDao;
	@Autowired
	private JdbcDao jdbcDao;
	
	public List queryAllSysDicPubClassify(){
		return sysDicPubClassifyDao.findAll();
	};
	public SysDicPubClassify querySysDicPubClassifyById(String id) {
		
		Optional<SysDicPubClassify> r = sysDicPubClassifyDao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
		//此方法是懒加载
		//return sysDicPubClassifyDao.getOne(id);
	}
	public void deleteSysDicPubClassifyById(String id){
		this.sysDicPubClassifyDao.deleteById(id);
	};
	public void deleteSysDicPubClassifyBatch(String ids){
		if(MyStringUtils.isEmpty(ids)){
			throw new RuntimeException("ids not be found");
		}
		String[] idsArray = ids.split(",");
		for(int i = 0 , j = idsArray.length ; i < j ; i++){
			String id = idsArray[i];
			if(MyStringUtils.isNotEmpty(id)){
				if(this.querySysDicPubClassifyById(id) == null){
					throw new RuntimeException("not found SysDicPubClassify id:[" + id + "]");
				}
				this.deleteSysDicPubClassifyById(id);
			}
		}
		
	};
	public SysDicPubClassify saveSysDicPubClassify(SysDicPubClassify sysDicPubClassify){
		if(sysDicPubClassify == null){
			throw new RuntimeException("SysDicPubClassify can not be null" );
		}
		return this.sysDicPubClassifyDao.save(sysDicPubClassify);
	};
	public SysDicPubClassify updateSysDicPubClassify(SysDicPubClassify sysDicPubClassify){
		if(sysDicPubClassify == null){
			throw new RuntimeException("SysDicPubClassify can not be null" );
		}
		if(MyStringUtils.isEmpty(sysDicPubClassify.getClassifyId())){
			throw new RuntimeException("SysDicPubClassify's id can not be null" );
		}
		SysDicPubClassify u = this.querySysDicPubClassifyById(sysDicPubClassify.getClassifyId());
		if(u != null){
			return this.sysDicPubClassifyDao.saveAndFlush(sysDicPubClassify);
		}else{
			throw new RuntimeException("SysDicPubClassify not be found id:[" + sysDicPubClassify.getClassifyId() + "]");
		}
		
	}
	public SysDicPubClassify saveOrUpdateSysDicPubClassify(SysDicPubClassify sysDicPubClassify){
		return this.sysDicPubClassifyDao.saveAndFlush(sysDicPubClassify);
	}
	
	
	public void querySysDicPubClassify(QueryBean qb){
		String sql = "select "+
			" t.CLASSIFY_ID as CLASSIFY_ID, " + //0  主键 
			" t.CLASSIFY_NAME as CLASSIFY_NAME, " + //0 分类名称 			
			" t.CLASSIFY_DESC as CLASSIFY_DESC, " + //1 分类备注 			
			" t.CRE_TIME as CRE_TIME, " + //2 创建时间 			
			" t.CRE_USER as CRE_USER, " + //3 创建人 			
			" t.MOD_TIME as MOD_TIME, " + //4 修改时间 			
			" t.MOD_USER as MOD_USER " + //5 修改人 			
			
			" from SYS_DIC_PUB_CLASSIFY t  where 1=1 ";
		
		
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CLASSIFY_ID"))){
			sql += " and t.CLASSIFY_ID like ? ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CLASSIFY_ID").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CLASSIFY_NAME"))){
			sql += " and upper(t.CLASSIFY_NAME) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CLASSIFY_NAME").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CLASSIFY_DESC"))){
			sql += " and upper(t.CLASSIFY_DESC) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("CLASSIFY_DESC").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CRE_TIME"))){
			sql += " and t.CRE_TIME = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("CRE_TIME").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("CRE_USER"))){
			sql += " and t.CRE_USER = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("CRE_USER").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("MOD_TIME"))){
			sql += " and t.MOD_TIME = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("MOD_TIME").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("MOD_USER"))){
			sql += " and t.MOD_USER = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("MOD_USER").toString().trim());
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
