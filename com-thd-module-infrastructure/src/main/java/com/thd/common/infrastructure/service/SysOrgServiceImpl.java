package com.thd.common.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.common.infrastructure.dao.SysOrgDao;
import com.thd.common.infrastructure.pojo.SysOrg;
import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyStringUtils;
@Service
public class SysOrgServiceImpl implements SysOrgService {
	@Autowired
	private SysOrgDao sysOrgDao;
	@Autowired
	private JdbcDao jdbcDao;
	
	@Override
	public List queryAllSysOrg() {
		return sysOrgDao.findAll();
	}

	@Override
	public SysOrg querySysOrgById(String id) {
		Optional<SysOrg> r = sysOrgDao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
	}

	@Override
	public void deleteSysOrgById(String id) {
		this.sysOrgDao.deleteById(id);

	}

	@Override
	public SysOrg saveSysOrg(SysOrg sysOrg) {
		return this.sysOrgDao.save(sysOrg);
	}

	@Override
	public SysOrg updateSysOrg(SysOrg sysOrg) {
		if(sysOrg == null){
			throw new RuntimeException("sysOrg can not be null" );
		}
		if(MyStringUtils.isEmpty(sysOrg.getOrgId())){
			throw new RuntimeException("sysOrg's id can not be null" );
		}
		SysOrg org = this.querySysOrgById(sysOrg.getOrgId());
		if(org != null){
			return this.sysOrgDao.saveAndFlush(sysOrg);
		}else{
			throw new RuntimeException("SysOrg not be found id:[" + sysOrg.getOrgId() + "]");
		}
	}

	@Override
	public SysOrg saveOrUpdateSysOrg(SysOrg sysOrg) {
		return this.sysOrgDao.saveAndFlush(sysOrg);
	}

	@Override
	public List querySysOrg(Map m) {
		String sql = "select "
				+ "org_id as org_id, "
				+ "org_code as org_code,"
				+ "org_tree_code as org_tree_code,"
				+ "org_name as org_name,"
				+ "org_is_leaf as org_is_leaf "
				+ "from sys_org  "
				+ " where 1=1 ";
		List params = new ArrayList();
		
		if(m.get("orgName") != null && MyStringUtils.isNotEmpty(m.get("orgName").toString())){
			sql += " and (upper(org_name) like upper(?) or upper(org_code) like upper(?) )";
			params.add("%" + m.get("orgName").toString().trim() + "%");
			params.add("%" + m.get("orgName").toString().trim() + "%");
		}
		
		List r = this.jdbcDao.query(sql, params.toArray(), null);
		return r;
	}

}
