package com.bing.controller;

import com.alibaba.fastjson.JSON;
import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 课程控制器
@Controller
@ResponseBody  // 统一设置所有的请求方法返回响应体类型
@RequestMapping(value="/subject",produces = "text/json;charset=UTF-8")   // 当前控制器的请求路径
public class SubjectController {
    @Resource
    private SubjectService subjectService;

    // 返回所有的课程
    @GetMapping("/list")  // 指定请求方法的请求路径
    public String getAllSubjects(){
        List<Subject> subjects = subjectService.getSubjects();
        //return subjects;
        return JSON.toJSONString(subjects);
    }

    /*
        @RequestMapping注解：用于将请求和处理请求的方法建立一个映射关系，
        当收到请求时，根据映射关系调用对应的请求方法处理
        @RequestMapping默认是GET请求方式
        如果是POST请求方式，可以通过method属性指定
        @RequestMapping(value = "/byId",method = RequestMethod.POST)
        它还有四个衍生注解，专门用于处理常用的四种请求方式：get post put delete
        @GetMapping
        @PostMapping
        @PutMapping
        @DeleteMapping
    */


    // 根据课程id返回课程
    @GetMapping("/byId")
    public String getSubjectById(@RequestParam Integer id){
        // @RequestParam注解：定义请求参数
        // 通常情况下：get请求 和 delete请求，传递参数使用@RequestParam
        Subject subject = subjectService.getSubjectById(id);
        return JSON.toJSONString(subject);
    }

    // 添加课程
    @PostMapping("/add")
    public String addSubject(@RequestBody Subject subject){
        System.out.println(subject);
        // @RequestBody注解：定义请求体
        // 通常情况下：post请求 和 put请求，传递参数使用@RequestBody
        int row = subjectService.addSubject(subject);
        if(row>0){
            return "添加成功！";
        }else{
            return "添加失败！";
        }
    }

    // 修改课程
    @PutMapping("/update")
    public String updateSubject(@RequestBody Subject subject){
        int row = subjectService.updateSubject(subject);
        if(row>0){
            return "修改成功！";
        }else{
            return "修改失败！";
        }
    }

    // 删除课程
    @DeleteMapping("/delete")
    public String deleteSubject(@RequestParam Integer id){
        int row = subjectService.deleteSubject(id);
        if(row>0){
            return "删除成功！";
        }else{
            return "删除失败！";
        }
    }

}
