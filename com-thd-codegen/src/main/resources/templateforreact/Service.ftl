import rpc from '../../../utils/rpc';
import REQUEST_URL from '../../../constant/sysVar';
//查询字典分类


//查询${cfg.tableName}
export async function fetchQuery${cfg.tableCodeForClass}(queryExtraBean, queryConditionBean) {
  return rpc.fetch(REQUEST_URL.${cfg.tableCodeForUpper}.QUERY, { ...queryExtraBean, ...queryConditionBean });
}

//保存${cfg.tableName}
export async function fetchSave${cfg.tableCodeForClass}(params) {
  return rpc.post(REQUEST_URL.${cfg.tableCodeForUpper}.SAVE, params);
}

//删除${cfg.tableName}
export async function fetchDelete${cfg.tableCodeForClass}(params) {
  return rpc.delete(REQUEST_URL.${cfg.tableCodeForUpper}.DELETE + params);
}

//批量删除${cfg.tableName}
export async function fetchDelete${cfg.tableCodeForClass}Batch(params) {
  return rpc.fetch(REQUEST_URL.${cfg.tableCodeForUpper}.DELETEBATCH + params);
}

//查询单个${cfg.tableName}
export async function fetchGet${cfg.tableCodeForClass}(params) {
  return rpc.fetch(REQUEST_URL.${cfg.tableCodeForUpper}.GET + "/" + params);
}

//更新${cfg.tableName}
export async function fetchUpdate${cfg.tableCodeForClass}(params) {
  return rpc.put(REQUEST_URL.${cfg.tableCodeForUpper}.UPDATE, params);
}



