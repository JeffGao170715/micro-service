package com.jeff.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 自定义拦截器
 * Created by Jeff on 2018/6/15.
 */
public class JeffServlet extends HandlerInterceptorAdapter {
    private final static Logger logger = LoggerFactory.getLogger(JeffServlet.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("<============================>");
        printParams(request);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    }


    /**
     * 打印请求地址和参数
     * 使用匿名lambda方式开启新线程执行
     * @param request
     */
    private void printParams(HttpServletRequest request){
        new Thread(() -> {
            Map<String, String[]> params = request.getParameterMap();
            StringBuilder str = new StringBuilder();
            str.append("<======URI: ").append(request.getRequestURI()).append("; params=");
            for (String key : params.keySet()) {
                str.append(key).append(":").append(params.get(key)[0]).append("; ");
            }
            str.append(" ======>");
            logger.info(str.toString());
        }).start();
    }
}
