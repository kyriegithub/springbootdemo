package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * spring ioc控制反转demo
 * @author caojianyi@dxy.cn
 * @date 2021-02-09 22:48
 * @Description
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
}
