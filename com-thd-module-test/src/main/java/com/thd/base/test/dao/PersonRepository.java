package com.thd.base.test.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thd.base.test.entity.Person;
import com.thd.core.dao.BaseRepository;
/**
 * 1. Repository 是一个空接口. 即是一个标记接口
 * 2. 若我们定义的接口继承了 Repository, 则该接口会被 IOC 容器识别为一个 Repository Bean.
 * 纳入到 IOC 容器中. 进而可以在该接口中定义满足一定规范的方法. 
 * 
 * 3. 实际上, 也可以通过 @RepositoryDefinition 注解来替代继承 Repository 接口
 * 
 * 
 * Repository 是一个标记接口，表明任何继承他的均为仓库类接口 定义满足一定规范的方法(大部分是查询)
 *   |- CrudRepository 继承Repository 实现了CRUD相关方法
 *        |- PagingAndSortingRepository : 继承CurdRepository 实现了一组分页排序相关方法
 *             |- JpaRepository : 继承PagingAndSortingRepository 实现了一组Jpa相关方法
 * 
 * 
 */
/**
 * 在 Repository 子接口中声明方法
 * 1. 不是随便声明的. 而需要符合一定的规范
 * 2. 查询方法以 find | read | get 开头
 * 3. 涉及条件查询时，条件的属性用条件关键字连接
 * 4. 要注意的是：条件属性以首字母大写。
 * 5. 支持属性的级联查询. 若当前类有符合条件的属性, 则优先使用, 而不使用级联属性. 
 * 若需要使用级联属性, 则属性之间使用 _ 进行连接. 
 */
//public interface PersonRepository extends JpaRepository<Person, String> {
public interface PersonRepository extends BaseRepository<Person, String> {	
	//nativeQuery = true 即可使用原生的查询
	@Query(value="select id as id, name as name,age as age,birthday as bir,address as addr from person where name like %:name%",nativeQuery = true)
	public List<Map> queryByName(@Param("name") String name);
	
	
	@Query(value="select id as id, name as name,age as age,birthday as bir,address as addr from person where addr like %:addr%",nativeQuery = true)
	public List<Map> queryByAddr(@Param("addr") String addr,Pageable pageable);
	
}
