package com.thd.base.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.thd.base.test.entity.CustomDtoBean;
import com.thd.base.test.entity.RequestMethodBean;
import com.thd.core.bean.ResponseBean;
import com.thd.core.controller.BaseController;
import com.thd.utils.myutils.MyStringUtils;
@Controller
@RequestMapping(value="/requestMethod")
public class RequestMethodController extends BaseController{
	//http://127.0.0.1:8080/test/requestMethod/index
	@RequestMapping(value="/index")
	public String index(){
		return "/requestmethod/index";
	}
	
	/**
	 * GET 使用url 路径参数 后端直接获取参数
	 * 形如:http://127.0.0.1:8080/test/requestMethod/testGet1/123456abcde
	 * @param str
	 * @return
	 */
	@RequestMapping(value="/testGet1/{str}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean<String>> testGet1(@PathVariable String str){
		ResponseBean<String> rb = new ResponseBean<String>();
		rb.setResult(str);
		return rb.success();
/*
前端:
function testGetMethodByFetch(){
    fetch(
        `${ctx}requestMethod/testGet?str=123456`,
        {
         	'method':'GET',
         	headers:{
	         	'Access-Control-Allow-Origin': '*',
	            'Accept': 'application/json',
	            'Content-Type': 'application/json'
         	}
        }
    ).then(function(res){
		return res.text();
	}).then(function(res){
		document.getElementById("responseText").value = res;
    })
}
 */
	}
	
