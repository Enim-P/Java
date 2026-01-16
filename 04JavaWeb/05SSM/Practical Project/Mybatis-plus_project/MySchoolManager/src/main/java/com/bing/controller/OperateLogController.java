package com.bing.controller;

import com.bing.pojo.OperateLog;
import com.bing.pojo.PageBean;
import com.bing.pojo.ReturnData;
import com.bing.pojo.Subject;
import com.bing.service.OperateLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 操作日志控制器
 */
@Api(tags = "操作日志相关接口")
@RestController()
@RequestMapping("/logs")
public class OperateLogController {
    @Resource
    OperateLogService operateLogService;

    // 根据条件+分页返回课程
    @ApiOperation("条件+分页查询日志信息")
    @GetMapping
    public ReturnData findByCondition(@ApiParam("用户Id") @RequestParam(required = false,defaultValue = "0") Integer operateUser,
                                      @ApiParam("起始时间") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime operateTime1,
                                      @ApiParam("截止时间") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime operateTime2,
                                      @ApiParam("页码") @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                                      @ApiParam("每页数量") @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        PageBean<OperateLog> pageBean = operateLogService.findByCondition(operateUser,operateTime1,operateTime2,pageIndex,pageSize);
        return ReturnData.success(pageBean);
    }
}
