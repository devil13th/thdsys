package com.thd.base.test.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thd.base.test.entity.Person;
import com.thd.base.test.service.RedisService;
import com.thd.core.bean.ResponseBean;
import com.thd.core.controller.BaseController;
@Controller
@RequestMapping(value="/redis")
public class RedisController extends BaseController {
	//StringRedisTemplate 键值对都是字符串 (value一般使用json格式的字符串)
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	
	//RedisTemplate 可以自定义键值对序列化器,参见RedisConfig.java
    @Autowired 
    private RedisTemplate myRedisTemplate;
    
    @Autowired
    private RedisService redisService;
    
    @ResponseBody
    //@GetMapping("/get/{key}")
    @RequestMapping(value="/get/{key}",method=RequestMethod.GET)
    public String getRedis(@PathVariable(name="key") String key){
    	System.out.println(myRedisTemplate);
        return stringRedisTemplate.opsForValue().get(key);
    }
    
    @ResponseBody
    //@GetMapping("/set/{key}/{value}")
    @RequestMapping(value="/set/{key}/{value}",method=RequestMethod.GET)
    public String getRedis(@PathVariable(name="key")String key,@PathVariable(name="value")String value){
    	System.out.println(key);
    	System.out.println(value);
        stringRedisTemplate.opsForValue().set(key,value);
        return "SUCCESS";
    }
    
    @ResponseBody
    @GetMapping("/postEntity/{id}")
    public String postEntity(@PathVariable(name="id") String id){
    	Person p=new Person();
        p.setId(id); 
        p.setName("pwl");
        p.setAge(25);
        myRedisTemplate.opsForValue().set(p.getId(),p);
        System.out.println(1234);
        //stringRedisTemplate.opsForValue().set(p.getId(),JSON.toJSON(p).toString());
        //myRedisTemplate.opsForValue().set(p.getId(),p);
        return "SUCCESS";
    }
    
    @ResponseBody
    @GetMapping("/getEntity/{key}")
    public Object getEntity(@PathVariable(name="key")String key){
        return myRedisTemplate.opsForValue().get(key);
    }
    
    
    //测试缓存 - 新增
    @ResponseBody
    @RequestMapping(value="/cache/add",method=RequestMethod.GET)
    public ResponseEntity<ResponseBean> cacheAdd(){
    	Person p = new Person();
    	p.setAddress(String.valueOf(Math.random()));
    	p.setAge(5);
    	p.setBirthday(new Date());
    	p.setName("devil13th");
    	p = redisService.add(p);
    	ResponseBean rb = new ResponseBean();
		rb.setResult(p);
		return rb.success();
    }
    
    //测试缓存 - 修改
    @ResponseBody
    @RequestMapping(value="/cache/update/{id}",method=RequestMethod.GET)
    public ResponseEntity<ResponseBean> cacheUpdate(@PathVariable String id){
    	Person p = this.redisService.query(id);
    	p.setAddress(String.valueOf(Math.random()));
    	p.setAge(20);
    	p.setBirthday(new Date());
    	p.setName("devil13th");
    	redisService.update(p);
    	ResponseBean rb = new ResponseBean();
		rb.setResult(p);
		return rb.success();
    }
    
    
    //测试缓存 - 查询
    @ResponseBody
    @RequestMapping(value="/cache/query/{id}",method=RequestMethod.GET)
    public ResponseEntity<ResponseBean> cacheQuery(@PathVariable String id){
    	Object o = this.redisService.query(id);
    	Person p = this.redisService.query(id);
    	ResponseBean rb = new ResponseBean();
		rb.setResult(p);
		return rb.success();
    }
    
    //测试缓存 - 删除 
    @ResponseBody
    @RequestMapping(value="/cache/delete/{id}",method=RequestMethod.GET)
    public ResponseEntity<ResponseBean> cacheDelete(@PathVariable String id){
    	Boolean r = this.redisService.delete(id);
    	ResponseBean rb = new ResponseBean();
		rb.setResult(r);
		return rb.success();
    }
    
    
    //测试缓存
    @ResponseBody
    @RequestMapping(value="/cache/add/{i}",method=RequestMethod.GET)
    public ResponseEntity<ResponseBean> cacheAdd(@PathVariable Integer i){
    	String r = this.redisService.add(i);
    	ResponseBean rb = new ResponseBean();
		rb.setResult(r);
		return rb.success();
    }
    
  //测试缓存
    @ResponseBody
    @RequestMapping(value="/cache/multi/{i}",method=RequestMethod.GET)
    public ResponseEntity<ResponseBean> cacheMulti(@PathVariable Integer i){
    	String r = this.redisService.multi(i);
    	ResponseBean rb = new ResponseBean();
		rb.setResult(r);
		return rb.success();
    }


	
}
