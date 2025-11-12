package com.bing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = "text/json;charset=UTF-8")
public class TwoController {
    @RequestMapping("/suzhou")
    public String suzhou(){
        // redirect:前缀，用于重定向
        // 重定向是前端行为，是后端通知了前端重新请求/shanghai
        return "redirect:shanghai";
    }

    @ResponseBody  // 添加该注解后，方法的的内容才会做为响应体返回
    @RequestMapping("/shanghai")
    public String shanghai(){
        return "上海";
    }

    @RequestMapping("/hangzhou")
    public String hangzhou(){
        //forward:前缀，用于请求转发
        //请求转发是后端行为，是后端将原本找他的请求，转发给了其他请求方法，前端是不知情的
        return "forward:shanghai";
    }
}
