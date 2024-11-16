package com.example.springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * P127
 * @author caojianyi@dxy.cn
 * @date 2021-02-09 22:44
 * @Description springboot 过滤器demo-->请求参数过滤处理
 */
@Order(1)
@WebFilter(urlPatterns = "/*")
@Slf4j
public class FilterDemo
        implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化逻辑,服务器启动时被调用
        log.info("FilterDemo过滤器启动");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //request处理逻辑
        //request封装逻辑
        //chain 重新写回request+response
        log.info("过滤器过滤");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        //重新destory逻辑,该服务器关闭时被调用-->销毁逻辑
        log.info("FilterDemo过滤器关闭");
    }
}
