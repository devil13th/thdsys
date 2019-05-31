package com.thd.mybatis.service;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thd.mybatis.entity.User;
import com.thd.mybatis.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Transactional
	public void save(User u){
		userMapper.insert(u);
		int i = 1/0;
		User u1 = new User();
		u1.setId(UUID.randomUUID().toString().replace("-",""));
		u1.setUserName("devil");
		u1.setAge(5);
		u1.setPassword("1234");
		u1.setSex(1);
		userMapper.insert(u1);
	};
	

	public Map queryById(Long id){
		return userMapper.getOneMap(id);
	};
}
