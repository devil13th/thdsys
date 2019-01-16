package com.thd.codegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.thd.codegen.jdbc.JdbcUtil;
import com.thd.codegen.jdbc.MysqlJdbcUtilImpl;
import com.thd.codegen.jdbc.OracleJdbcUtilImpl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CodeGenUtilImpl implements CodeGenUtil{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * xml文件转CodeGenConfig对象
	 * @param xmlPath xml文件配置
	 * @return CodeGenConfig对象
	 */
	public CodeGenConfig xmlToConfig(String xmlPath) throws Exception{
		File xmlFile = new File(xmlPath);
		if(!xmlFile.exists()){
			throw new Exception(" 未找到配置文件 [" + xmlPath + "] ");
		}
		InputStream is = new FileInputStream(xmlFile);
		if(is == null){
			throw new Exception(" 输入流不能为null");
		}
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(is);
		//根目录
		Element root = doc.getRootElement();
		//actionPackage
		Element actionPackageTag = root.getChild("actionPackage");
		if(actionPackageTag == null){
			throw new Exception("配置文件中未找到[actionPackage]标签 ");
		}
		String actionPackageStr = actionPackageTag.getText();
		if(this.isEmpty(actionPackageStr)){
			throw new Exception("配置文件中未找到[actionPackage]标签 ");
		}
		this.log.info("加载[actionPackage]标签内容 :" + actionPackageStr);
		//actionName
		String actionNameStr ="";
		try{
			Element actionNameTag = root.getChild("actionName");
			if(actionNameTag == null){
				throw new Exception("配置文件中未找到[actionName]标签 ");
			}
			actionNameStr = actionNameTag.getText();
			if(this.isEmpty(actionNameStr)){
				throw new Exception("[actionName]标签内容不能为null ");
			}
			this.log.info("加载[actionName]标签 :" + actionNameStr);
		}catch(Exception e){
			this.log.warn(e.getMessage());
		}
		
		//servicePackage
		Element servicePackageTag = root.getChild("servicePackage");
		if(servicePackageTag == null){
			throw new Exception("配置文件中未找到[servicePackage]标签 ");
		}
		String servicePackageStr = servicePackageTag.getText();
		if(this.isEmpty(servicePackageStr)){
			throw new Exception("[servicePackage]标签内容不能为null ");
		}
		this.log.info("加载[servicePackage]标签 :" + servicePackageStr);
		//serviceName
		String serviceNameStr = "";
		try{
			Element serviceNameTag = root.getChild("serviceName");
			if(serviceNameTag == null){
				throw new Exception("配置文件中未找到[serviceName]标签 ");
			}
			serviceNameStr = serviceNameTag.getText();
			if(this.isEmpty(serviceNameStr)){
				throw new Exception("[serviceName]标签内容不能为null ");
			}
			this.log.info("加载[serviceName]标签 :" + serviceNameStr);
		}catch(Exception e){
			this.log.warn(e.getMessage());
		}
		
		
		//daoPackage
		Element daoPackageTag = root.getChild("daoPackage");
		if(daoPackageTag == null){
			throw new Exception("配置文件中未找到[daoPackage]标签 ");
		}
		String daoPackageStr = daoPackageTag.getText();
		if(this.isEmpty(daoPackageStr)){
			throw new Exception("[daoPackage]标签内容不能为null ");
		}
		this.log.info("加载[daoPackage]标签 :" + daoPackageStr);
				
				
				
		//pojoPackage
		Element pojoPackageTag = root.getChild("pojoPackage");
		if(pojoPackageTag == null){
			throw new Exception("配置文件中未找到[pojoPackage]标签 ");
		}
		String pojoPackageStr = pojoPackageTag.getText();
		if(this.isEmpty(pojoPackageStr)){
			throw new Exception("[pojoPackage]标签内容不能为null ");
		}
		this.log.info("加载[pojoPackage]标签 :" + pojoPackageStr);
		//tableName
		Element tableNameTag = root.getChild("tableName");
		if(tableNameTag == null){
			throw new Exception("配置文件中未找到[tableName]标签 ");
		}
		String tableNameStr = tableNameTag.getText();
		if(this.isEmpty(tableNameStr)){
			throw new Exception("[tableName]标签内容不能为null ");
		}
		this.log.info("加载[tableName :" + tableNameStr);
		//tableCode
		Element tableCodeTag = root.getChild("tableCode");
		if(tableCodeTag == null){
			throw new Exception("配置文件中未找到[tableCode]标签 ");
		}
		String tableCodeStr = tableCodeTag.getText();
		if(this.isEmpty(tableCodeStr)){
			throw new Exception("[tableCode]标签内容不能为null ");
		}
		this.log.info("加载[tableCode]标签 :" + tableCodeStr);
		//generator
		Element generatorTag = root.getChild("generator");
		if(generatorTag == null){
			throw new Exception("配置文件中未找到[generator]标签 ");
		}
		String generatorStr = generatorTag.getText();
		if(this.isEmpty(generatorStr)){
			throw new Exception("generator标签内容不能为null ");
		}
		this.log.info("加载[generator]标签 :" + generatorStr);
		
		
		
		//jspPath
		String jspPathStr ="";
		try{
			Element jspPathTag = root.getChild("jspPath");
			if(jspPathTag == null){
				throw new Exception("配置文件中未找到[jspPath]标签 ");
			}
			jspPathStr = jspPathTag.getText();
			if(this.isEmpty(jspPathStr)){
				throw new Exception("[jspPath]标签内容为null ");
			}
			this.log.info("加载[jspPath]标签 :" + jspPathStr);
		}catch(Exception e){
			this.log.warn(e.getMessage());
		}
		
		//nameSpace
		String nameSpaceStr ="";
		try{
			Element nameSpaceTag = root.getChild("nameSpace");
			if(nameSpaceTag == null){
				throw new Exception("配置文件中未找到[nameSpace]标签 ");
			}
			nameSpaceStr = nameSpaceTag.getText();
			if(this.isEmpty(nameSpaceStr)){
				throw new Exception("[nameSpace]标签内容为null ");
			}
			this.log.info("加载[nameSpace]标签 :" + nameSpaceStr);
		}catch(Exception e){
			this.log.warn(e.getMessage());
		}
		
		//urlActionName
		String urlActionNameStr ="";
		try{
			Element urlActionNameTag = root.getChild("urlActionName");
			if(urlActionNameTag == null){
				throw new Exception("配置文件中未找到[urlActionName]标签 ");
			}
			urlActionNameStr = urlActionNameTag.getText();
			if(this.isEmpty(urlActionNameStr)){
				throw new Exception("[urlActionName]标签内容为null ");
			}
			this.log.info("加载[urlActionName]标签 :" + urlActionNameStr);
		}catch(Exception e){
			this.log.warn(e.getMessage());
		}
				
				
		CodeGenConfig cfg = new CodeGenConfig();
		cfg.setTableName(tableNameStr.trim());
		cfg.setTableCode(tableCodeStr.trim());
		cfg.setTableCodeForUpper(tableCodeStr.trim().toUpperCase());
		cfg.setTableCodeForClass(this.fieldToSetterGetter(tableCodeStr).trim());
		cfg.setTableCodeForProperty(this.fieldToProperty(tableCodeStr).trim());
		
		if(this.isNotEmpty(actionNameStr)){
			cfg.setActionName(actionNameStr.trim());
		}else{
			cfg.setActionName(cfg.getTableCodeForClass()+"Action");
		}
		if(this.isNotEmpty(serviceNameStr)){
			cfg.setServiceName(serviceNameStr.trim());
		}else{
			cfg.setServiceName(cfg.getTableCodeForClass()+"Service");
		}
		
		if(this.isNotEmpty(jspPathStr)){
			cfg.setJspPath(jspPathStr.trim());
		}else{
			cfg.setJspPath("pages/" + cfg.getTableCodeForProperty());
		}
		if(this.isNotEmpty(nameSpaceStr)){
			cfg.setNameSpace(nameSpaceStr.trim());
		}else{
			cfg.setNameSpace(cfg.getTableCodeForProperty());
		}
		if(this.isNotEmpty(urlActionNameStr)){
			cfg.setUrlActionName(urlActionNameStr.trim());
		}else{
			cfg.setUrlActionName(cfg.getTableCodeForProperty());
		}
		
		
		
		cfg.setActionPackage(actionPackageStr.trim());
		cfg.setActionNameForProperty(this.firstLetterToLower(cfg.getActionName()).trim());
		cfg.setServicePackage(servicePackageStr.trim());
		cfg.setServiceNameForProperty(this.firstLetterToLower(cfg.getServiceName()).trim());
		cfg.setDaoPackage(daoPackageStr);
		cfg.setGenerator(generatorStr.trim());
		cfg.setPojoPackage(pojoPackageStr.trim());
		
		
		
		
		
		List<Element> columnList = root.getChild("columns").getChildren("column");
		List<CodeGenColumnConfig> columnSourceList = new ArrayList<CodeGenColumnConfig>();
		if(columnList == null || columnList.size() < 1){
			
			//dburl
			Element dburlTag = root.getChild("columns").getChild("dburl");
			if(dburlTag == null){
				throw new Exception("配置文件中未找到[dburl]标签 ");
			}
			String dburlStr = dburlTag.getText();
			if(this.isEmpty(dburlStr)){
				throw new Exception("[dburl]标签内容不能为null ");
			}
			this.log.info("加载[dbrul]标签 :" + dburlStr);
			
			//usrname
			Element usrnameTag = root.getChild("columns").getChild("usrname");
			if(usrnameTag == null){
				throw new Exception("配置文件中未找到[usrname]标签 ");
			}
			String usrnameStr = usrnameTag.getText();
			if(this.isEmpty(usrnameStr)){
				throw new Exception("[usrname]标签内容不能为null ");
			}
			this.log.info("加载[usrname]标签 :" + usrnameStr);
			
			//usrpwd
			Element usrpwdTag = root.getChild("columns").getChild("usrpwd");
			if(usrpwdTag == null){
				throw new Exception("配置文件中未找到[usrpwd]标签 ");
			}
			String usrpwdStr = usrpwdTag.getText();
			if(this.isEmpty(usrpwdStr)){
				throw new Exception("[usrpwd]标签内容为null ");
			}
			this.log.info("加载[usrpwd]标签 :" + usrpwdStr);
			
			
			//dbtable
			Element dbtableTag = root.getChild("columns").getChild("dbtable");
			if(dbtableTag == null){
				throw new Exception("配置文件中未找到[dbtable]标签 ");
			}
			String dbtableStr = dbtableTag.getText();
			if(this.isEmpty(dbtableStr)){
				throw new Exception("[dbtable]标签内容不能为null ");
			}
			this.log.info("加载[dbtable]标签 :" + dbtableStr);
			
			
			//dbtype
			Element dbtypeTag = root.getChild("columns").getChild("dbtype");
			if(dbtypeTag == null){
				throw new Exception("配置文件中未找到[dbtype]标签 ");
			}
			String dbtypeStr = dbtypeTag.getText();
			if(this.isEmpty(dbtypeStr)){
				throw new Exception("[dbtype]标签内容不能为null ");
			}
			
			//schema
			Element schemaTag = root.getChild("columns").getChild("schema");
			if(schemaTag == null){
				throw new Exception("配置文件中未找到[schema]标签 ");
			}
			String schemaStr = schemaTag.getText();
			if(this.isEmpty(schemaStr)){
				throw new Exception("[schema]标签内容不能为null ");
			}
			this.log.info("加载[schema]标签 :" + schemaStr);
			
			
			JdbcUtil ju = null;
			if("oracle".equals(dbtypeStr.trim().toLowerCase())){
				ju = new OracleJdbcUtilImpl(usrnameStr.trim(),usrpwdStr.trim(),dburlStr.trim(),schemaStr.trim());
			}else if("sqlserver".equals(dbtypeStr.trim().toLowerCase())){
				//dt = this.sqlserverDBTypeMap;
			}else if("mysql".equals(dbtypeStr.trim().toLowerCase())){
				ju = new MysqlJdbcUtilImpl(usrnameStr.trim(),usrpwdStr.trim(),dburlStr.trim(),schemaStr.trim());
			}else{
				throw new RuntimeException("未找到该数据库类型[" + dbtypeStr + "]");
			}
			
			columnSourceList = ju.loadColumnCfg(dbtableStr.trim());
		}else{
			
			for(Element column : columnList){
				CodeGenColumnConfig columnCfg = new CodeGenColumnConfig();
				
				//columnCode
				Element columnCodeTag = column.getChild("columnCode");
				if(columnCodeTag == null){
					throw new Exception("配置文件中未能找到[" + tableNameStr + "]'表的[columnCode]标签 ");
				}
				String columnCodeStr = columnCodeTag.getText();
				if(this.isEmpty(columnCodeStr)){
					throw new Exception("[" + tableNameStr + "]'表的[columnCode]标签内容不能为null ");
				}
				this.log.info("加载[columnCode]标签 :" + columnCodeStr);
				//columnName
				Element columnNameTag = column.getChild("columnName");
				if(columnNameTag == null){
					throw new Exception("配置文件中未能找到[" + columnCodeStr + "]'表的[columnName]标签 ");
				}
				String columnNameStr = columnNameTag.getText();
				if(this.isEmpty(columnNameStr)){
					throw new Exception("[" + columnCodeStr + "]字段的[columnName]标签内容不能为null ");
				}
				this.log.info("加载[columnName]标签 :" + columnNameStr);
				
				//columnType
				Element columnTypeTag = column.getChild("columnType");
				if(columnTypeTag == null){
					throw new Exception("配置文件中未能找到[" + columnCodeStr + "表的[columnType]标签 ");
				}
				String columnTypeStr = columnTypeTag.getText();
				if(this.isEmpty(columnTypeStr)){
					throw new Exception("[" + columnCodeStr + "]的[columnType]标签内容不能为null ");
				}
				this.log.info("加载[columnName]标签 :" + columnTypeStr);
				
				columnCfg.setColumnCode(columnCodeStr.trim());
				columnCfg.setColumnName(columnNameStr.trim());
				columnCfg.setColumnType(columnTypeStr.trim());
				
				/*
				columnCfg.setColumnCodeForProperty(this.fieldToProperty(columnCodeStr.trim()));
				columnCfg.setColumnCodeForUpper(columnCodeStr.trim().toUpperCase());
				columnCfg.setColumnCodeForClass(this.fieldToSetterGetter(columnCodeStr.trim()));
				*/
				
				//columnDesc
				Element columnDescTag = column.getChild("columnDesc");
				if(columnDescTag != null){
					String columnDescStr = columnDescTag.getText();
					if(this.isNotEmpty(columnDescStr)){
						columnCfg.setColumnDesc(columnDescStr.trim());
						this.log.info("加载[columnDesc]标签 :" + columnDescStr);
					}
				}
				/*
				Boolean b = false;
				*/
				//columnIspk
				Element columnIspkTag = column.getChild("columnIspk");
				if(columnIspkTag != null){
					String columnIspkStr = columnIspkTag.getText();
					if(this.isNotEmpty(columnIspkStr)){
						columnCfg.setIsPk(true);
						if(cfg.getPkColumn() != null){
							throw new Exception(" 出现了多主键 !");
						}
						//主键加入主键字段
						/*
						cfg.setPkColumn(columnCfg);
						b=true;
						*/
					}
					this.log.info("加载[columnIspk]标签 :" + columnIspkStr);
				}
				/*
				if(!b){
					//非主键加入普通字段列表
					cfg.getColumnList().add(columnCfg);
				}
				*/
				columnSourceList.add(columnCfg);
			}
		}
		
		if(columnSourceList != null && columnSourceList.size() > 0){
			for(CodeGenColumnConfig colCfg : columnSourceList){
				colCfg.setColumnCodeForProperty(this.fieldToProperty(colCfg.getColumnCode()));
				colCfg.setColumnCodeForUpper(colCfg.getColumnCode().toUpperCase());
				colCfg.setColumnCodeForClass(this.fieldToSetterGetter(colCfg.getColumnCode()));
				if(colCfg.getIsPk()){
					cfg.setPkColumn(colCfg);
				}else{
					cfg.getColumnList().add(colCfg);
				}
			}
		}
		return cfg;
	}
	
	public void makeCodeByTemplate(CodeGenConfig cfg,String templatePath,String filePath) throws Exception{
		Map map = new HashMap();
		map.put("cfg",cfg);
		this.fillData(map,templatePath, filePath, "UTF-8");
	};
	
	
	public void makeCodeByTemplate(String cfgPath,String templatePath,String filePath) throws Exception{
		CodeGenConfig cfg = xmlToConfig("E://thdsvn//java_project//devil13CodeGen//cfg//cfg.xml");
		makeCodeByTemplate(cfg,templatePath,filePath);
	};
	
	/**
	 * 判断字符串是否是null或空串
	 * @param str 字符串
	 * @return 是：true  否：false
	 */
	public static boolean isEmpty(String str){
		return (str == null || str.trim().equals(""));
	}
	
	/**
	 * 判断字符串是否不是null或空串
	 * @param str 字符串
	 * @return 是：true  否：false
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	
	/**
	 * 
	 * @param data 填充的数据
	 * @param dir 模板目录
	 * @param templateName 模板名称
	 * @param targetPath 生成位置
	 * @param charset 字符集
	 * @throws Exception
	 */
	public void fillData(Map<String,Object> data,String dir,String templateName,String targetPath,String charset) throws Exception{
		//初使化FreeMarker配置
		Configuration  configuration = new Configuration();
		//设置要解析的模板所在的目录，并加载模板文件
		configuration.setDirectoryForTemplateLoading(new File(dir));
		//设置编码格式
		configuration.setDefaultEncoding(charset);
		Template t = null;
		
		
		// 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致  
		// 否则会出现乱码 

		t = configuration.getTemplate(templateName,charset);
		
		if(targetPath == null){
			throw new Exception(" target path err !");
		}
		
		File outFile = new File(targetPath);
		Writer out = null;
		try {
			if(charset == null){
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
			}else{
				out = new OutputStreamWriter(new FileOutputStream(outFile), charset); 
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			t.process(data, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param data 数据
	 * @param templatePath 模板位置
	 * @param targetPath 生成位置
	 * @param charset 字符集
	 * @throws Exception
	 */
	public void fillData(Map<String,Object> data,String templatePath,String targetPath,String charset) throws Exception{
		File template = new File(templatePath);
		//模板所在目录路径
		String dir = template.getParent();
		//模板名称
		String templateName = template.getName();
		this.fillData(data, dir, templateName, targetPath, charset);
	}
	
	
	public String fieldToProperty(String field) {  
        if (null == field) {  
            return "";
        }  
        field = field.toLowerCase();
        char[] chars = field.toCharArray();  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < chars.length; i++) {  
            char c = chars[i];  
            if (c == '_') {  
                int j = i + 1;  
                if (j < chars.length) {  
                    //sb.append(StringUtils.upperCase(CharUtils.toString(chars[j])));  
                	sb.append(String.valueOf(chars[j]).toUpperCase());  
                    i++;  
                }  
            } else {  
                sb.append(c);  
            }  
        }  
        return sb.toString();
    } 
	
	public String fieldToSetterGetter(String field){
		String propertyName = fieldToProperty(field);
		String firstLetter = propertyName.substring(0,1).toUpperCase();
		return firstLetter + propertyName.substring(1,propertyName.length());
	};
	
	public String firstLetterToLower(String str){
		String firstLetter = str.substring(0,1).toLowerCase();
		return firstLetter + str.substring(1,str.length());
	};
}
