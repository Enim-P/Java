package com.bing.dao;

import com.bing.pojo.Emp;
import org.dom4j.DocumentException;

import java.util.List;

/**
 * 员工数据访问层接口
 */
public interface EmpDao {
    /**
     * 返回员工列表
     * @return
     */
    List<Emp> listEmp() throws DocumentException;
}
