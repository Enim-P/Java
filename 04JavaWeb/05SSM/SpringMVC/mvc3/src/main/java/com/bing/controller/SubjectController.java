package com.bing.controller;

import com.alibaba.fastjson.JSON;
import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

// 课程控制器
@Controller
@RequestMapping("/subject")   // 当前控制器的请求路径
public class SubjectController {
    @Resource
    private SubjectService subjectService;

    @ResponseBody
    @GetMapping(value = "/list",produces = "text/json;charset=UTF-8")  // 指定请求方法的请求路径
    public String getAllSubjects(){
        List<Subject> subjects = subjectService.getSubjects();
        //return subjects;
        return JSON.toJSONString(subjects);
    }

}
