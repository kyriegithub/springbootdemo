package com.example.springboot.controller;

import com.example.springboot.exception.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试自定义异常类
 * @author caojianyi@dxy.cn
 * @date 7/7/21 11:40 PM
 * @Description
 */
@RestController
public class TestExceptionController {

    @RequestMapping("BusinsessException")
    public String testResponseStatusException(@RequestParam("id") int id) {
        if (id == 0) {
            throw new BusinessException(600, "自定义业务异常");
        }
        return "success";
    }
}
