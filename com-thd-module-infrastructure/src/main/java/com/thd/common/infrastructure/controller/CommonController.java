package com.thd.common.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.common.infrastructure.service.CommonService;
import com.thd.core.bean.ResponseBean;
import com.thd.utils.myutils.bean.QueryDicBean;

@Controller
@RequestMapping(value="/infrastructure/common")
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	/**
	 * 公共字典数据查询
	 * @return
	 */
	@RequestMapping(value="/querySelectDataSource")
	@ResponseBody
	public ResponseEntity<ResponseBean> querySelectDataSource(QueryDicBean qdb){
		System.out.println("1234");
		ResponseBean rb = new ResponseBean();
		List l = this.commonService.querySelectDataSource(qdb);
		rb.setResult(l);
		return rb.success();
	}
}
