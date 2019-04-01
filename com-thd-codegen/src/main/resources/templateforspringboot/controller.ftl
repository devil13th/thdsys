package ${cfg.actionPackage};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ${cfg.servicePackage}.${cfg.serviceName};
import ${cfg.pojoPackage}.${cfg.tableCodeForClass};
import com.thd.core.bean.ResponseBean;
import com.thd.utils.myutils.bean.QueryBeanForWeb;


@Controller
@RequestMapping(value="/${cfg.nameSpace}/${cfg.urlActionName}")
public class ${cfg.tableCodeForClass}Controller {
	
	@Autowired
	private ${cfg.serviceName} ${cfg.serviceNameForProperty};
	
	/**
	 * api介绍
	 * @return
	 */
	@RequestMapping(value="/api",method=RequestMethod.GET)
	public String api(){
		ResponseBean rb = new ResponseBean();
		return "/${cfg.nameSpace}/${cfg.jspPath}/api";
	}
	
	/**
	 * 查询所有${cfg.tableCodeForClass}
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> queryAll${cfg.tableCodeForClass}(){
		ResponseBean rb = new ResponseBean();
		List l = this.${cfg.serviceNameForProperty}.queryAll${cfg.tableCodeForClass}();
		rb.setResult(l);
		return rb.success();
	}
	
	/**
	 * 查询${cfg.tableCodeForClass} 使用QueryBeanForWeb封装分页排序和查询条件
	 * current : 当前页  整数  非必填
	 * pageSize : 每页行数 整数 非必填
	 * sort : 排序列名称  字段名称 非必填
	 * order : 排序规则 ASC DESC 非必填
	 * queryParams : 查询条件  json字符串  非必填
	 * @return 
	 */
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> query${cfg.tableCodeForClass}(HttpServletRequest request){
		ResponseBean rb = new ResponseBean();
		//封装 分页 排序 查询条件到QueryBeanForWeb对象
		QueryBeanForWeb qb = new QueryBeanForWeb(request);
		this.${cfg.serviceNameForProperty}.query${cfg.tableCodeForClass}(qb);
		rb.setResult(qb);
		return rb.success();
	}
	
	/**
	 * 根据ID查询${cfg.tableCodeForClass}对象
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> querySysPersonById(@PathVariable(name="id") String entityId ){
		ResponseBean rb = new ResponseBean();
		${cfg.tableCodeForClass} u = this.${cfg.serviceNameForProperty}.query${cfg.tableCodeForClass}ById(entityId);
		rb.setResult(u);
		return rb.success();
	}
	
	
	
	/**
	 * 新增${cfg.tableCodeForClass}
	 * @param ${cfg.tableCodeForProperty} ${cfg.tableCodeForClass}对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseBean> save${cfg.tableCodeForClass}(@RequestBody ${cfg.tableCodeForClass} ${cfg.tableCodeForProperty}){
		${cfg.tableCodeForClass} u = this.${cfg.serviceNameForProperty}.save${cfg.tableCodeForClass}(${cfg.tableCodeForProperty});
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	
	/**
	 * 更新${cfg.tableCodeForClass}
	 * @param ${cfg.tableCodeForProperty} ${cfg.tableCodeForClass}对象
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ResponseBean> update${cfg.tableCodeForClass}(@RequestBody ${cfg.tableCodeForClass} ${cfg.tableCodeForProperty}){
		${cfg.tableCodeForClass} u = this.${cfg.serviceNameForProperty}.update${cfg.tableCodeForClass}(${cfg.tableCodeForProperty});
		ResponseBean rb = new ResponseBean();
		rb.setResult(u);
		return rb.success();
	}
	
	/**
	 * 根据id删除${cfg.tableCodeForClass}
	 * @param id ${cfg.tableCodeForClass}对象ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<ResponseBean> delete${cfg.tableCodeForClass}ById(@PathVariable String id) throws Exception {
		if(StringUtils.isEmpty(id)){
			throw new Exception("id not be found");
		}
		if(this.${cfg.serviceNameForProperty}.query${cfg.tableCodeForClass}ById(id) == null){
			throw new Exception("not found ${cfg.tableCodeForClass} id:[" + id + "]");
		}
		this.${cfg.serviceNameForProperty}.delete${cfg.tableCodeForClass}ById(id);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	/**
	 * 根据id删除${cfg.tableCodeForClass} 多个id用","隔开
	 * @param id ${cfg.tableCodeForClass}对象ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/delete${cfg.tableCodeForClass}Batch/{ids}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseBean> delete${cfg.tableCodeForClass}Batch(@PathVariable String ids) throws Exception {
		
		this.${cfg.serviceNameForProperty}.delete${cfg.tableCodeForClass}Batch(ids);
		ResponseBean rb = new ResponseBean();
		rb.setResult(null);
		return rb.success();
	}
	
	
}
