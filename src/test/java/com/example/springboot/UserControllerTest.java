package com.example.springboot;

import com.example.springboot.entity.jdbcTemplate.UserPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * jdbc Template学习
 * 折叠/展开代码 ctrl+shift+-
 * P156~160 介绍了关羽jdbc Template
 * 如何创建表、-》``而不是''单引号 而是反引号
 * 增、插入数据字段不区分大小写
 * 删、使用update方法执行sql 没有delete方法
 * 改、update方法
 * 查单个、 query方法三个参数 sql、返回结果(要实现RowMapper方法)、sql中的参数new Object[]{name}
 * 查全部、同样是query方法、方法返回用的类不一样BeanPropertyMapper
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void creatUserTable() throws Exception {
        String sql="CREATE TABLE `user_jdbc`(\n" +
                "`id` int(10) not null auto_increment,\n" +
                "`username` varchar(100) DEFAULT NULL,\n" +
                "`password` varchar(100) DEFAULT NULL,\n" +
                "PRIMARY KEY(`id`) \n"+
                ")ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n" +
                "\n";
        jdbcTemplate.execute(sql);
    }


    @Test
    public void saveUserTest() throws Exception {
        //注意一般msql中插入列字段不区分大小写的
        String sql="INSERT INTO  user_jdbc(USERNAME,PASSWORD) VALUES('ZHANGSAN',123456)";
        jdbcTemplate.execute(sql);
    }


    @Test
    public void getUserByName() throws Exception {
       String name="zhangsan";
       String sql="SELECT * FROM user_jdbc WHERE USERNAME = ?";
       //注意这里查询 第二个参数返回实体需要实现RowMapper接口,第三个是参数
       List<UserPo> list=jdbcTemplate.query(sql,new UserPo(),new Object[]{name});
       for (UserPo user:list){
           System.out.println(user);
       }
    }



    @Test
    public void list() throws Exception {
        String sql="SELECT * FROM user_jdbc limit 100";
        List<UserPo> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(UserPo.class));
        for (UserPo user:list){
            System.out.println(user);
        }
    }

    @Test
    public void update() throws Exception {
        Integer id=1;
        String password="998877";
        String sql="UPDATE user_jdbc SET password = ? WHERE id = ?";
        int update = jdbcTemplate.update(sql, password, id);
        System.out.println(update);

    }


    @Test
    public void delete() throws Exception {
        //jbbcTemplate删除数据 没有像jpa一样的deletedById方法，还是得用update
        Integer id=1;
        String sql="DELETE FROM user_jdbc  WHERE id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);

    }
}
