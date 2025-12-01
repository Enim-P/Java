package com.bing.mapper;

import com.bing.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 操作日志Mapper
 */
@Mapper
public interface OperateLogMapper {

    /**
     * 插入操作日志信息
     * @param operateLog 操作日志对象
     * @return 受影响行数
     */
    @Insert("insert into operate_log(operate_user,operate_time,class_name,method_name,method_params,return_value,cost_time) " +
            "values(#{operateUser},#{operateTime},#{className},#{methodName},#{methodParams},#{returnValue},#{costTime})")
    int insert(OperateLog operateLog);

    /**
     * 根据条件查询操作日志信息
     * @param operateUser 用户id
     * @param operateTime1 时间范围1
     * @param operateTime2 时间范围2
     * @return 操作日志集合
     */
    List<OperateLog> findByCondition(@Param("operateUser") Integer operateUser,
                                     @Param("operateTime1") LocalDateTime operateTime1,
                                     @Param("operateTime2") LocalDateTime operateTime2);
}
