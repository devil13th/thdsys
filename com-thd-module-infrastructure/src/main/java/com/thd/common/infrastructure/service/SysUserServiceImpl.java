package com.thd.common.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.common.infrastructure.dao.SysUserDao;
import com.thd.common.infrastructure.pojo.SysUser;
import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyStringUtils;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private JdbcDao jdbcDao;
	
	public List queryAllSysUser(){
		return sysUserDao.findAll();
	};
	public SysUser querySysUserById(String id) {
		
		Optional<SysUser> r = sysUserDao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
				//此方法是懒加载
		//return sysUserDao.getOne(id);
	}
	public void deleteSysUserById(String id){
		this.sysUserDao.deleteById(id);
	};
	public SysUser saveSysUser(SysUser sysUser){
		return this.sysUserDao.save(sysUser);
	};
	public SysUser updateSysUser(SysUser sysUser){
		if(sysUser == null){
			throw new RuntimeException("SysUser can not be null" );
		}
		if(MyStringUtils.isEmpty(sysUser.getUserId())){
			throw new RuntimeException("SysUser's id can not be null" );
		}
		SysUser u = this.querySysUserById(sysUser.getUserId());
		if(u != null){
			return this.sysUserDao.saveAndFlush(sysUser);
		}else{
			throw new RuntimeException("SysUser not be found id:[" + sysUser.getUserId() + "]");
		}
		
	}
	public SysUser saveOrUpdateSysUser(SysUser sysUser){
		return this.sysUserDao.saveAndFlush(sysUser);
	}
	public List querySysUser(Map m){
		String sql = " select "
				+ " user_id as user_id,"
				+ " user_name as user_name,"
				+ " user_account as user_account,"
				+ " user_password as user_password,"
				+ " company_name as company_name,"
				+ " user_mail as user_mail "
				+ " from sys_user u "
				+ " where 1=1 ";
		List params = new ArrayList();
		
		if(m.get("userName") != null && MyStringUtils.isNotEmpty(m.get("userName").toString())){
			sql += " and (upper(user_name) like upper(?) or upper(user_account) like upper(?) or upper(user_mail) like upper(?))";
			params.add("%" + m.get("userName").toString().trim() + "%");
			params.add("%" + m.get("userName").toString().trim() + "%");
			params.add("%" + m.get("userName").toString().trim() + "%");
		}
		
		List r = this.jdbcDao.query(sql, params.toArray(), null);
		return r;
		
	};
}
