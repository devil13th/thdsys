package com.thd.common.infrastructure.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.thd.core.bean.ResponseBean;

@Controller
@RequestMapping(value="/infrastructure/file")
public class FileController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value="/index",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> index(){
		ResponseBean rb = new ResponseBean();
		this.log.info("index...");
		return rb.success();
	}
	/**
     * 实现文件上传
     * */
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseBean> upload(@RequestParam("fileName") MultipartFile file,@RequestParam("mes") String mes){
    	 ResponseBean rb = new ResponseBean();
    	 
    	 if(file.isEmpty()){
    		rb.setErrMessage("file is null");
            return rb.failure();
        }
        log.info(mes);
        
       
        
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        
        String path = "D:/test" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        Map<String,String> m = new HashMap<String,String>();
        m.put("url", "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_86d58ae1.png");
        try {
            file.transferTo(dest); //保存文件
            rb.setResult(m);
            return rb.success();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            rb.setE(e);
            return rb.failure();
        } catch (IOException e) {
        	rb.setE(e);
            return rb.failure();
        }
        
        
    }
}
