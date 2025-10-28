package com.bing.web1.mapper;

import com.bing.web1.pojo.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    // 根据登录名返回用户信息
    @Select("select * from `admin` where loginId=#{loginId}")
    Admin getAdminByLoginId(String loginId);
}
