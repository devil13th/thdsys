package com.thd.concurrence.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
	
	// 测试单例
    public static void test01() {
        JedisPool A = JedisPoolUtil.getJedisPoolInstance();
        JedisPool B = JedisPoolUtil.getJedisPoolInstance();

        System.out.println(A == B);
    }
    
    
    public static long push(int i){
    	 Jedis jedis = null;
         JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
         try {
             jedis = jedisPool.getResource();  // 获取Redus连接
             jedis.incr("ct");
             // 业务
             jedis.lpush("list", String.valueOf(i));
             return jedis.llen("list");
         } finally {
             jedis.close(); // 关闭redis连接
         }
    }
    
    public static void clearRedis(){
   	 Jedis jedis = null;
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        try {
            jedis = jedisPool.getResource();  // 获取Redus连接
            jedis.set("ct","0");
            // 业务
            jedis.del("list");
        } finally {
            jedis.close(); // 关闭redis连接
        }
   }
    
    public static void test02() {
        Jedis jedis = null;
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        try {
            jedis = jedisPool.getResource();  // 获取Redus连接
            
            // 业务
            jedis.set("k1", "v111");
            System.out.println(jedis.get("k1"));
        } finally {
            jedis.close(); // 关闭redis连接
        }
    }
}
