package com.thd.module.note.dao;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.thd.module.note.pojo.ModNoteContent;
import com.thd.core.dao.BaseRepository;

public interface ModNoteContentDao  extends BaseRepository<ModNoteContent, java.lang.String> {
}
