package com.example.springboot.config;

import com.example.springboot.entity.ioc.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * P123
 * ioc控制返回 bean对象注入ioc容器
 * @author caojianyi@dxy.cn
 * @date 2021-02-09 22:49
 * @Description
 */
@Configuration
public class UserConfig {

    @Bean("user1")
    public User user(){
        User user=new User();
        user.setId(1);
        user.setName("name");
        return user;
    }
}
