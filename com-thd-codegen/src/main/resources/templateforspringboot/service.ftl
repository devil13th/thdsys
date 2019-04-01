package  ${cfg.servicePackage};

import java.util.List;
import java.util.Map;

import ${cfg.pojoPackage}.${cfg.tableCodeForClass};
import com.thd.utils.myutils.bean.QueryBean;

public interface ${cfg.tableCodeForClass}Service {
	/**
	 * 查询所有 ${cfg.tableName}
	 * @return
	 */
	public List queryAll${cfg.tableCodeForClass}();
	/**
	 * 根据ID查询${cfg.tableName}
	 * @param id ${cfg.tableName}ID
	 * @return ${cfg.tableCodeForClass}对象
	 */
	public ${cfg.tableCodeForClass} query${cfg.tableCodeForClass}ById(${cfg.pkColumn.columnType} id);
	/**
	 * 根据ID删除${cfg.tableName}
	 * @param id ${cfg.tableName}ID
	 */
	public void delete${cfg.tableCodeForClass}ById(${cfg.pkColumn.columnType} id);
	/**
	 * 根据ID删除${cfg.tableName},多个id用","隔开
	 * @param ids
	 */
	public void delete${cfg.tableCodeForClass}Batch(String ids);
	/**
	 * 保存${cfg.tableName}
	 * @param ${cfg.tableCodeForProperty} ${cfg.tableCodeForClass}对象
	 */
	public ${cfg.tableCodeForClass} save${cfg.tableCodeForClass}(${cfg.tableCodeForClass} ${cfg.tableCodeForProperty});
	/**
	 * 更新${cfg.tableName}
	 * @param ${cfg.tableCodeForProperty} ${cfg.tableCodeForClass}对象
	 */
	public ${cfg.tableCodeForClass} update${cfg.tableCodeForClass}(${cfg.tableCodeForClass} ${cfg.tableCodeForProperty});
	/**
	 * 新增或保存${cfg.tableName}
	 * @param ${cfg.tableCodeForProperty} ${cfg.tableCodeForClass}对象
	 * @return
	 */
	public ${cfg.tableCodeForClass} saveOrUpdate${cfg.tableCodeForClass}(${cfg.tableCodeForClass} ${cfg.tableCodeForProperty});
	/**
	 * 通用查询
	 * @param ${cfg.tableCodeForProperty} ${cfg.tableCodeForClass}对象
	 * @return
	 */
	public void query${cfg.tableCodeForClass}(QueryBean qb);
}
