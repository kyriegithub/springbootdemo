package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author caojianyi@dxy.cn
 * @date 2020-11-03 00:56
 * @Description
 */
@RestController
public class WebFluxController {

    @GetMapping("helloworld")
    public Mono<String> helloworld(){
        return Mono.just("This is webflux demo");
    }
}
