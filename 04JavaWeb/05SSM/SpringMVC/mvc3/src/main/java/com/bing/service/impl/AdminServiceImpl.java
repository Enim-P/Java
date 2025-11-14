package com.bing.service.impl;

import com.bing.mapper.AdminMapper;
import com.bing.pojo.Admin;
import com.bing.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminByLoginId(String loginId) {
        return adminMapper.getAdminByLoginId(loginId);
    }
}
