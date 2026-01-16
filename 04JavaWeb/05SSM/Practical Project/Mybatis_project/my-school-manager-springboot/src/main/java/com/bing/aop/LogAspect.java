package com.bing.aop;

import com.alibaba.fastjson.JSONObject;
import com.bing.mapper.OperateLogMapper;
import com.bing.pojo.OperateLog;
import com.bing.service.OperateLogService;
import com.bing.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 操作日志切面类
 */
@Slf4j
//@Component   //标记为Spring管理的Bean
@Aspect      //标记为切面类
public class LogAspect {
    // 拿到请求对象
    @Resource
    HttpServletRequest request;
    // 拿到操作日志Service
    @Resource
    OperateLogService operateLogService;

    // 环绕增强
    @Around("@annotation(com.bing.annotation.LogAnnotation)")  //对添加了@LogAnnotation注解的方法进行增强
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取操作人ID
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");
        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();
        // 操作方法
        String methodName = joinPoint.getSignature().getName();
        // 操作方法的参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        // 开始时间
        long begin = System.currentTimeMillis();
        // 调用原始方法
        Object result = joinPoint.proceed();
        // 处理方法的返回值
        String returnValue = JSONObject.toJSONString(result);
        // 结束时间
        long end = System.currentTimeMillis();
        // 操作耗时
        long costTime = end-begin;
        // 创建操作日志对象
        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
        log.info("AOP记录操作日志：{}",operateLog);
        // 写入操作日志信息
        operateLogService.insert(operateLog);
        return result;   //返回原始方法执行后的结果
    }
}
