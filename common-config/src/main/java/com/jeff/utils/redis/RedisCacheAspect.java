package com.jeff.utils.redis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Redis 注解的切面类，负责处理使用了ReidsCache注解的方法
 * Created by Jeff on 2018/6/25.
 */
@Component
@Aspect
public class RedisCacheAspect {
    private final static Logger logger = LoggerFactory.getLogger(RedisCacheAspect.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 定义切入点，使用了 @RedisCache 的方法
     */
    @Pointcut("@annotation(RedisCache)")
    public void redisServicePoint(){

    }

    /**
     * 环绕通知，方法拦截器
     */
    @Around("redisServicePoint()")
    public Object WriteReadFromRedis(ProceedingJoinPoint point){
        logger.info("<====== 进入 redisCache 环绕通知 ======>");
        try {
            // 获取RedisCache注解
            RedisCache redisCache = ((MethodSignature)point.getSignature()).getMethod().getAnnotation(RedisCache.class);
            if(redisCache != null && redisCache.read()){
                // 查询操作
                Object obj = redisTemplate.opsForValue().get(redisCache.key());
                if(obj == null){
                    // Redis 中不存在，则从数据库中查找，并保存到 Redis
                    logger.info("<====== Redis 中不存在该记录，从数据库查找 ======>");
                    obj = point.proceed();
                    if(obj != null) {
                        if(redisCache.expired() > 0) {
                            redisTemplate.opsForValue().set(redisCache.key(), obj, redisCache.expired());
                        }else {
                            redisTemplate.opsForValue().set(redisCache.key(), obj);
                        }
                    }
                }

                return obj;
            }
        }catch (Throwable ex){
            logger.error("<====== RedisCache 执行异常: {} ======>", ex);
        }

        return null;
    }
}
