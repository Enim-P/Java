package com.bing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bing.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户Mapper
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 修改密码
     * @param id 用户id
     * @param oldPwd 原始密码
     * @param newPwd 新的密码
     * @return 受影响行数
     */
    @Update("update `admin` set loginPwd=#{newPwd} where id=#{id} and loginPwd=#{oldPwd}")
    int updatePwd(@Param("id") Integer id,@Param("oldPwd") String oldPwd,@Param("newPwd") String newPwd);
}
