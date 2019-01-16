package com.thd.codegen.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thd.codegen.CodeGenColumnConfig;

public class MysqlJdbcUtilImpl extends JdbcUtilImpl {
	
	public MysqlJdbcUtilImpl(String uname,String upwd,String url,String schema){
		super(uname, upwd, url,schema);
		
		this.driver = "com.mysql.jdbc.Driver";
		
		this.dBTypeMap.put("int", "java.lang.Integer");
		this.dBTypeMap.put("varchar", "java.lang.String");
		this.dBTypeMap.put("date", "java.util.Date");
		this.dBTypeMap.put("decimal", "java.lang.Double");
		this.dBTypeMap.put("float", "java.lang.Float");
		this.dBTypeMap.put("double", "java.lang.Double");
		this.dBTypeMap.put("datetime", "java.util.Date");
		this.dBTypeMap.put("text", "java.lang.String");
	}
	
	@Override
	public List<CodeGenColumnConfig> loadColumnCfg(String dbTableName) throws Exception {
		List<CodeGenColumnConfig> res = new ArrayList<CodeGenColumnConfig>();
		
		try{
			
			
			this.openConn();
			conn.setAutoCommit(false); 
			String sql = "select "
					+ "TABLE_NAME,"//1表英文名
					+ "COLUMN_NAME,"//2字段英文名
					+ "IS_NULLABLE,"//3是否可以空
					+ "DATA_TYPE,"//4数据类型
					+ "COLUMN_KEY,"//5是否主键
					+ "COLUMN_COMMENT, "//6字段备注
					+ "CHARACTER_MAXIMUM_LENGTH "//7字段长度
					+ " from information_schema.COLUMNS where TABLE_NAME like ? and TABLE_SCHEMA = ? order by ORDINAL_POSITION asc";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dbTableName );
			pstmt.setString(2, schema );
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String columnCode = rs.getString(2) == null ? "" : rs.getString(2);
				String columnName = rs.getString(6) == null ? "" : rs.getString(6);
				String isNullAble = rs.getString(3) == null ? "" : rs.getString(3);
				String columnType = rs.getString(4) == null ? "" : rs.getString(4);
				String columnDataType = rs.getString(4) == null ? "" : rs.getString(4);
				String columnIspk = rs.getString(5) == null ? "" : rs.getString(5);
				int columnDataLength = rs.getString(7) == null ? -1 : Integer.parseInt(rs.getString(7));
				//System.out.println(columnCode + "|" + columnName + "|" + isNullAble + "|" + columnType + "|" + columnIspk );
				
				
				CodeGenColumnConfig columnCfg = new CodeGenColumnConfig();
				
				
				columnCfg.setColumnCode(columnCode.trim());
				columnCfg.setColumnName(columnName.trim());
				String columnJavaType = dBTypeMap.get(columnType.trim().toLowerCase());
				if(columnJavaType == null || columnJavaType.trim().equals("")){
					throw new RuntimeException("未找到[" +  columnCode + "]字段的对应类型[" + columnType + "]");
				}
				columnCfg.setColumnType(columnJavaType);
				if(columnIspk!=null && !"".equals(columnIspk.trim())){
					columnCfg.setIsPk(true);
				}
				columnCfg.setColumnDesc(columnName);
				columnCfg.setColumnDataType(columnDataType);
				columnCfg.setColumnDataLength(columnDataLength);
				res.add(columnCfg);
				
			}
			conn.commit();
			this.closeConn();
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw e;
		}
		
		return res;
	}

}
