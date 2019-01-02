package com.thd.core.redis;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RedisConfig {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Bean("myRedisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
 
        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
 
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        // 设置key的序列化器    (RedisTemplate.opsForValue().set(k,v)方法使用k的序列化使用jackson2JsonRedisSerializer进行序列化)
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置value的序列化器(RedisTemplate.opsForValue().set(k,v)方法使用v的序列化使用jackson2JsonRedisSerializer进行序列化)
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        
        
        //redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        //redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        //redisTemplate.setValueSerializer(new StringRedisSerializer());
        logger.info(redisTemplate.getKeySerializer().toString());
        logger.info(redisTemplate.getValueSerializer().toString());
        
        //redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        
        
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
	
	
	
	//缓存管理器
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        
    	
    	//JacksonJsonRedisSerializer和GenericJackson2JsonRedisSerializer，两者都能系列化成json，
    	//但是后者会在json中加入@class属性，类的全路径包名，方便反系列化。
    	//前者如果存放了List则在反系列化的时候如果没指定TypeReference(指定泛型类型)则会报错java.util.LinkedHashMap cannot be cast to ...
    	
    	
    	
        //Jackson2JsonRedisSerializer<Person> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Person>(Person.class);
        //RedisSerializationContext.SerializationPair<Person> jsonPair = RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer);
    	
    	GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
    	RedisSerializationContext.SerializationPair<Object> jsonPair = RedisSerializationContext.SerializationPair.fromSerializer(genericJackson2JsonRedisSerializer);
        
    	RedisSerializationContext.SerializationPair<String> stringPair = RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
        
        
        
        //使用默认缓存配置，并且该配置,  设置key的序列化器 - key转换为字符串 ,设置value的序列化器- value转换为java的序列化
        RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig();
        
        
        //使用默认缓存配置，并且该配置  , 设置key的序列化器 - key转换为字符串 ,设置value的序列化器- value转换为json
        // RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig().serializeKeysWith(keyPair).serializeValuesWith(valuePair);
        
        
        // 返回一个key的序列化器 - key转换为字符串 
        //defaultCacheConfig.serializeKeysWith(keyPair);
        // 返回一个value的序列化器- value转换为json
        //defaultCacheConfig.serializeValuesWith(valuePair);
        
        

        // 设置一个初始化的缓存空间set集合    例如person是一个缓存空间名字(可以理解为名为perosn的一组缓存), user也是一个缓存空间的名字
        // person中可以通过id属性的值定义缓存的key
        // user中可以通过id属性的值定义缓存的key
        //cacheNames的使用参见RedisServiceImpl.java中 @CachePut @CacheEvict @Cacheable注释的value属性
        Set<String> cacheNames =  new HashSet<>();
        cacheNames.add("person");
        cacheNames.add("math");

        // 对每个缓存空间应用不同的配置  可以为每一个缓存空间定义其使用的缓存配置(比如缓存配置中的key的序列化器，value的序列化器,缓存时间等内容)
        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        // defaultCacheConfig.serializeKeysWith和serializeValuesWith方法均会返回一个新的RedisCacheConfiguration对象
        //这个配置定义了key和value的序列化器
        configMap.put("person", defaultCacheConfig.serializeKeysWith(stringPair).serializeValuesWith(jsonPair));
        // defaultCacheConfig.entryTtl(Duration.ofSeconds(120)) 会返回一个新的RedisCacheConfiguration对象
        //这个配置定义了缓存时间为120秒
        configMap.put("math", defaultCacheConfig.serializeKeysWith(stringPair).serializeValuesWith(stringPair).entryTtl(Duration.ofSeconds(120)));
        
        //可根据不同的缓存名称设置不同的缓存配置(上面cacheNames(缓存名称)中的每个元素与configMap(缓存配置)中的每个元素相对应)
        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)     // 使用自定义的缓存配置初始化一个cacheManager
                .initialCacheNames(cacheNames)  // 注意这两句的调用顺序，一定要先调用该方法设置初始化的缓存名，再初始化相关的配置
                .withInitialCacheConfigurations(configMap)
                .build();
        return cacheManager; 
    }
    
    

}
