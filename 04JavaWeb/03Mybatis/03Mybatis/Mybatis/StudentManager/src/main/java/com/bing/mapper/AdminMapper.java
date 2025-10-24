package com.bing.mapper;

import com.bing.pojo.Admin;

/**
 * 管理员Mapper
 */
public interface AdminMapper {
    // 根据登录名查询管理员
    Admin selectByLoginId(String loginId);
}
