package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * P130 自定义入口类
 * @author caojianyi@dxy.cn
 * @date 2021-02-10 22:53
 * @Description
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class DefineApplication {

    /**
     * 方式1(常见-->静态方法 实例化,利用SpringApplication 调用run实现方法)
     * @param args
     */
//    public static void main(String[] args) {
//        SpringApplication.run(DefineApplication.class,args);
//    }

    /**
     * 方式2(自定义方式)
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication  springApplication=new SpringApplication(DefineApplication.class);
        springApplication.run(args);
    }
}
