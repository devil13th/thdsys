package com.thd.common.infrastructure.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thd.common.infrastructure.pojo.SysOrg;
import com.thd.core.dao.BaseRepository;

public interface SysOrgDao  extends BaseRepository<SysOrg, String> {
	@Query(value="select "
			+ "org_id as org_id, "
			+ "org_code as org_code,"
			+ "org_tree_code as org_tree_code,"
			+ "org_name as org_name,"
			+ "org_is_leaf as org_is_leaf "
			+ "from sys_org where org_name like %:name%",
			nativeQuery = true)
	public List<Map> queryOrgByName(@Param("name") String name);
	
	
}
