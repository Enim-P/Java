package com.bing.service.impl;

import com.bing.mapper.AdminMapper;
import com.bing.pojo.Admin;
import com.bing.service.IAdminService;
import com.bing.util.MybatisUtil;

/**
 * 管理员业务逻辑层实现类
 */
public class AdminService implements IAdminService {
    // 创建数据访问层对象
    AdminMapper adminDao = MybatisUtil.getSession(true)
            .getMapper(AdminMapper.class);

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
