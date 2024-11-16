package com.example.springboot.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义错误处理控制器
 * spring提供默认的错误映射路径-也就是说访问不到的接口 都会到这个下面
 * @author caojianyi@dxy.cn
 * @date 7/7/21 11:07 PM
 * @Description
 */
@RestController
@RequestMapping("/error")
public class TestErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }


    @RequestMapping
    public Map<String,Object> handleError(){
        Map<String,Object>  map=new HashMap<>();
        map.put("code",404);
        map.put("msg","不存在");
        return map;
    }

    /**
     * 正常访问页面路径
     * @return
     */
    @RequestMapping("ok")
    @ResponseBody
    public Map<String,Object> noError(){
        Map<String,Object>  map=new HashMap<>();
        map.put("code",200);
        map.put("msg","正常,这是测试页面");
        return map;
    }


    /**
     * 针对text/html-返回数据格式
     * @return
     */
    @RequestMapping(produces = "text/html;charset=utf-8")
    public String errorHtml404(HttpServletRequest request, HttpServletResponse response){
        return  "404错误,不存在";
    }

    /**
     * 针对json格式
     * @return
     */
    @RequestMapping(produces = "application/json;charset=utf-8")
    @ResponseBody
    public Map<String, Object> errorJson(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 404);
        map.put("msg", "不存在");
        return map;
    }


}
