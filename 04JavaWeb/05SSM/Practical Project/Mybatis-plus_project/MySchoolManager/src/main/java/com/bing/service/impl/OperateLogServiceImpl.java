package com.bing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bing.mapper.OperateLogMapper;
import com.bing.pojo.OperateLog;
import com.bing.pojo.PageBean;
import com.bing.service.OperateLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

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
        IPage<OperateLog> page = new Page<>(pageIndex,pageSize);
        LambdaQueryWrapper<OperateLog> qw = new LambdaQueryWrapper<>();
        qw.eq( 0!=operateUser,OperateLog::getOperateUser,operateUser);
        qw.between(null != operateTime1 && null != operateTime2,OperateLog::getOperateTime,operateTime1,operateTime2);
        operateLogMapper.selectPage(page,qw);
        PageBean<OperateLog> pageBean = new PageBean<>(page.getTotal(),page.getRecords());
        return pageBean;
    }
}
