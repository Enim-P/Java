package com.bing.dao;

import com.bing.pojo.Admin;

/**
 * 管理员数据访问层接口
 */
public interface IAdminDao {
    // 根据登录名查询管理员
    Admin selectByLoginId(String loginId);
}
