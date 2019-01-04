package com.thd.common.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thd.common.infrastructure.dao.SysDicPubDao;
import com.thd.common.infrastructure.pojo.SysDicPub;
import com.thd.core.dao.JdbcDao;
import com.thd.utils.myutils.MyStringUtils;
@Service
@Transactional
public class SysDicPubServiceImpl implements SysDicPubService {
	@Autowired
	private SysDicPubDao sysDicPubDao;
	@Autowired
	private JdbcDao jdbcDao;
	@Override
	public List queryAllSysDicPub() {
		return this.sysDicPubDao.findAll();
	}

	@Override
	public SysDicPub querySysDicPubById(String id) {
		Optional<SysDicPub> r = this.sysDicPubDao.findById(id);
		if(r.isPresent()){
			return r.get();
		}else{
			return null;
		}
	}

	@Override
	public void deleteSysDicPubById(String id) {
		this.sysDicPubDao.deleteById(id);
	}

	@Override
	public SysDicPub saveSysDicPub(SysDicPub sysDicPub) {
		return this.sysDicPubDao.save(sysDicPub);
	}

	@Override
	public SysDicPub updateSysDicPub(SysDicPub sysDicPub) {
		if(sysDicPub == null){
			throw new RuntimeException("SysDicPub can not be null" );
		}
		if(MyStringUtils.isEmpty(sysDicPub.getDicId())){
			throw new RuntimeException("SysDicPub id can not be null" );
		}
		SysDicPub dic = this.querySysDicPubById(sysDicPub.getDicId());
		if(dic != null){
			return this.sysDicPubDao.saveAndFlush(sysDicPub);
		}else{
			throw new RuntimeException("SysUser not be found id:[" + sysDicPub.getDicId() + "]");
		}
	}

	@Override
	public SysDicPub saveOrUpdateSysDicPub(SysDicPub sysDicPub) {
		return this.sysDicPubDao.saveAndFlush(sysDicPub);
	}

	@Override
	public List querySysDicPub(Map m) {
		String sql = " select "
				+ " dic_id as dic_id,"
				+ " dic_classify as dic_classify,"
				+ " dic_name as dic_name,"
				+ " dic_desc as dic_desc "
				+ " from sys_dic_pub d "
				+ " where 1=1 ";
		List params = new ArrayList();
		
		if(m.get("dicName") != null && MyStringUtils.isNotEmpty(m.get("dicName").toString())){
			sql += " and (upper(dic_name) like upper(?) or upper(dic_desc) like upper(?) )";
			params.add("%" + m.get("dicName").toString().trim() + "%");
			params.add("%" + m.get("dicName").toString().trim() + "%");
		}
		
		List r = this.jdbcDao.query(sql, params.toArray(), null);
		return r;
	}

}
