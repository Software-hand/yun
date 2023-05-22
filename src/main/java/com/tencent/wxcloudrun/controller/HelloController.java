package com.tencent.wxcloudrun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 软件手
 * @date: 2023/5/23 0:49
 * @description:
 */

// 控制器 接受客户端请求
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

}
