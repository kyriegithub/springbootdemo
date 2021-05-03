package com.example.springboot.controller;

import com.example.springboot.annotation.MyTestAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caojianyi@dxy.cn
 * @date 2021-05-03 10:58
 * @Description
 */
@RestController
public class AnnotationController {
    /**
     * 自定义注解+切面结合使用
     */
    @RequestMapping("/helloAnnotation")
    @MyTestAnnotation(value = "helloAnnotation")
    public void testCustomziedAnnotation() {

    }
}
