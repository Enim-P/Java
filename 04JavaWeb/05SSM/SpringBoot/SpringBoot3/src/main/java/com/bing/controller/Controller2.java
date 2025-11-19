package com.bing.controller;

import com.bing.pojo.Result;
import com.bing.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//@ResponseBody
//@Controller
//@RestController将方法返回值直接响应，方法的放回值统一将会转为json格式的字符串返回
@RestController   // @RestController = @Controller + @ResponseBody
public class Controller2 {

    @GetMapping("/resp1")
    public String resp1(){
        return "Hello World";
    }

    @GetMapping("/resp2")
    public User resp2(){
        User user = new User("张三",50);
        return user;
    }

    @GetMapping( "/resp3")
    public List<User> resp3(){
        List<User> users = new ArrayList<>();
        users.add(new User("张三",100));
        users.add(new User("李四",110));
        // 直接返回集合对象，它会帮我们转为JSON格式的字符串返回
        return users;
    }

    // 上面的请求方法都是直接将查询的结果直接返回，那么前端在拿数据的时候接收的结果就没有标准
    // 它可能拿到的是一个字符串，也可能拿到是一个对象，或者是一个集合等等
    // 所以实际开发时，我们需要将结果以统一的结果集返回
    // 比如：统一的结果集中包括：状态码 描述信息 响应的结果

    @GetMapping("/resp4")
    public Result resp4(){
        return Result.success("Hello World");
    }

    @GetMapping("/resp5")
    public Result resp5(){
        User user = new User("张三",50);
        return Result.success(user);
    }

    @GetMapping("/resp6")
    public Result resp6(){
        List<User> users = new ArrayList<>();
        users.add(new User("张三",100));
        users.add(new User("李四",110));
        //return Result.success(users);
        return new Result(1,"查询用户列表成功",users);
    }

    @GetMapping("/resp7")
    public Result resp7(Integer id){
        return Result.error("查询用户id"+id+"失败");
    }
}
