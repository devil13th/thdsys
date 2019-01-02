package com.thd.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.thd.core.bean.Page;
/**
 *这个实现类比较的简单，首先我们需要继承SimpleJpaRepository，
 * SimpleJpaRepository帮助我们实现了JpaRepository中的方法。
 * 然后实现BaseRepository接口。
 */
public class BaseRepositoryImpl<T, ID extends Serializable>  extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID >{
	
	private EntityManager entityManager;
	
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}
	
	@Override
	public List<Map<String, Object>> query(String sql, Object[] params,
			Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		System.out.println("公共自定义repository 方法调用");
		System.out.println(this.entityManager);
		return null;
	}

	@Override
	public List<Map<String, Object>> query(String sql, Object[] params, Page p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryCount(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
