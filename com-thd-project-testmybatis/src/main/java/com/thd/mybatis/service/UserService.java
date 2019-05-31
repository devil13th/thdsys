package com.thd.mybatis.service;

import java.util.Map;

import com.thd.mybatis.entity.User;

public interface UserService {
	public void save(User u);
	public Map queryById(Long id);
}
