package ${cfg.servicePackage};

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${cfg.daoPackage}.${cfg.tableCodeForClass}Dao;
import ${cfg.pojoPackage}.${cfg.tableCodeForClass};
import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyStringUtils;
import com.thd.utils.myutils.bean.QueryBean;

@Service
@Transactional
public class ${cfg.tableCodeForClass}ServiceImpl implements ${cfg.tableCodeForClass}Service {
	@Autowired
	private ${cfg.tableCodeForClass}Dao ${cfg.tableCodeForProperty}Dao;
	@Autowired
	private JdbcDao jdbcDao;
	
	public List queryAll${cfg.tableCodeForClass}(){
		return ${cfg.tableCodeForProperty}Dao.findAll();
	};
	public ${cfg.tableCodeForClass} query${cfg.tableCodeForClass}ById(String id) {
		
		Optional<${cfg.tableCodeForClass}> r = ${cfg.tableCodeForProperty}Dao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
		//此方法是懒加载
		//return ${cfg.tableCodeForProperty}Dao.getOne(id);
	}
	public void delete${cfg.tableCodeForClass}ById(String id){
		this.${cfg.tableCodeForProperty}Dao.deleteById(id);
	};
	public ${cfg.tableCodeForClass} save${cfg.tableCodeForClass}(${cfg.tableCodeForClass} ${cfg.tableCodeForProperty}){
		if(${cfg.tableCodeForProperty} == null){
			throw new RuntimeException("${cfg.tableCodeForClass} can not be null" );
		}
		return this.${cfg.tableCodeForProperty}Dao.save(${cfg.tableCodeForProperty});
	};
	public ${cfg.tableCodeForClass} update${cfg.tableCodeForClass}(${cfg.tableCodeForClass} ${cfg.tableCodeForProperty}){
		if(${cfg.tableCodeForProperty} == null){
			throw new RuntimeException("${cfg.tableCodeForClass} can not be null" );
		}
		if(MyStringUtils.isEmpty(${cfg.tableCodeForProperty}.get${cfg.pkColumn.columnCodeForClass}())){
			throw new RuntimeException("${cfg.tableCodeForClass}'s id can not be null" );
		}
		${cfg.tableCodeForClass} u = this.query${cfg.tableCodeForClass}ById(${cfg.tableCodeForProperty}.get${cfg.pkColumn.columnCodeForClass}());
		if(u != null){
			return this.${cfg.tableCodeForProperty}Dao.saveAndFlush(${cfg.tableCodeForProperty});
		}else{
			throw new RuntimeException("${cfg.tableCodeForClass} not be found id:[" + ${cfg.tableCodeForProperty}.get${cfg.pkColumn.columnCodeForClass}() + "]");
		}
		
	}
	public ${cfg.tableCodeForClass} saveOrUpdate${cfg.tableCodeForClass}(${cfg.tableCodeForClass} ${cfg.tableCodeForProperty}){
		return this.${cfg.tableCodeForProperty}Dao.saveAndFlush(${cfg.tableCodeForProperty});
	}
	
	
	public void query${cfg.tableCodeForClass}(QueryBean qb){
		String sql = "select "+
			" t.${cfg.pkColumn.columnCodeForUpper} as ${cfg.pkColumn.columnCodeForUpper}, " + //0  ${cfg.pkColumn.columnName} 
		<#list cfg.columnList as col> 
			" t.${col.columnCodeForUpper} as ${col.columnCodeForUpper}<#if col_has_next>,</#if> " + //${col_index} ${col.columnName} 			
		</#list>
			
			" from ${cfg.tableCodeForUpper} t  where 1=1 ";
		
		
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("${cfg.pkColumn.columnCodeForUpper}"))){
			sql += " and t.${cfg.pkColumn.columnCodeForUpper} like ? ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("${cfg.pkColumn.columnCodeForUpper}").toString().trim() + "%");
		}
		<#list cfg.columnList as col> 
		<#if col.columnType=="java.lang.String">
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("${col.columnCodeForUpper}"))){
			sql += " and upper(t.${col.columnCodeForUpper}) like upper(?) ";
			qb.getSqlParams().add("%" + qb.getQueryParams().get("${col.columnCodeForUpper}").toString().trim() + "%");
		}
		</#if>
		<#if col.columnType!="java.lang.String">
		if(MyStringUtils.isNotEmpty(qb.getQueryParams().get("${col.columnCodeForUpper}"))){
			sql += " and t.${col.columnCodeForUpper} = ? ";
			qb.getSqlParams().add(qb.getQueryParams().get("${col.columnCodeForUpper}").toString().trim());
		}
		</#if>
		</#list>
			
		
		
		
		qb.setSql(sql);
		
		this.jdbcDao.query(qb);
	};
}
