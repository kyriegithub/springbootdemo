package com.example.springboot.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caojianyi@dxy.cn
 * @date 2021-04-11 00:30
 * @Description
 */
@RestController
public class DemoController {

    /**
     * webflux响应式变成
     * @return
     */
    @ApiOperation(value = "swagger接口说明")
    @GetMapping("/helloSwagger")
    public String helloworld(){
       return "hello-swagger-002";
    }
}
