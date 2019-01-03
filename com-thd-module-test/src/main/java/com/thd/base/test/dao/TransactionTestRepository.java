package com.thd.base.test.dao;

import org.springframework.stereotype.Repository;

import com.thd.base.test.entity.TransactionTest;
import com.thd.core.dao.BaseRepository;
@Repository
public interface TransactionTestRepository extends BaseRepository<TransactionTest, String> {

}
