package com.bing.controller;

import com.bing.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller2 {
    @GetMapping( "/resp1")
    public List<User> resp1(){
        List<User> users = new ArrayList<>();
        users.add(new User("张三",100));
        users.add(new User("李四",110));
        // 直接返回集合对象，它会帮我们转为JSON格式的字符串返回
        return users;
    }
}
