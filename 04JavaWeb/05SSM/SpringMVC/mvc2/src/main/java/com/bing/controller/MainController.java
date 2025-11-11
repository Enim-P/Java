package com.bing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 使用@Controller注解定义控制器
@Controller
public class MainController {

    // 在控制器中，定义前端的请求

    @ResponseBody   // 设置方法中的内容以请求体的形式返回
    @RequestMapping("/")  // 定义一个请求的映射路径
    public String hello(){
        return "HelloWorld!";
    }

    @ResponseBody
    @RequestMapping("/hi")
    public String hi(){
        return "Hi!";
    }

    @ResponseBody
    @PostMapping("/nj")   //post请求
    public String nanjing(){
        return "nanjing";
    }

}
