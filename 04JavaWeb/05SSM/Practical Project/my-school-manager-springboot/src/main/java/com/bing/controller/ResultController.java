package com.bing.controller;

import com.bing.pojo.PageBean;
import com.bing.pojo.Result;
import com.bing.pojo.ReturnData;
import com.bing.service.ResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 成绩控制器
 */
@Api(tags = "成绩相关接口")
@RestController
@RequestMapping("/results")
public class ResultController {
    @Resource
    ResultService resultService;

    // 添加成绩
    @ApiOperation("添加成绩")
    @PostMapping
    public ReturnData insert(@RequestBody Result result){
        int rows = resultService.insert(result);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("添加失败！");
        }
    }

    // 修改成绩
    @ApiOperation("修改成绩")
    @PutMapping
    public ReturnData update(@RequestBody Result result){
        int rows = resultService.update(result);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("修改失败！");
        }
    }

    // 删除成绩
    @ApiOperation("删除成绩")
    @DeleteMapping("/{resultId}")
    public ReturnData delete(@PathVariable Integer resultId){
        int rows = resultService.delete(resultId);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("删除失败！");
        }
    }

    // 根据成绩编号查询成绩
    @ApiOperation("根据成绩编号查询成绩")
    @GetMapping("/{resultId}")
    public ReturnData findById(@PathVariable Integer resultId){
        Result result = resultService.findById(resultId);
        return ReturnData.success(result);
    }

    // 条件+分页查询成绩信息
    @ApiOperation("条件+分页查询成绩")
    @GetMapping
    public ReturnData findByCondition(@RequestParam(required = false,defaultValue = "") String studentNo,
                                      @RequestParam(required = false,defaultValue = "0") Integer subjectId,
                                      @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                                      @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        PageBean<Result> pageBean = resultService.findByCondition(studentNo, subjectId, pageIndex, pageSize);
        return ReturnData.success(pageBean);
    }

    // 根据ids批量删除
    @ApiOperation("批量删除成绩")
    @PostMapping("/deleteByIds")
    public ReturnData deleteByIds(@RequestBody List<Integer> ids){
        int rows = resultService.deleteByIds(ids);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("删除失败！");
        }
    }
}
