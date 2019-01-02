package com.thd.base.test.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.thd.base.test.entity.Person;

public interface PersonService {
	public List queryAllPerson();
	
	@Transactional
	public void savePerson(Person p);
	
	
	
}
