package com.thd.codegen;

import java.util.Map;

public interface CodeGenUtil {
	/**
	 * xml文件转CodeGenConfig对象
	 * @param xmlPath xml文件配置
	 * @return CodeGenConfig对象
	 */
	public CodeGenConfig xmlToConfig(String xmlPath) throws Exception;
	/**
	 * 根据模板和配置对象生成文件
	 * @param cfg 配置对象
	 * @param templatePath 模板位置
	 * @param filePath 生成文件位置
	 */
	public void makeCodeByTemplate(CodeGenConfig cfg,String templatePath,String filePath) throws Exception;
	
	/**
	 * 根据模板和配置文件生成文件
	 * @param cfgPath 配置文件位置
	 * @param templatePath 模板位置
	 * @param filePath 生成文件位置
	 */
	public void makeCodeByTemplate(String cfgPath,String templatePath,String filePath) throws Exception;
	
	/**
	 * 
	 * @param data 填充的数据
	 * @param dir 模板目录
	 * @param templateName 模板名称
	 * @param targetPath 生成位置
	 * @param charset 字符集
	 * @throws Exception
	 */
	public void fillData(Map<String,Object> data,String dir,String templateName,String targetPath,String charset) throws Exception;
	
	/**
	 * 
	 * @param data 数据
	 * @param templatePath 模板位置
	 * @param targetPath 生成位置
	 * @param charset 字符集
	 * @throws Exception
	 */
	public void fillData(Map<String,Object> data,String templatePath,String targetPath,String charset) throws Exception;
	/**
	 * 字段转类属性
	 * @param field 字段名称
	 * @return  aaa -> Aaa    user_name -> userName
	 */
	public String fieldToProperty(String field) ;
	/**
	 * 字段转setter getter的属性
	 * @param field 字段名称
	 * @return  aaa -> Aaa    user_name -> UserName
	 */
	public String fieldToSetterGetter(String field);
	/**
	 * 首字母小写
	 * @param str 
	 * @return
	 */
	public String firstLetterToLower(String str);
}
