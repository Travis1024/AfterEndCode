package com.graduation.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: (测试swagger2)
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/1/26 17:32]
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
