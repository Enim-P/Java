package com.bing.controller;

import com.alibaba.fastjson.JSON;
import com.bing.pojo.Admin;
import com.bing.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminController {
    @Resource
    AdminService adminService;

    @ResponseBody
    @PostMapping(value = "/login",produces = "text/json;charset=UTF-8")
    public String login(String loginId, String loginPwd, HttpSession session){
        Admin admin = adminService.getAdminByLoginId(loginId);
        Map<String,Object> map = new HashMap<>();
        if(admin!=null){
            if(admin.getLoginPwd().equals(loginPwd)){
                map.put("code",1);
                map.put("message","登录成功");
                // 登录成功后，在session中保存用户信息
                session.setAttribute("admin",map);
            }else{
                map.put("code",0);
                map.put("message","密码错误");
            }
        }else{
            map.put("code",0);
            map.put("message","登录名错误");
        }
        return JSON.toJSONString(map);
    }
}
