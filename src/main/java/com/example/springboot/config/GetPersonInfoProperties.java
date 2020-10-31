package com.example.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取application.yml文件中的配置
 * spring通用管理类+配置注解前缀
 * @author caojianyi@dxy.cn
 * @date 2020-11-01 00:44
 * @Description
 */
@Component
@ConfigurationProperties(prefix="personinfo")
public class GetPersonInfoProperties {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GetPersonInfoProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
