package com.example.springboot.listen;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * P129 监听器-用于监听监听事件创建、修改等,常用于统计网站在线人数
 * @author caojianyi@dxy.cn
 * @date 2021-02-10 16:25
 * @Description
 */
@WebListener
@Slf4j
public class ListenDemo implements ServletContextListener {


    @Override
    public  void contextInitialized(ServletContextEvent sce) {
        log.info("ServletContext 初始化");
        log.info(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("ServletContext 销毁");
    }
}
