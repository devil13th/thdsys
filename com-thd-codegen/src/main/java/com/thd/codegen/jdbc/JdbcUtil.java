package com.thd.codegen.jdbc;

import java.util.List;

import com.thd.codegen.CodeGenColumnConfig;

public interface JdbcUtil {
	/**
	 * 根据数据库表名加载列的配置
	 * @param tableName 表名
	 * @return
	 */
	public List<CodeGenColumnConfig> loadColumnCfg(String tableName) throws Exception;
	
	
	
	public String getUrl() ;
	public void setUrl(String url);
	public String getUname();
	public void setUname(String uname);
	public String getUpwd();
	public void setUpwd(String upwd);
	public String getDriver();
	public void setDriver(String driver);
	public String getSchema() ;
	public void setSchema(String schema) ;
}
