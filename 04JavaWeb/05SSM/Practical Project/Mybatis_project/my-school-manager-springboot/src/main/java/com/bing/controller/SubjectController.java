package com.bing.controller;

import com.bing.pojo.PageBean;
import com.bing.pojo.ReturnData;
import com.bing.pojo.Subject;
import com.bing.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 年级控制器
 */
@Api(tags = "课程相关接口")
@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Resource
    SubjectService subjectService;

    // 添加课程
    @ApiOperation("添加课程")
    @PostMapping
    public ReturnData insert(@RequestBody Subject subject){
        int rows = subjectService.insert(subject);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("添加失败！");
        }
    }

    // 修改课程
    @ApiOperation("修改课程")
    @PutMapping
    public ReturnData update(@RequestBody Subject subject){
        int rows = subjectService.update(subject);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("修改失败！");
        }
    }

    // 删除课程
    @ApiOperation("删除课程")
    @DeleteMapping("/{subjectId}")
    public ReturnData delete(@PathVariable Integer subjectId){
        int rows = subjectService.delete(subjectId);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("删除失败！");
        }
    }

    // 根据课程编号返回课程
    @ApiOperation("根据课程编号查询课程")
    @GetMapping("/{subjectId}")
    public ReturnData findById(@PathVariable Integer subjectId){
        Subject subject = subjectService.findById(subjectId);
        return ReturnData.success(subject);
    }

    // 根据条件+分页返回课程
    @ApiOperation("条件+分页查询课程")
    @GetMapping
    public ReturnData findByCondition(@RequestParam(required = false,defaultValue = "0") Integer gradeId,
                                      @RequestParam(required = false,defaultValue = "") String subjectName,
                                      @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                                      @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        PageBean<Subject> pageBean = subjectService.findByCondition(gradeId, subjectName, pageIndex, pageSize);
        return ReturnData.success(pageBean);
    }
}
