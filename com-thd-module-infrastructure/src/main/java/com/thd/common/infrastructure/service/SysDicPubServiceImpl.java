package com.thd.common.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.thd.common.infrastructure.dao.SysDicPubDao;
import com.thd.common.infrastructure.pojo.SysDicPub;
import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyStringUtils;
import com.thd.utils.myutils.bean.QueryBean;

@Service
@Transactional
public class SysDicPubServiceImpl implements SysDicPubService {
	@Autowired
	private SysDicPubDao sysDicPubDao;
	@Autowired
	private JdbcDao jdbcDao;
	public List queryDicClassify(String name){
		String sql = "select classify_id as classify_id,"
				+ " classify_name as classify_name,"
				+ " classify_desc as classify_desc "
				+ " from sys_dic_pub_classify where 1=1 ";
		List params = new ArrayList();
		if(MyStringUtils.isNotEmpty(name)){
			sql += " and ( upper(classify_name) like (?) or upper(classify_id) like (?) )";
			params.add("%" + name.trim().toUpperCase() + "%");
			params.add("%" + name.trim().toUpperCase() + "%");
		}
		List l = this.jdbcDao.query(sql, params.toArray(), null);
		return l;
	};
	public List queryAllSysDicPub(){
		return sysDicPubDao.findAll();
	};
	public SysDicPub querySysDicPubById(String id) {
		
		Optional<SysDicPub> r = sysDicPubDao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
		//此方法是懒加载
		//return sysDicPubDao.getOne(id);
	}
	public void deleteSysDicPubById(String id){
		
		String[] ids = id.split(",");
		for(int i = 0 , j = ids.length ; i < j ; i++){
			if(MyStringUtils.isNotEmpty(ids[i])){
				this.sysDicPubDao.deleteById(ids[i]);
			}
		}
	};
	
	public void deleteSysDicPubBatch(String ids){
		if(StringUtils.isEmpty(ids)){
			throw new RuntimeException("ids not be found");
		}
		
		String[] idsArray = ids.split(",");
		for(int i = 0 , j = idsArray.length ; i < j ; i++){
			String id = idsArray[i];
			if(MyStringUtils.isNotEmpty(id)){
				if(this.querySysDicPubById(id) == null){
					throw new RuntimeException("not found SysDicPub id:[" + id + "]");
				}
				this.deleteSysDicPubById(id);
			}
		}
		
	};
	
	public SysDicPub saveSysDicPub(SysDicPub sysDicPub){
		if(sysDicPub == null){
			throw new RuntimeException("SysDicPub can not be null" );
		}
		return this.sysDicPubDao.save(sysDicPub);
	};
	public SysDicPub updateSysDicPub(SysDicPub sysDicPub){
		if(sysDicPub == null){
			throw new RuntimeException("SysDicPub can not be null" );
		}
		if(MyStringUtils.isEmpty(sysDicPub.getDicId())){
			throw new RuntimeException("SysDicPub's id can not be null" );
		}
		SysDicPub u = this.querySysDicPubById(sysDicPub.getDicId());
		if(u != null){
			return this.sysDicPubDao.saveAndFlush(sysDicPub);
		}else{
			throw new RuntimeException("SysDicPub not be found id:[" + sysDicPub.getDicId() + "]");
		}
		
	}
	public SysDicPub saveOrUpdateSysDicPub(SysDicPub sysDicPub){
		return this.sysDicPubDao.saveAndFlush(sysDicPub);
	}
	
	
	public void querySysDicPub(QueryBean qb){
		String sql = "select "+
			" t.DIC_ID as DIC_ID, " + //0  字典标识 
			" t.DIC_CLASSIFY as DIC_CLASSIFY, " + //0 字典分类 			
			" t.DIC_NAME as DIC_NAME, " + //1 字典名称 			
			" t.DIC_DESC as DIC_DESC " + //2 备注 			
			
			" from SYS_DIC_PUB t  where 1=1 ";
		
		if(qb.getQueryParams()!=null){
			if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("dicId"))){
				sql += " and t.DIC_ID like ? ";
				qb.getSqlParams().add("%" + qb.getQueryParams().get("dicId").toString().trim() + "%");
			}
			if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("dicClassify"))){
				sql += " and upper(t.DIC_CLASSIFY) like upper(?) ";
				qb.getSqlParams().add("%" + qb.getQueryParams().get("dicClassify").toString().trim() + "%");
			}
			if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("dicName"))){
				sql += " and upper(t.DIC_NAME) like upper(?) ";
				qb.getSqlParams().add("%" + qb.getQueryParams().get("dicName").toString().trim() + "%");
			}
			if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("dicDesc"))){
				sql += " and upper(t.DIC_DESC) like upper(?) ";
				qb.getSqlParams().add("%" + qb.getQueryParams().get("dicDesc").toString().trim() + "%");
			}
		}
			
		//处理分页
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
	
	
	public List queryList(Map<String,String> m){
		String sql = "select "+
				" t.DIC_ID as DIC_ID, " + //0  字典标识 
				" t.DIC_CLASSIFY as DIC_CLASSIFY, " + //0 字典分类 			
				" t.DIC_NAME as DIC_NAME, " + //1 字典名称 			
				" t.DIC_DESC as DIC_DESC " + //2 备注 			
				
				" from SYS_DIC_PUB t  where 1=1 ";
			List params = new ArrayList();
			if(m!=null){
				if(MyStringUtils.isNotEmpty(m.get("dicId"))){
					sql += " and t.DIC_ID like ? ";
					params.add("%" + m.get("dicId").toString().trim() + "%");
				}
				if(MyStringUtils.isNotEmpty(m.get("dicClassify"))){
					sql += " and upper(t.DIC_CLASSIFY) like upper(?) ";
					params.add("%" + m.get("dicClassify").toString().trim() + "%");
				}
				if(MyStringUtils.isNotEmpty(m.get("dicName"))){
					sql += " and upper(t.DIC_NAME) like upper(?) ";
					params.add("%" + m.get("dicName").toString().trim() + "%");
				}
				if(MyStringUtils.isNotEmpty(m.get("dicDesc"))){
					sql += " and upper(t.DIC_DESC) like upper(?) ";
					params.add("%" + m.get("dicDesc").toString().trim() + "%");
				}
			}
				
			return this.jdbcDao.query(sql, params.toArray(), null);
	};
}
