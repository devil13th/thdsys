package com.thd.common.infrastructure.dao;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ${cfg.pojoPackage}.${cfg.tableCodeForClass};
import com.thd.core.dao.BaseRepository;

public interface ${cfg.tableCodeForClass}Dao  extends BaseRepository<${cfg.tableCodeForClass}, ${cfg.pkColumn.columnType}> {
}
