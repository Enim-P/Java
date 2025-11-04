package com.bing.schoolmanager.service.impl;

import com.bing.schoolmanager.mapper.AdminMapper;
import com.bing.schoolmanager.pojo.Admin;
import com.bing.schoolmanager.service.AdminService;
import com.bing.schoolmanager.util.MybatisUtil;

public class AdminServiceImpl implements AdminService {
    AdminMapper adminMapper = MybatisUtil.getSession(true)
            .getMapper(AdminMapper.class);
    @Override
    public Admin getAdminByLoginId(String loginId) {
        return adminMapper.getAdminByLoginId(loginId);
    }
}
