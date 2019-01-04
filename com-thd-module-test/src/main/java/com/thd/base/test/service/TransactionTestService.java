package com.thd.base.test.service;

import com.thd.base.test.entity.TransactionTest;

public interface TransactionTestService {
	/**
	 * 测试事务并发
	 */
	public Integer testTransaction();
	
	/**
	 * 测试乐观锁
	 */
	public TransactionTest testTransactionLock();
}
