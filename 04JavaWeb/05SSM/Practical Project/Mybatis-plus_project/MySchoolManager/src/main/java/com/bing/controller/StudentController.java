package com.bing.controller;

import com.bing.pojo.PageBean;
import com.bing.pojo.ReturnData;
import com.bing.pojo.Student;
import com.bing.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 学生控制器
 */
//@CrossOrigin()  // 允许跨域请求
@Api(tags = "学生相关接口")
@RestController
@RequestMapping("/students")
public class StudentController {
    @Resource
    StudentService studentService;

    //新增学生
    @ApiOperation("添加学生")
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
    @ApiOperation("修改学生")
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
    @ApiOperation("删除学生")
    @DeleteMapping("/{studentNo}")
    public ReturnData delete(@ApiParam("学号") @PathVariable String studentNo){
        int rows = studentService.delete(studentNo);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("删除失败！");
        }
    }

    //根据学号查询学生
    @ApiOperation("根据学号查询学生")
    @GetMapping("/{studentNo}")
    public ReturnData findByNo(@ApiParam("学号") @PathVariable String studentNo){
        Student student = studentService.findByNo(studentNo);
        return ReturnData.success(student);
    }

    //条件+分页查询学生
    //@CrossOrigin()  // 允许跨域请求
    @ApiOperation("条件+分页查询学生")
    @GetMapping
    public ReturnData findByCondition(@ApiParam("年级Id") @RequestParam(required = false,defaultValue = "0") Integer gradeId,
                                      @ApiParam("学生姓名") @RequestParam(required = false,defaultValue = "") String studentName,
                                      @ApiParam("页码") @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                                      @ApiParam("每页数量") @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        PageBean<Student> pageBean = studentService.findByCondition(gradeId, studentName, pageIndex, pageSize);
        return ReturnData.success(pageBean);
    }
}
