package com.example.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author caojianyi@dxy.cn
 * @date 2021-05-03 10:55
 * @Description 自定义注解使用
 * 运行期间保留注解、作用范围类+方法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
public @interface MyTestAnnotation {
    String value();
}
