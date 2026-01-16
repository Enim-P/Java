package com.bing.controller;

import com.bing.pojo.Grade;
import com.bing.pojo.ReturnData;
import com.bing.service.GradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 年级控制器
 */
@Api(tags = "年级相关接口")
@RestController
@RequestMapping("/grades")
public class GradeController {

    @Resource
    GradeService gradeService;

    // 查询全部年级
    @ApiOperation("查询全部年级")
    @GetMapping
    public ReturnData findAll(){
        List<Grade> grades = gradeService.findAll();
        return ReturnData.success(grades);
    }

    // 根据年级编号查询年级
    @ApiOperation("根据年级编号查询年级")
    @GetMapping("/{gradeId}")
    public ReturnData findById(@PathVariable Integer gradeId){
        Grade grade = gradeService.findById(gradeId);
        return ReturnData.success(grade);
    }
}
