package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caojianyi@dxy.cn
 * @date 2021-04-11 00:30
 * @Description
 */
@RestController
@Slf4j
public class DemoController {

    /**
     * webflux响应式变成
     *
     * @return
     */
    @ApiOperation(value = "swagger接口说明")
    @GetMapping("/helloSwagger")
    public String helloworld() {
        boolean flag = false;
        Student student=new Student(1,"zhangsan");
        for (int i = 0; i < 10; i++) {
            sendYinChuanDoctorRecord(flag,student);
            if(flag){
                log.info("结束外循环");

            }
            log.info(JSON.toJSONString(student));
        }
        return "hello-swagger-002";
    }

    /**
     * 循环调试
     *
     * @param flag
     * @param student
     */
    private void sendYinChuanDoctorRecord(Boolean flag, Student student) {
        student = new Student(2, "李四");
        for (int i = 0; i < 10; i++) {
            if(i==5){
                flag=true;

                break;
            }
        }
        log.info(String.valueOf(flag));
        log.info(JSON.toJSONString(student));
    }

    class Student{
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }



    public static void main(String[] args) {
        String string="${nickname}${message}${questionUrl}";
        System.out.println(string.replace("message","医生给你开具了处方，点击即可查看处方并购买药品"));
    }
}
