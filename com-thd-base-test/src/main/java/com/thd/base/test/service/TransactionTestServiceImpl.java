package com.thd.base.test.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.thd.base.test.dao.TransactionTestRepository;
import com.thd.base.test.entity.TransactionTest;

@Service
public class TransactionTestServiceImpl implements TransactionTestService{
	@Autowired
	private TransactionTestRepository transactionTestRepository;
	
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public Integer testTransaction() {
		System.out.println(" --- begin --- ");
		Optional<TransactionTest> t = transactionTestRepository.findById("1");
		TransactionTest transactionTest = null;
		if(!t.isPresent()){
			transactionTest = new TransactionTest();
			transactionTest.setId("1");
			transactionTest.setCt(0);
			this.transactionTestRepository.save(transactionTest);
		}else{
			transactionTest = t.get();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Integer ct = transactionTest.getCt();
		if(ct == null){
			ct = 0;
		}
		ct ++;
		transactionTest.setCt(ct);
		transactionTest.setName(Thread.currentThread().getName());
		this.transactionTestRepository.saveAndFlush(transactionTest);
		System.out.println(" --- finish --- ");
		return ct;
	}

	@Transactional
	public TransactionTest testTransactionLock(){
		System.out.println(" --- begin --- ");
		Optional<TransactionTest> t = transactionTestRepository.findById("1");
		TransactionTest transactionTest = null;
		if(!t.isPresent()){
			transactionTest = new TransactionTest();
			transactionTest.setId("1");
			transactionTest.setCt(0);
			transactionTest.setVersion(0l);
			this.transactionTestRepository.save(transactionTest);
		}else{
			transactionTest = t.get();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("version："+transactionTest.getVersion());
		Integer ct = transactionTest.getCt();
		if(ct == null){
			ct = 0;
		}
		ct ++;
		transactionTest.setCt(ct);
		transactionTest.setName(Thread.currentThread().getName());
		this.transactionTestRepository.saveAndFlush(transactionTest);
		System.out.println(" --- finish --- ");
		return transactionTest;
	};
	

}
