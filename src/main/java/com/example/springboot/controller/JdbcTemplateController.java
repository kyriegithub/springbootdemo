package com.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caojianyi@dxy.cn
 * @date 7/9/21 1:27 AM
 * @Description
 */
@RestController
@Slf4j
public class JdbcTemplateController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/createTable")
    public String createTable() {
        String sql="CREATE TABLE user (id int(10) not null auto_increment,username varchar(100) default null,password varchar(100) default null,primary key (id));";
        jdbcTemplate.execute(sql);
        return "初始化表成功";
    }


    @GetMapping("/insert")
    public String updateUser() {
        String sql="INSERT INTO user (id,username,password) VALUE (1,'zhangsan','123456')";
        jdbcTemplate.execute(sql);
        return "初始化表成功";
    }
}
