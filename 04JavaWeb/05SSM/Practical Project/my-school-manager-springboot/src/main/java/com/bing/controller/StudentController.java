package com.bing.controller;

import com.bing.pojo.PageBean;
import com.bing.pojo.ReturnData;
import com.bing.pojo.Student;
import com.bing.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 学生控制器
 */
@RestController
@RequestMapping("/students")
public class StudentController {
    @Resource
    StudentService studentService;

    //新增学生
    @PostMapping
    public ReturnData insert(@RequestBody Student student){
        int rows = studentService.insert(student);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("添加失败！");
        }
    }

    //修改学生
    @PutMapping
    public ReturnData update(@RequestBody Student student){
        int rows = studentService.update(student);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("修改失败！");
        }
    }

    //删除学生
    @DeleteMapping("/{studentNo}")
    public ReturnData delete(@PathVariable String studentNo){
        int rows = studentService.delete(studentNo);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("删除失败！");
        }
    }

    //根据学号查询学生
    @GetMapping("/{studentNo}")
    public ReturnData findByNo(@PathVariable String studentNo){
        Student student = studentService.findByNo(studentNo);
        return ReturnData.success(student);
    }

    //条件+分页查询学生
    @GetMapping
    public ReturnData findByCondition(@RequestParam(required = false,defaultValue = "0") Integer gradeId,
                                      @RequestParam(required = false,defaultValue = "") String studentName,
                                      @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                                      @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        PageBean<Student> pageBean = studentService.findByCondition(gradeId, studentName, pageIndex, pageSize);
        return ReturnData.success(pageBean);
    }
}
