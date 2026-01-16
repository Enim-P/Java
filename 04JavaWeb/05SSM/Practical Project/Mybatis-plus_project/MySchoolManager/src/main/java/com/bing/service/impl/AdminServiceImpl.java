package com.bing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bing.annotation.LogAnnotation;
import com.bing.mapper.AdminMapper;
import com.bing.pojo.Admin;
import com.bing.pojo.PageBean;
import com.bing.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户Service实现类
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Transactional  // 添加事务管理
    @Override
    public int register(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int insert(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int update(Admin admin) {
        return adminMapper.updateById(admin);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int updatePwd(Integer id, String oldPwd, String newPwd) {
        return adminMapper.updatePwd(id,oldPwd,newPwd);
    }

    @Transactional  // 添加事务管理
    @LogAnnotation   //操作是需要写入日志
    @Override
    public int delete(Integer id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public Admin findByLoginId(String loginId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("loginId",loginId);
        return adminMapper.selectOne(qw);
    }

    @Override
    public PageBean<Admin> findByCondition(String type, String name, Integer pageIndex, Integer pageSize) {
        //分页对象
        IPage<Admin> page = new Page<>(pageIndex,pageSize);
        //条件对象
        LambdaQueryWrapper<Admin> qw = new LambdaQueryWrapper();
        qw.eq(!"".equals(type),Admin::getType,type);
        qw.like(!"".equals(name),Admin::getName,name);
        adminMapper.selectPage(page,qw);
        PageBean pageBean = new PageBean(page.getTotal(),page.getRecords());
        return pageBean;
    }
}
