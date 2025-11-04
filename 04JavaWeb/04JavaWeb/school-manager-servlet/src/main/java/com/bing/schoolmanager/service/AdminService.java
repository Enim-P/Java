package com.bing.schoolmanager.service;

import com.bing.schoolmanager.pojo.Admin;

public interface AdminService {
    Admin getAdminByLoginId(String loginId);
}
