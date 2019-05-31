package com.thd.concurrence.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
	private static final String HOST = "127.0.0.1";
    private static final int PORT = 6379;
    
    private static volatile JedisPool jedisPool = null;
    
    private JedisPoolUtil() {}
    
    /**
     * 获取RedisPool实例（单例）
     * @return RedisPool实例
     */
    public static JedisPool getJedisPoolInstance() {
        if (jedisPool == null) {
            synchronized (JedisPoolUtil.class) {
                if (jedisPool == null) {
                    
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(1000);           // 最大连接数
                    poolConfig.setMaxIdle(32);              // 最大空闲连接数
                    poolConfig.setMaxWaitMillis(100*1000);  // 最大等待时间
                    poolConfig.setTestOnBorrow(true);       // 检查连接可用性, 确保获取的redis实例可用
                    
                    jedisPool = new JedisPool(poolConfig, HOST, PORT);
                }
            }
        }
        
        return jedisPool;
    }
    
    /**
     * 从连接池中获取一个 Jedis 实例（连接）
     * @return Jedis 实例
     */
    public static Jedis getJedisInstance() {
        
        return getJedisPoolInstance().getResource();
    }
    
    /**
     * 将Jedis对象（连接）归还连接池
     * @param jedisPool 连接池
     * @param jedis 连接对象
     */
    public static void release(JedisPool jedisPool, Jedis jedis) {
        
        if (jedis != null) {
        	//jedisPool.returnResourceObject(jedis);  // 已废弃，推荐使用jedis.close()方法
        	jedis.close();
        }
    }
}
