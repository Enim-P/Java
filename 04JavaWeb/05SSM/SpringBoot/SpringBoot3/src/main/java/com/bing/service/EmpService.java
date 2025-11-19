package com.bing.service;

import com.bing.pojo.Emp;
import org.dom4j.DocumentException;

import java.util.List;

/**
 * 员工业务逻辑层接口
 */
public interface EmpService {
    /**
     * 返回员工列表
     * @return
     */
    List<Emp> listEmp() throws DocumentException;
}
