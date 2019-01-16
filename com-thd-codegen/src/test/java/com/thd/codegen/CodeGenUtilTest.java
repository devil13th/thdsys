package com.thd.codegen;

import junit.framework.TestCase;

import org.junit.Test;

public class CodeGenUtilTest extends TestCase {
	@Test
	public void testfieldToProperty(){
		CodeGenUtilImpl u = new CodeGenUtilImpl();
		String columnNames = "user_name,USER_NAME,UserName,aaa,bbb,a_b,_aCC,CCa_";
		String[] columnArray = columnNames.split(",");
		for(String column : columnArray){
			System.out.println(column + ":" + u.fieldToProperty(column));
		}
	}
	@Test
	public void testfieldToSetterGetter(){
		CodeGenUtilImpl u = new CodeGenUtilImpl();
		String columnNames = "user_name,USER_NAME,UserName,aaa,bbb,a_b,_aCC,CCa_";
		String[] columnArray = columnNames.split(",");
		for(String column : columnArray){
			System.out.println(column + ":" + u.fieldToSetterGetter(column));
		}
	}
	
	
	
	@Test
	public void testxmlToConfig(){
		CodeGenUtilImpl u = new CodeGenUtilImpl();
		try{
			CodeGenConfig cfg = u.xmlToConfig("E://thdsvn//java_project//devil13CodeGen//cfg//cfg.xml");
			System.out.println(cfg);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testmakeCodeByTemplate(){
		CodeGenUtilImpl u = new CodeGenUtilImpl();
		try{
			/*
			CodeGenConfig cfg = u.xmlToConfig("E://thdsvn//java_project//devil13CodeGen//cfg//normal.xml");
			//生成pojo
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//pojo.ftl","D://codegen//" + cfg.getTableCodeForClass() + ".java");
			//生成hbm
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//hbm.ftl","D://codegen//" + cfg.getTableCodeForClass() + ".hbm.xml");
			//生成Service接口
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//service.ftl","D://codegen//" + cfg.getServiceName() + ".java");
			//生成Service实现类
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//serviceImpl.ftl","D://codegen//" + cfg.getServiceName() + "Impl.java");
			//生成Action
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//action.ftl","D://codegen//" + cfg.getActionName() + ".java");
			//生成列表页JSP
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//formjsp.ftl","D://codegen//" + cfg.getTableCodeForProperty() + "Form.jsp");
			//生成编辑页JSP
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//listjsp.ftl","D://codegen//" + cfg.getTableCodeForProperty() + "List.jsp");
			//生成spring 和  struts2配置
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//beanCfg.ftl", "D://codegen//" + cfg.getTableCodeForProperty() + "_cfg.xml");
			//基础模板生成
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//template.ftl", "D://codegen//" + cfg.getTableCodeForProperty() + "_template.txt");
			*/
			
			CodeGenConfig cfg = u.xmlToConfig("E://thdsvn//java_project//devil13CodeGen//cfg//oracleExample.xml");
			//生成pojo
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//pojo.ftl","E://cg//" + cfg.getTableCodeForClass() + ".java");
			//生成hbm
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//hbm.ftl","E://cg//" + cfg.getTableCodeForClass() + ".hbm.xml");
			//生成Service接口
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//service.ftl","E://cg//" + cfg.getServiceName() + ".java");
			//生成Service实现类
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//serviceImpl.ftl","E://cg//" + cfg.getServiceName() + "Impl.java");
			//生成Action
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//action.ftl","E://cg//" + cfg.getActionName() + ".java");
			//生成列表页JSP
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//formjsp.ftl","E://cg//" + cfg.getTableCodeForProperty() + "Form.jsp");
			//生成编辑页JSP
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//listjsp.ftl","E://cg//" + cfg.getTableCodeForProperty() + "List.jsp");
			//生成spring 和  struts2配置
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//beanCfg.ftl", "E://cg//" + cfg.getTableCodeForProperty() + "_cfg.xml");
			//基础模板生成
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//template.ftl", "E://cg//" + cfg.getTableCodeForProperty() + "_template.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testmakeCodeByTemplateHr(){
		CodeGenUtilImpl u = new CodeGenUtilImpl();
		try{
			CodeGenConfig cfg = u.xmlToConfig("E://thdsvn//java_project//devil13CodeGen//cfg//se.xml");
			//生成pojo
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//pojo.ftl","D://codegen//" + cfg.getTableCodeForClass() + ".java");
			//生成hbm
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//hbm.ftl","D://codegen//" + cfg.getTableCodeForClass() + ".hbm.xml");
			//生成Service接口
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//service.ftl","D://codegen//" + cfg.getServiceName() + ".java");
			//生成Service实现类
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//serviceImpl.ftl","D://codegen//" + cfg.getServiceName() + "Impl.java");
			//生成Action
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//action.ftl","D://codegen//" + cfg.getActionName() + ".java");
			//生成列表页JSP--easy
			//u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//formjsp.ftl","D://codegen//" + cfg.getTableCodeForProperty() + "Form.jsp");
			//生成列表页JSP--bootstrap
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//formjspForBootstrap.ftl","D://codegen//" + cfg.getTableCodeForProperty() + "Form.jsp");
			
			//生成编辑页JSP--bootstrap
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//listjsp.ftl","D://codegen//" + cfg.getTableCodeForProperty() + "List.jsp");
			
			
			//生成spring 和  struts2配置
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//beanCfg.ftl", "D://codegen//" + cfg.getTableCodeForProperty() + "_cfg.xml");
			//基础模板生成
			u.makeCodeByTemplate(cfg,"E://thdsvn//java_project//devil13CodeGen//template//template.ftl", "D://codegen//" + cfg.getTableCodeForProperty() + "_template.txt");
			System.out.println(" ------  code gen finish ------ ");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@Test
	public void testmakeCodeByTemplate1(){
		CodeGenUtilImpl u = new CodeGenUtilImpl();
		try{
			String cfgXmlConfigPath = "D://thdsvn//java_project//devil13CodeGen//cfg//se.xml";
			String templateFolderPath = "D://thdsvn//java_project//devil13CodeGen//template//";
			String targetFolder = "D://cg//";
			
			CodeGenConfig cfg = u.xmlToConfig(cfgXmlConfigPath);
			//生成pojo
			u.makeCodeByTemplate(cfg,templateFolderPath + "pojo.ftl",targetFolder + cfg.getTableCodeForClass() + ".java");
			//生成hbm
			u.makeCodeByTemplate(cfg,templateFolderPath + "hbm.ftl",targetFolder + cfg.getTableCodeForClass() + ".hbm.xml");
			//生成Service接口
			u.makeCodeByTemplate(cfg,templateFolderPath + "service.ftl",targetFolder + cfg.getServiceName() + ".java");
			//生成Service实现类
			u.makeCodeByTemplate(cfg,templateFolderPath + "serviceImpl.ftl",targetFolder + cfg.getServiceName() + "Impl.java");
			//生成Action
			u.makeCodeByTemplate(cfg,templateFolderPath + "action.ftl",targetFolder + cfg.getActionName() + ".java");
			//生成列表页JSP
			u.makeCodeByTemplate(cfg,templateFolderPath + "formjsp.ftl",targetFolder + cfg.getTableCodeForProperty() + "Form.jsp");
			//生成编辑页JSP
			u.makeCodeByTemplate(cfg,templateFolderPath + "listjsp.ftl",targetFolder + cfg.getTableCodeForProperty() + "List.jsp");
			//生成spring 和  struts2配置
			u.makeCodeByTemplate(cfg,templateFolderPath + "beanCfg.ftl", targetFolder + cfg.getTableCodeForProperty() + "_cfg.xml");
			//基础模板生成
			u.makeCodeByTemplate(cfg,templateFolderPath + "template.ftl", targetFolder + cfg.getTableCodeForProperty() + "_template.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testmakeCodeByTemplateForSpringBoot(){
		CodeGenUtilImpl u = new CodeGenUtilImpl();
		try{
			String cfgXmlConfigPath = "D://work//java//thdsys//com-thd-codegen//src//main//resources//cfg//cfgForSpringBoot.xml";
			String templateFolderPath = "D://work//java//thdsys//com-thd-codegen//src//main//resources//templateforspringboot//";
			String targetFolder = "D://cg//";
			
			CodeGenConfig cfg = u.xmlToConfig(cfgXmlConfigPath);
			//生成pojo
			u.makeCodeByTemplate(cfg,templateFolderPath + "entity.ftl",targetFolder + cfg.getTableCodeForClass() + ".java");
			u.makeCodeByTemplate(cfg,templateFolderPath + "daoForJPA.ftl",targetFolder + cfg.getTableCodeForClass() + "Dao.java");
			u.makeCodeByTemplate(cfg,templateFolderPath + "service.ftl",targetFolder + cfg.getTableCodeForClass() + "Service.java");
			u.makeCodeByTemplate(cfg,templateFolderPath + "serviceImpl.ftl",targetFolder + cfg.getTableCodeForClass() + "ServiceImpl.java");
			u.makeCodeByTemplate(cfg,templateFolderPath + "controller.ftl",targetFolder + cfg.getTableCodeForClass() + "Controller.java");
			u.makeCodeByTemplate(cfg,templateFolderPath + "html.ftl",targetFolder + "api.html");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
