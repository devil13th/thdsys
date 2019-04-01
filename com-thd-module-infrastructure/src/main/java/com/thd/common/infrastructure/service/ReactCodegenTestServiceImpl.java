package com.thd.common.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.common.infrastructure.dao.ReactCodegenTestDao;
import com.thd.common.infrastructure.pojo.ReactCodegenTest;
import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyStringUtils;
import com.thd.utils.myutils.bean.QueryBean;

@Service
@Transactional
public class ReactCodegenTestServiceImpl implements ReactCodegenTestService {
	@Autowired
	private ReactCodegenTestDao reactCodegenTestDao;
	@Autowired
	private JdbcDao jdbcDao;
	
	public List queryAllReactCodegenTest(){
		return reactCodegenTestDao.findAll();
	};
	public ReactCodegenTest queryReactCodegenTestById(String id) {
		
		Optional<ReactCodegenTest> r = reactCodegenTestDao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
		//此方法是懒加载
		//return reactCodegenTestDao.getOne(id);
	}
	public void deleteReactCodegenTestById(String id){
		this.reactCodegenTestDao.deleteById(id);
	};
	public void deleteReactCodegenTestBatch(String ids){
		if(MyStringUtils.isEmpty(ids)){
			throw new RuntimeException("ids not be found");
		}
		String[] idsArray = ids.split(",");
		for(int i = 0 , j = idsArray.length ; i < j ; i++){
			String id = idsArray[i];
			if(MyStringUtils.isNotEmpty(id)){
				if(this.queryReactCodegenTestById(id) == null){
					throw new RuntimeException("not found ReactCodegenTest id:[" + id + "]");
				}
				this.deleteReactCodegenTestById(id);
			}
		}
		
	};
	public ReactCodegenTest saveReactCodegenTest(ReactCodegenTest reactCodegenTest){
		if(reactCodegenTest == null){
			throw new RuntimeException("ReactCodegenTest can not be null" );
		}
		return this.reactCodegenTestDao.save(reactCodegenTest);
	};
	public ReactCodegenTest updateReactCodegenTest(ReactCodegenTest reactCodegenTest){
		if(reactCodegenTest == null){
			throw new RuntimeException("ReactCodegenTest can not be null" );
		}
		if(MyStringUtils.isEmpty(reactCodegenTest.getTestId())){
			throw new RuntimeException("ReactCodegenTest's id can not be null" );
		}
		ReactCodegenTest u = this.queryReactCodegenTestById(reactCodegenTest.getTestId());
		if(u != null){
			return this.reactCodegenTestDao.saveAndFlush(reactCodegenTest);
		}else{
			throw new RuntimeException("ReactCodegenTest not be found id:[" + reactCodegenTest.getTestId() + "]");
		}
		
	}
	public ReactCodegenTest saveOrUpdateReactCodegenTest(ReactCodegenTest reactCodegenTest){
		return this.reactCodegenTestDao.saveAndFlush(reactCodegenTest);
	}
	
	
	public void queryReactCodegenTest(QueryBean qb){
		String sql = "select "+
				" t.TEST_ID as TEST_ID, " + //0  assigned主键 
			
				//0 字符串
				  " t.TEST_NAME as TEST_NAME "
				+","  + 
				//1 整数
				  " t.TEST_INT as TEST_INT "
				+","  + 
				//2 浮点
				  " t.TEST_FLOAT as TEST_FLOAT "
				+","  + 
				//3 数值
				  " t.TEST_DECIMAL as TEST_DECIMAL "
				+","  + 
				//4 日期
				  " date_format(t.TEST_DATE,'%Y-%m-%d') as TEST_DATE " 
				+","  + 
				//5 日期时间
				  " date_format(t.TEST_DATETIME,'%Y-%m-%d %H:%i:%S') as TEST_DATETIME "  
				  + 
				
				" from REACT_CODEGEN_TEST t  where 1=1 ";
		
		
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("TEST_ID"))){
			sql += " and t.TEST_ID like ? ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("TEST_ID").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("TEST_NAME"))){
			sql += " and upper(t.TEST_NAME) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("TEST_NAME").toString().trim() + "%");
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("TEST_INT"))){
			sql += " and t.TEST_INT = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("TEST_INT").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("TEST_FLOAT"))){
			sql += " and t.TEST_FLOAT = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("TEST_FLOAT").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("TEST_DECIMAL"))){
			sql += " and t.TEST_DECIMAL = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("TEST_DECIMAL").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("TEST_DATE"))){
			sql += " and t.TEST_DATE = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("TEST_DATE").toString().trim());
		}
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("TEST_DATETIME"))){
			sql += " and t.TEST_DATETIME = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("TEST_DATETIME").toString().trim());
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
