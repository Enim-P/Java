package com.bing.service.impl;

import com.bing.annotation.LogAnnotation;
import com.bing.mapper.AdminMapper;
import com.bing.pojo.Admin;
import com.bing.pojo.PageBean;
import com.bing.service.AdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
        return adminMapper.register(admin);
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
        return adminMapper.update(admin);
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
        return adminMapper.delete(id);
    }

    @Override
    public Admin findByLoginId(String loginId) {
        return adminMapper.findByLoginId(loginId);
    }

    @Override
    public PageBean<Admin> findByCondition(String type, String name, Integer pageIndex, Integer pageSize) {
        //开启分页功能
        PageHelper.startPage(pageIndex,pageSize);
        List<Admin> admins = adminMapper.findByCondition(type, name);
        Page<Admin> pages = (Page<Admin>) admins;
        PageBean pageBean = new PageBean(pages.getTotal(),pages.getResult());
        return pageBean;
    }
}
