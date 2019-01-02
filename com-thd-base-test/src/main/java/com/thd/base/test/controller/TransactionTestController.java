package com.thd.base.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.base.test.dao.TransactionTestRepositoryCustom;
import com.thd.base.test.entity.TransactionTest;
import com.thd.base.test.service.TransactionTestService;
import com.thd.core.bean.ResponseBean;
import com.thd.core.controller.BaseController;
@Controller
@RequestMapping(value="/transactionTest")
public class TransactionTestController extends BaseController{
	@Autowired
	private TransactionTestService transactoinTestService;
	@Autowired
	private TransactionTestRepositoryCustom transactoinTestRepository;
	
	
	
	/**
	 * 测试事务隔离机制(isolation=Isolation.SERIALIZABLE)
	 */
	@RequestMapping(value="/testTransaction")
	@ResponseBody
	public ResponseEntity<ResponseBean> testTransaction(){
		Integer ct = transactoinTestService.testTransaction();
		ResponseBean rb = new ResponseBean();
		rb.setResult(ct);
		return rb.success();
	}
	
	/**
	 * 测试乐观锁
	 */
	@RequestMapping(value="/testTransactionLock")
	@ResponseBody
	public ResponseEntity<ResponseBean> testTransactionLock(){
		TransactionTest t = transactoinTestService.testTransactionLock();
		ResponseBean rb = new ResponseBean();
		rb.setResult(t);
		return rb.success();
	}
	
	
	/**
	 * 测试自定义非公共的repository
	 */
	@RequestMapping(value="/testCustomTransactionTestRepository")
	@ResponseBody
	public ResponseEntity<ResponseBean> testCustomTransactionTestRepository(){
		ResponseBean rb = new ResponseBean();
		this.getLogger().info(this.transactoinTestRepository.toString());
		rb.setResult(transactoinTestRepository.test());
		return rb.success();
	}
}
