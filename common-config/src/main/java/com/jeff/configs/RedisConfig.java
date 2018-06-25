package com.jeff.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;

/**
 * redis 配置接口，默认配置序列化方式
 * 客户端可根据需要自行定义覆盖
 * Created by Jeff on 2018/6/25.
 */
public interface RedisConfig {

    static Logger getLogger(){
        return LoggerFactory.getLogger(RedisConfig.class);
    }

    @Bean
    default RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
        getLogger().info("<====== 配置Redis序列化方式 ======>");
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // key 的序列化采用 StringRedisSerializer 序列化方式
        RedisSerializer<String> keySerializer = new StringRedisSerializer();
        template.setKeySerializer(keySerializer);
        template.setHashKeySerializer(keySerializer);
        // value 的序列化采用 fastjson 序列化
        RedisSerializer<Object> valueSerializer = new GenericFastJsonRedisSerializer();
        template.setValueSerializer(valueSerializer);
        template.setHashValueSerializer(valueSerializer);

        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }
}
