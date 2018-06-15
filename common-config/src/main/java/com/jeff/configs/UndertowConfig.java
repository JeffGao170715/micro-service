package com.jeff.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.embedded.undertow.UndertowReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 配置 Undertow
 * Created by Jeff on 2018/6/15.
 */
@SpringBootConfiguration
public class UndertowConfig {
    private final static Logger logger = LoggerFactory.getLogger(UndertowConfig.class);

    @Bean
    public UndertowReactiveWebServerFactory undertowReactiveWebServerFactory(){
        logger.info("<====== 加载 Undertow 配置 =======>");
        UndertowReactiveWebServerFactory factory = new UndertowReactiveWebServerFactory();
        int cpuNum = Runtime.getRuntime().availableProcessors();    // 可用的CPU数目
        factory.setIoThreads(cpuNum);
        factory.setWorkerThreads(cpuNum << 3);      // CPU 数目的 8 倍

        return factory;
    }
}
