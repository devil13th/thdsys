package com.thd.base.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionTestRepositoryImpl implements
		TransactionTestRepositoryCustom {
	
	

	@Autowired
    @PersistenceContext
    private EntityManager myEntityManager;
	
	@Override
	public List test() {
		System.out.println("transaction custom repository test");
		return null;
	}
}
