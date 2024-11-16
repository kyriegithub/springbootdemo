package com.example.springboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * P119
 * @author caojianyi@dxy.cn
 * @date 2020-11-22 21:41
 * @Description springboot aop切面日志添加(切面=切点+通知)
 */
@Component
@Aspect
@Slf4j
public class AopLog {

    //aop切面多线程临时变量存放
    public ThreadLocal<Long> startTime = new ThreadLocal<>();

    //定义切点 excution(方法修饰类型 返回类型 方法名 参数  异常模式) 用于切面的连接点
//    @Pointcut("execution(public * com.example.springboot..*.*(..))")
    @Pointcut("execution(public * com.example.springboot.controller..*.*(..))")
    public void aopWebLog() {

    }

    /**
     * 前置通知->进入controller方法之前处理
     *
     * @param joinPoint
     */
    @Before("aopWebLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        //接收到请求,记录请求内容(请求上下文)
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest  request=attributes.getRequest();

        //记录下请求内容
        log.info("AopLog:URL"+request.getRequestURI().toString());
        log.info("AopLog:Http方法:"+request.getMethod());
        log.info("AopLog:IP地址:"+request.getRemoteHost());
        log.info("AopLog:类的方法:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        log.info("AopLog:参数:"+request.getQueryString());
    }


    /**
     * 代码执行完成后 通知
     * @param reObject
     */
    @AfterReturning(pointcut = "aopWebLog()",returning = "reObject")
    public  void doAfterReturning(Object reObject){
        //处理完请求,返回内容
        log.info("AopLog:返回值:"+reObject);
        log.info("AopLog:应答时间:"+(System.currentTimeMillis()-startTime.get()));
    }


    /**
     * 代码抛出异常后 通知
     * @param joinPoint
     */
    @AfterThrowing(pointcut = "aopWebLog()",throwing = "e")
    public void addAfterThrowingLogger(JoinPoint joinPoint,Exception e){
        log.error("AopLog:执行"+"异常",e);

    }
}
