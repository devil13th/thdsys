package com.thd.base.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.thd.base.test.dao.PersonRepository;
import com.thd.base.test.entity.Person;
/**
 * 测试redis缓存
 * @author wangl
 *
 */
@Service
public class RedisServiceImpl implements RedisService {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	/**
	* - @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
	*/
	@CachePut(value = "person", key = "#root.targetClass + #result.id", unless = "#p eq null")
	public Person add(Person p) {
		System.out.println("新增用户");
		personRepository.save(p);
		return p;
	}

	/**
	* - @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
	*/
	@CacheEvict(value = "person", key = "#root.targetClass + #id", condition = "#result eq true")
	public boolean delete(String id) {
		try{
			System.out.println("删除用户");
			this.personRepository.delete(this.query(id));
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/**
	* - @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
	*/
	@CachePut(value = "person", key = "#root.targetClass + #p.id", unless = "#p eq null")
	public Person update(Person p) {
		System.out.println("更新用户");
		this.personRepository.saveAndFlush(p);
		return p;
	}
	
	//@Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有则执行方法，然后把方法执行的结果添加到缓存中
	//unless 表示条件表达式成立的话不放入缓存
	@Cacheable(value = "person", key = "#root.targetClass + #id", unless = "#result eq null")
	public Person query(String id) { 
		System.out.println("查询用户");
		Person p = this.personRepository.findById(id).get();
		return p; 
	}
	
	
	
	@Cacheable(value = "math", key = "#root.method.name + #i", unless = "#result eq null")
	public String add(Integer i){
		System.out.println("未使用缓存");
		return String.valueOf(i + i);
	};
	
	@Cacheable(value = "math", key = "#root.method.name + #i", unless = "#result eq null")
	public String multi(Integer i){
		System.out.println("未使用缓存");
		return String.valueOf(i * i);
	};
	
	
}
