package com.bing.controller;

import com.bing.bean.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ThreeController {
    @Resource
    Car car;

    // 测试Bean的Web作用域的方法
    @ResponseBody
    @RequestMapping("/car")
    public String carGar(){
        return car.toString();
    }


    // 测试拦截器的方法
    @ResponseBody
    @RequestMapping("/inter")
    public String testIntercepter(){
        System.out.println("testIntercepter....");
//        if(true){
//            throw new RuntimeException("发生异常");
//        }
        return "testIntercepter";
    }

    // 测试异常处理
    @ResponseBody
    @RequestMapping(value = "/city",produces = "text/json;charset=UTF-8")
    public String getCitys(){
        if(true){
            throw new RuntimeException("发生异常");
        }
        return "北京 上海 广州 深圳";
    }

}
