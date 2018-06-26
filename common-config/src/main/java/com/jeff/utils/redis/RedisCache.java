package com.jeff.utils.redis;

import java.lang.annotation.*;

/**
 * Redis 缓存的注解
 * Created by Jeff on 2018/6/25.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {

    /**
     * 键
     * @return
     */
    String key() default "";

    /**
     * 过期时间，默认不过期
     * 以秒为单位
     * @return
     */
    long expired() default -1;

    /**
     * 是否为查询操作
     * 如果为写入数据库的操作，该值需置为 false
     * @return
     */
    boolean read() default true;
}
