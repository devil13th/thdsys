package com.thd.base.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.thd.base.test.dao.PersonRepository;
import com.thd.base.test.entity.Person;
import com.thd.core.dao.JdbcDao;
@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private JdbcDao jdbcDaoImpl;
	@Autowired
	private PersonRepository personRepository;
	public List queryAllPerson(){
		String sql = " select * from person";
		List l = this.jdbcDaoImpl.query(sql, null, null);
		return l;
	};
	
	/**
	 * 加了synchronized,锁定该方法所在对象，高并发时该方法排队顺序执行
	 */
	@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRES_NEW)
	synchronized public void savePerson(Person p){
		System.out.println(Thread.currentThread().getName() + " 开始 ");
		for(int i = 0 , j = 5 ; i < j ; i++){
			try {
				Thread.sleep(1000);
				Person ps = new Person();
				ps.setName( Thread.currentThread().getName() + "--" + i);
				ps.setAddress( Thread.currentThread().getName() + "--" + i);
				ps.setAge(i);
				ps.setCreateTime(new Date());
				personRepository.save(ps);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " --- " + i);
			
		}
		
		System.out.println(Thread.currentThread().getName() + " 结束 ");
	};
}
