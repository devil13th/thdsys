package com.thd.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.thd.mybatis.entity.User;

public interface UserMapper {
	@Select("SELECT id,user_name,password,name,age,sex,birthday,created,updated FROM tb_user")
    @Results({
    	@Result(property = "id",  column = "id"),
        @Result(property = "user_name",  column = "user_name"),
        @Result(property = "password", column = "password"),
        @Result(property = "name", column = "name"),
        @Result(property = "age", column = "age"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "birthday", column = "birthday"),
        @Result(property = "created", column = "created"),
        @Result(property = "updated", column = "updated")
    })
    public List<User> getAll();
    @Select("SELECT  id,user_name,password,name,age,sex,birthday,created,updated FROM tb_user WHERE id = #{id}")
    @Results({
    	@Result(property = "id",  column = "id"),
        @Result(property = "user_name",  column = "user_name"),
        @Result(property = "password", column = "password"),
        @Result(property = "name", column = "name"),
        @Result(property = "age", column = "age"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "birthday", column = "birthday"),
        @Result(property = "created", column = "created"),
        @Result(property = "updated", column = "updated")
    })
    public User getOne(Long id);
    
    @Select("SELECT  id,user_name,password,name,age,sex,birthday,created,updated FROM tb_user WHERE id = #{id}")
    @Results({
    	@Result(property = "id",  column = "id"),
        @Result(property = "user_name",  column = "user_name"),
        @Result(property = "password", column = "password"),
        @Result(property = "name", column = "name"),
        @Result(property = "age", column = "age"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "birthday", column = "birthday"),
        @Result(property = "created", column = "created"),
        @Result(property = "updated", column = "updated")
    })
    public Map getOneMap(Long id);
    

    @Insert("INSERT INTO tb_user(id,name,user_name,passWord,sex) VALUES(#{id},#{name},#{userName}, #{password}, #{sex})")
    public void insert(User user);

    @Update("UPDATE tb_user SET user_name=#{userName},password=#{password} WHERE id =#{id}")
    public void update(User user);

    @Delete("DELETE FROM tb_user WHERE id =#{id}")
    public void delete(Long id);
}
