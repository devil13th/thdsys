package com.thd.common.infrastructure.dao;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.thd.common.infrastructure.pojo.ReactCodegenTest;
import com.thd.core.dao.BaseRepository;

public interface ReactCodegenTestDao  extends BaseRepository<ReactCodegenTest, java.lang.String> {
}
