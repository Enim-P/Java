package com.bing.service;

import com.bing.pojo.OperateLog;
import com.bing.pojo.PageBean;
import java.time.LocalDateTime;

/**
 * 操作日志Servide
 */
public interface OperateLogService {
    /**
     * 插入操作日志信息
     * @param operateLog 操作日志对象
     * @return 受影响行数
     */
    int insert(OperateLog operateLog);

    /**
     * 根据条件查询操作日志信息
     * @param operateUser 用户id
     * @param operateTime1 时间范围1
     * @param operateTime2 时间范围2
     * @param pageIndex 页码
     * @param pageSize 每页数量
     * @return 操作日志分页数据
     */
    PageBean<OperateLog> findByCondition(Integer operateUser,
                                         LocalDateTime operateTime1,
                                         LocalDateTime operateTime2,
                                         Integer pageIndex,
                                         Integer pageSize);
}
