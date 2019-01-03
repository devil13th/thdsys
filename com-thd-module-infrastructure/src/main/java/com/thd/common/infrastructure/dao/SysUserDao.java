package com.thd.common.infrastructure.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thd.common.infrastructure.pojo.SysUser;
import com.thd.core.dao.BaseRepository;

public interface SysUserDao  extends BaseRepository<SysUser, String> {
	@Query(value="select "
			+ "user_id as user_id, "
			+ "user_name as user_name,"
			+ "user_account as user_account,"
			+ "user_password as user_password,"
			+ "company_name as company_name "
			+ "from sys_user where user_name like %:name%",
			nativeQuery = true)
	public List<Map> queryByName(@Param("name") String name);
	
	
}
