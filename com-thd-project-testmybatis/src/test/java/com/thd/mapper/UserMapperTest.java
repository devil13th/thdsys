package com.thd.mapper;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thd.mybatis.entity.User;
import com.thd.mybatis.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	@Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
    	
    	for(int i = 0 , j = 5 ; i < j ; i++){
    		User u = new User();
    		u.setAge(i);
    		u.setBirthday(new Date());
    		u.setId(UUID.randomUUID().toString().replace("-", ""));
    		u.setName("name_" + i);
    		u.setPassword("p_" + i);
    		u.setSex(1);
    		userMapper.insert(u);
    		
    	}

    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.getAll();
        System.out.println(users.toString());
    }


    @Test
    public void testUpdate() throws Exception {
        User user = userMapper.getOne(30l);
        System.out.println(user.toString());
        user.setName("neo");
        userMapper.update(user);
        Assert.assertTrue(("neo".equals(userMapper.getOne(30l).getName())));
    }
}
