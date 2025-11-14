package com.bing.service;

import com.bing.pojo.Admin;

public interface AdminService {
    Admin getAdminByLoginId(String loginId);
}
