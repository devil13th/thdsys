package  com.thd.common.infrastructure.service;

import java.util.List;
import java.util.Map;

import com.thd.common.infrastructure.pojo.ReactCodegenTest;
import com.thd.utils.myutils.bean.QueryBean;

public interface ReactCodegenTestService {
	/**
	 * 查询所有 公共字典分类
	 * @return
	 */
	public List queryAllReactCodegenTest();
	/**
	 * 根据ID查询公共字典分类
	 * @param id 公共字典分类ID
	 * @return ReactCodegenTest对象
	 */
	public ReactCodegenTest queryReactCodegenTestById(java.lang.String id);
	/**
	 * 根据ID删除公共字典分类
	 * @param id 公共字典分类ID
	 */
	public void deleteReactCodegenTestById(java.lang.String id);
	/**
	 * 根据ID删除公共字典分类,多个id用","隔开
	 * @param ids
	 */
	public void deleteReactCodegenTestBatch(String ids);
	/**
	 * 保存公共字典分类
	 * @param reactCodegenTest ReactCodegenTest对象
	 */
	public ReactCodegenTest saveReactCodegenTest(ReactCodegenTest reactCodegenTest);
	/**
	 * 更新公共字典分类
	 * @param reactCodegenTest ReactCodegenTest对象
	 */
	public ReactCodegenTest updateReactCodegenTest(ReactCodegenTest reactCodegenTest);
	/**
	 * 新增或保存公共字典分类
	 * @param reactCodegenTest ReactCodegenTest对象
	 * @return
	 */
	public ReactCodegenTest saveOrUpdateReactCodegenTest(ReactCodegenTest reactCodegenTest);
	/**
	 * 通用查询
	 * @param reactCodegenTest ReactCodegenTest对象
	 * @return
	 */
	public void queryReactCodegenTest(QueryBean qb);
}
