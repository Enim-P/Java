package com.bing.project2.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bing.project2.pojo.User;
import com.bing.project2.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    // 查询全部
    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAllUser();
    }

    // 查询单个
    @GetMapping("/findById")
    public User findById(@RequestParam Long id){
        return userService.findUserById(id);
    }

    // 添加
    @PostMapping("/add")
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    // 修改
    @PutMapping("/up")
    public int upUser(@RequestBody User user){
        return userService.upUser(user);
    }

    // 删除
    @DeleteMapping("/del/{id}")
    public int delUser(@PathVariable Long id){
        return userService.delUser(id);
    }

    // 分页查询
    @GetMapping("/findPage")
    public Map findPage(@RequestParam Integer current,@RequestParam Integer size){
        IPage<User> page = userService.findPage(current, size);
        Map map = new HashMap();
        map.put("pages",page.getPages());
        map.put("rows",page.getRecords());
        return map;
    }
}