	/**
	 * GET 直接获取url中?(问号)后面的参数
	 * 形如:http://127.0.0.1:8080/test/requestMethod/testGet?str=123456
	 * @param str
	 * @return
	 */
	@RequestMapping(value="/testGet",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean<String>> testGet(@RequestParam String str){
		ResponseBean<String> rb = new ResponseBean<String>();
		rb.setResult(str);
		return rb.success();
		
/*
前端:
function testGetMethodByFetch(){
    fetch(
        `${ctx}requestMethod/testGet?str=123456`,
        {
         	'method':'GET',
         	headers:{
	         	'Access-Control-Allow-Origin': '*',
	            'Accept': 'application/json',
	            'Content-Type': 'application/json'
         	}
        }
    ).then(function(res){
		return res.text();
	}).then(function(res){
		document.getElementById("responseText").value = res;
    })
}
 */
	}
	
	/**
	 * GET 使用url 简单对象类型参数获取
	 * 形如:http://127.0.0.1:8080/test/requestMethod/testGet2?id=1&name=name&age=5&birthday=2018-01-01
	 * @param str
	 * @return
	 */
	@RequestMapping(value="/testGet2",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean<RequestMethodBean>> testGet2(RequestMethodBean rmb){
		ResponseBean<RequestMethodBean> rb = new ResponseBean<RequestMethodBean>();
		rb.setResult(rmb);
		return rb.success();
/*
前端:
function testGetMethodByFetch3(){
    fetch(
        `${ctx}requestMethod/testGet2?id=1&name=name&age=5&birthday=2018-01-01`,
        {
         	'method':'GET',
         	headers:{
	         	'Access-Control-Allow-Origin': '*',
	            'Accept': 'application/json',
	            'Content-Type': 'application/json'
         	}
        }
    ).then(function(res){
		return res.text();
	}).then(function(res){
		document.getElementById("responseText").value = res;
    })
}
 */
	}
	
	
	/**
	 * GET 使用url 简单对象类型参数获取
	 * 形如:http://127.0.0.1:8080/test/requestMethod/testGet3?rmb.id=1&rmb.name=name&rmb.age=5&rmb.birthday=2018-01-01
	 * @param str
	 * @return
	 */
	@RequestMapping(value="/testGet3",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean<CustomDtoBean>> testGet3(CustomDtoBean ctb){
		ResponseBean<CustomDtoBean> rb = new ResponseBean<CustomDtoBean>();
		rb.setResult(ctb);
		return rb.success();
/*
前端:
function testGetMethodByFetch4(){
    fetch(
        `${ctx}requestMethod/testGet3?rmb.id=1&rmb.name=name&rmb.age=5&rmb.birthday=2018-01-01`,
        {
         	'method':'GET',
         	headers:{
	         	'Access-Control-Allow-Origin': '*',
	            'Accept': 'application/json',
	            'Content-Type': 'application/json'
         	}
        }
    ).then(function(res){
		return res.text();
	}).then(function(res){
		document.getElementById("responseText").value = res;
    })
}
 */
	}
	
	/**
	 * POST 使用requestBody方式接收json参数后转对象
	 * request Payload : {"id":"1","name":"张三","address":"北京西城","age":5,"userStatus":"1","birthday":"2015-01-01","createTime":"2015-01-01 23:59:59"}
	 * @param rmb
	 * @return
	 */
	@RequestMapping(value="/testPost",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean<RequestMethodBean>> testPost(@RequestBody RequestMethodBean rmb){
		System.out.println(rmb);
		ResponseBean<RequestMethodBean> rb = new ResponseBean<RequestMethodBean>();
		rb.setResult(rmb);
		return rb.success();
/*
前端
function testPostMethodByFetch(){
    fetch(
        `${ctx}requestMethod/testPost`,
        {
         	'method':'POST',
         	headers:{
	         	'Access-Control-Allow-Origin': '*',
	            'Accept': 'application/json',
	            'Content-Type': 'application/json',
         	},
         	
         	//body 只有POST的方式才可以发送的
        	body:JSON.stringify({
        			"id":"1",
        			"name":"张三",
        			"address":"北京西城",
        			"age":5,
        			"userStatus":"1",
        			"birthday":"2015-01-01",
        			"createTime":"2015-01-01 23:59:59"
        	})
        }
    ).then(function(res){
		return res.json();
	}).then(function(json){
		document.getElementById("responseText").value = JSON.stringify(json);
    })
}
 */
	}
	
	
	
	/**
	 * POST 测试表单提交  使用Request获取post形式 formdata中的参数
	 * @return
	 */
	@RequestMapping(value="/testFormPost",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean<String>> testFormPost(HttpServletRequest req){
		ResponseBean<String> rb = new ResponseBean<String>();
		rb.setResult("usr:" + req.getParameter("usr") + " " + req.getParameter("pwd"));
		return rb.success();
/*
前端：
<form id="theForm" action="requestMethod/testFormPost" method="post">
<input type="text" name="usr" value="张三"/>
<input type="text" name="pwd" value="123456"/>
<input type="submit" value="FORM提交"/>
</form>
 */
	}
	
	/**
	 * POST 测试表单提交 使用@ModelAttribute获取post形式 formdata中的简单对象参数
	 * @return
	 */
	@RequestMapping(value="/testFormPost2",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean<RequestMethodBean>> testFormPost2(@ModelAttribute(name="rmb") RequestMethodBean rmb){
		ResponseBean<RequestMethodBean> rb = new ResponseBean<RequestMethodBean>();
		rb.setResult(rmb);
		return rb.success();
/*
前端:

<form id="theForm2" action="requestMethod/testFormPost2" method="post">
id:<input type="text" name="id" value="1"/><br/>
name:<input type="text" name="name" value="张三"/><br/>
age:<input type="text" name="age" value="15"/><br/>
birthday:<input type="text" name="birthday" value="2018-02-02"/><br/>
createDate:<input type="text" name="createTime" value="2018-02-02 10:35:55"/><br/>
<input type="submit" value="FORM提交"/>
</form>
 */
	}
	
	/**
	 * POST 测试表单提交 使用@ModelAttribute获取post形式 formdata中的复杂对象参数
	 * @param str
	 * @return
	 */
	@RequestMapping(value="/testFormPost3",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean<CustomDtoBean>> testFormPost3(@ModelAttribute CustomDtoBean cdb){
		ResponseBean<CustomDtoBean> rb = new ResponseBean<CustomDtoBean>();
		rb.setResult(cdb);
		return rb.success();
/*
前端
<h2>表单Post提交,后端使用@ModelAttribute接收复杂对象</h2>
对象1数据
<form id="theForm3" action="" method="post">
id:<input type="text" name="rmb.id" value="1"/><br/>
name:<input type="text" name="rmb.name" value="张三"/><br/>
age:<input type="text" name="rmb.age" value="15"/><br/>
birthday:<input type="text" name="rmb.birthday" value="2018-02-02"/><br/>
createDate:<input type="text" name="rmb.createTime" value="2018-02-02 10:35:55"/><br/>
对象2数据
id:<input type="text" name="rmb2.id" value="2"/><br/>
name:<input type="text" name="rmb2.name" value="李四"/><br/>
age:<input type="text" name="rmb2.age" value="18"/><br/>
birthday:<input type="text" name="rmb2.birthday" value="2020-02-02"/><br/>
createDate:<input type="text" name="rmb2.createTime" value="2020-02-02 10:35:55"/><br/>
<input type="submit" value="FORM提交"/>
</form>

 */
	}
	
	
	
	
	
	@RequestMapping("/testFormUpload")
    public ResponseEntity<ResponseBean<Map<String,String>>> testFormUpload(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request){

		ResponseBean<Map<String,String>> rb = new ResponseBean<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		 
		 
        // 姓名
        String name = request.getParameter("name");
        System.out.println("姓名：" + name);
        map.put("name", name);
        // 文件名
        String fileName = file.getOriginalFilename();
        if(fileName != null && MyStringUtils.isNotEmpty(fileName)){
	        
	        System.out.println("文件名： " + fileName);
	
	        // 文件后缀
	        String suffixName = fileName.substring(fileName.lastIndexOf("."));
	        System.out.println("文件后缀名： " + suffixName);
	
	        // 重新生成唯一文件名，用于存储数据库
	        String newFileName = UUID.randomUUID().toString()+suffixName;
	        System.out.println("新的文件名： " + newFileName);
	
	        //创建文件
	        File dest = new File("D://deleteme//" + newFileName);
	
	       
	        map.put("filePath", dest.getAbsolutePath());
	       
	        try {
	            file.transferTo(dest);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
        }
        rb.setResult(map);
        return rb.success();
    }
	
}
