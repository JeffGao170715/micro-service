package com.jeff.configs;

import com.jeff.Interceptor.JeffServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 网络请求拦截规则
 * Created by Jeff on 2018/6/15.
 */
@SpringBootConfiguration
public class WebInterceptor implements WebMvcConfigurer {
    private final static Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("<====== 添加拦截规则 ======>");
        registry.addInterceptor(new JeffServlet()).addPathPatterns("/**/*.json");      // 拦截规则
    }


}
