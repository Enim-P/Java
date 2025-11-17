package com.bing.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController   //@RestController = @Controller + @ResponseBody
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello(){

        return "HelloWorld--当前项目的端口号是8090";
    }

}
