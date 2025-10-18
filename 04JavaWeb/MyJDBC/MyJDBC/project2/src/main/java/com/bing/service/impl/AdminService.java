package com.bing.service.impl;

import com.bing.dao.IAdminDao;
import com.bing.dao.impl.AdminDao;
import com.bing.pojo.Admin;
import com.bing.service.IAdminService;

/**
 * 管理员业务逻辑层实现类
 */
public class AdminService implements IAdminService {
    // 创建数据访问层对象
    IAdminDao adminDao = new AdminDao();

    @Override
    public boolean login(String loginId, String loginPwd) {
        // 根据登录名返回管理员对象
        Admin admin = adminDao.selectByLoginId(loginId);
        if(admin!=null){
            if(admin.getLoginPwd().equals(loginPwd)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
