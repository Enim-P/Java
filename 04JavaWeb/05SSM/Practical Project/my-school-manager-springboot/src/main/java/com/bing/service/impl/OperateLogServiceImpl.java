package com.bing.service.impl;

import com.bing.mapper.OperateLogMapper;
import com.bing.pojo.OperateLog;
import com.bing.pojo.PageBean;
import com.bing.service.OperateLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 操作日志Servide实现类
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Resource
    OperateLogMapper operateLogMapper;

    // 增删改，添加事务操作
    @Transactional(propagation = Propagation.REQUIRES_NEW)  //当前事务不加入到任何其他事务，始终是一个新建的事务
    @Override
    public int insert(OperateLog operateLog) {
        return operateLogMapper.insert(operateLog);
    }

    @Override
    public PageBean<OperateLog> findByCondition(Integer operateUser, LocalDateTime operateTime1, LocalDateTime operateTime2, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<OperateLog> operateLogs = operateLogMapper.findByCondition(operateUser, operateTime1, operateTime2);
        Page<OperateLog> pages = (Page<OperateLog>) operateLogs;
        PageBean<OperateLog> pageBean = new PageBean<>(pages.getTotal(),pages.getResult());
        return pageBean;
    }
}
