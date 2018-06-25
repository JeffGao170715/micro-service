package com.jeff.configs;

import org.springframework.boot.SpringBootConfiguration;

/**
 * Created by Jeff on 2018/6/25.
 */
@SpringBootConfiguration
public class UserServiceConfiguration extends WebInterceptor implements UndertowConfig, RedisConfig{
}
