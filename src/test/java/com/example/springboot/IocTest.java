package com.example.springboot;

import com.alibaba.fastjson.JSON;
import com.example.springboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author caojianyi@dxy.cn
 * @date 2021-02-10 11:52
 * @Description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IocTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void  testIoc(){
        User user= (User) applicationContext.getBean("user1");
        System.out.println(JSON.toJSON(user));

    }

}
