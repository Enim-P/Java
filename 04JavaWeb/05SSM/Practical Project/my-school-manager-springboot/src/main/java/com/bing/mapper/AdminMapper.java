package com.bing.mapper;

import com.bing.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户Mapper
 */
@Mapper
public interface AdminMapper {

    /**
     * 注册用户
     * @param admin 用户对象
     * @return 受影响行数
     */
    @Options(keyProperty = "id",useGeneratedKeys = true)  // 回传主键
    @Insert("insert into `admin`(loginId,loginPwd) values(#{loginId},#{loginPwd})")
    int register(Admin admin);

    /**
     * 添加用户
     * @param admin 用户对象
     * @return 受影响行数
     */
    @Options(keyProperty = "id",useGeneratedKeys = true)  // 回传主键
    @Insert("insert into `admin`(loginId,loginPwd,name,sex,phone,type,photo,inDate) " +
            "values(#{loginId},#{loginPwd},#{name},#{sex},#{phone},#{type},#{photo},#{inDate})")
    int insert(Admin admin);

    /**
     * 修改用户
     * @param admin 用户对象
     * @return 受影响行数
     */
    @Update("update `admin` set name=#{name},sex=#{sex},phone=#{phone},type=#{type}," +
            "photo=#{photo},inDate=#{inDate} where id=#{id}")
    int update(Admin admin);

    /**
     * 修改密码
     * @param id 用户id
     * @param oldPwd 原始密码
     * @param newPwd 新的密码
     * @return 受影响行数
     */
    @Update("update `admin` set loginPwd=#{newPwd} where id=#{id} and loginPwd=#{oldPwd}")
    int updatePwd(@Param("id") Integer id,@Param("oldPwd") String oldPwd,@Param("newPwd") String newPwd);

    /**
     * 删除用户
     * @param id 用户id
     * @return 受影响行数
     */
    @Delete("delete from `admin` where id=#{id}")
    int delete(Integer id);

    /**
     * 根据登录名查询用户
     * @param loginId 登录名
     * @return 用户对象
     */
    @Select("select * from `admin` where loginId=#{loginId}")
    Admin findByLoginId(String loginId);

    /**
     * 根据条件查询用户
     * @param type 类型
     * @param name 姓名
     * @return 用户集合
     */
    List<Admin> findByCondition(@Param("type") String type,@Param("name") String name);

}
