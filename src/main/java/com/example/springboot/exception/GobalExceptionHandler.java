package com.example.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常错误捕获
 * @author caojianyi@dxy.cn
 * @date 7/7/21 11:34 PM
 * @Description
 */
@ControllerAdvice
public class GobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Map<String,Object> businessExceptionHandler(BusinessException e){
        Map<String,Object>  map=new HashMap<>();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg());
        //发生异常记录在日志系统中、或者通过elk数据记录+
        return map;

    }
}
