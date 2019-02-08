package com.thd.common.infrastructure.dao;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.thd.common.infrastructure.pojo.SysDicPub;
import com.thd.core.dao.BaseRepository;

public interface SysDicPubDao  extends BaseRepository<SysDicPub, java.lang.String> {
}
