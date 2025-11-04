package com.bing.schoolmanager.mapper;

import com.bing.schoolmanager.pojo.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    @Select("select * from `admin` where loginId=#{loginId}")
    Admin getAdminByLoginId(String loginId);
}
