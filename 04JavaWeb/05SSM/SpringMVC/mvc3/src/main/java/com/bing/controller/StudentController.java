package com.bing.controller;

import com.alibaba.fastjson.JSON;
import com.bing.pojo.Student;
import com.bing.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//RestFul风格的请求地址
//RESTFul风格的设计允许将参数通过URL拼接传到服务端，
//传统传参：http://192.168.1.1:8080/student?no=123，RestFul传参：http://192.168.1.1:8080/student/123
//目的是让URL看起来更简洁实用，并且我们可以充分使用多种HTTP请求方式（POST/GET/PUT/DELETE），来执行相同请求地址的不同类型操作。
//比如：请求地址都是http://192.168.1.1:8080/student，分别使用GET和POST实现查询和添加


@Controller
@ResponseBody
@RequestMapping(value="/student",produces = "text/json;charset=UTF-8")
public class StudentController {
    // 在RestFul风格的请求方式中：get请求用于查询，post请求用于添加，put请求用于修改，delete请求用于删除

    @Resource
    StudentService studentService;

    // 返回全部学生
    @GetMapping()
    public String getAllStudent(){
        List<Student> students = studentService.getAllStudnet();
        return JSON.toJSONString(students);
    }

    // 根据序号返回学生
    // {no}：路径参数占位符，@PathVariable注解修饰的方法参数匹配路径参数占位符
    @GetMapping("/{no}")
    public String getOneStudent(@PathVariable String no){
        Student student = studentService.getOneStudent(no);
        return JSON.toJSONString(student);
    }

    // 添加学生
    @PostMapping()
    public String addStudent(@RequestBody Student student){
        int row = studentService.addStudent(student);
        if(row>0){
            return "添加成功！";
        }else{
            return "添加失败！";
        }
    }

    // 修改学生
    @PutMapping()
    public String updateStudent(@RequestBody Student student){
        int row = studentService.updateStudent(student);
        if(row>0){
            return "修改成功！";
        }else{
            return "修改失败！";
        }
    }

    // 删除学生
    @DeleteMapping("/{no}")
    public String deleteStudent(@PathVariable String no){
        int row = studentService.deleteStudent(no);
        if(row>0){
            return "删除成功！";
        }else{
            return "删除失败！";
        }
    }

}
