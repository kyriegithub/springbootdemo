package com.example.springboot.aop;

import com.example.springboot.annotation.MyTestAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author caojianyi@dxy.cn
 * @date 2021-05-03 11:00
 * @Description 自定义注解切面处理(环绕+前置+后置)
 */
@Aspect
@Component
@Slf4j
public class AnnnotattionAop {

    /**
     * 定义切点
     */
    @Pointcut(value = "@annotation(com.example.springboot.annotation.MyTestAnnotation)")
    public void pointCut() {
        log.info("AnnnotattionAop");
    }

    /**
     * 前置通知处理
     * @param joinPoint
     */
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MyTestAnnotation myTestAnnotation=method.getAnnotation(MyTestAnnotation.class);
        log.info("MyTestAnnotation value={}",myTestAnnotation.value());
    }
}
