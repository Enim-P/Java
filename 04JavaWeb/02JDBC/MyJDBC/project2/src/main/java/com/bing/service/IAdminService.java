package com.bing.service;

/**
 * 管理员业务逻辑层接口
 */
public interface IAdminService {
    // 登录方法
    boolean login(String loginId,String loginPwd);
}
