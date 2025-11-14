package com.bing.controller;

import com.alibaba.fastjson.JSON;
import com.bing.pojo.Student;
import com.bing.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value="/student2",produces = "text/json;charset=UTF-8")
public class Student2Controller {
    @Resource
    StudentService studentService;

    // 返回全部学生
    @GetMapping()
    public List<Student> getAllStudent(){
        List<Student> students = studentService.getAllStudnet();
        return students;
        // 以前我们是在每个控制器方法中，自己手动将java对象转为json格式的字符串返回
        // 能不能统一转换呢？
        // 就是这里我们之间返回java对象，然后它自动帮我们转为json格式的字符串返回
        // 需要在配置类中统一转换
    }

    // 根据序号返回学生
    // {no}：路径参数占位符，@PathVariable注解修饰的方法参数匹配路径参数占位符
    @GetMapping("/{no}")
    public Student getOneStudent(@PathVariable String no){
        Student student = studentService.getOneStudent(no);
        return student;
    }
}
