package com.bing.service.impl;

import com.bing.dao.EmpDao;
import com.bing.pojo.Emp;
import com.bing.service.EmpService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工业务逻辑层实现类
 */
//@Component   // 交个Spring容器管理
// 通常业务逻辑层的类使用@Service注解（就是通过注解名称能够语义化区分）
@Primary    //设置当前实现类是该接口的唯一Bean对象
@Service
public class EmpServiceImplA implements EmpService {
    // 注入员工数据访问层操作对象
    @Autowired
    EmpDao empDao;

    @Override
    public List<Emp> listEmp() throws DocumentException {
        List<Emp> emps = empDao.listEmp();
        //二、对数据进行转换处理，处理gender、job
        emps.forEach(emp -> {
            if(emp.getGender().equals("1")){
                emp.setGender("男");
            }else{
                emp.setGender("女");
            }
            if(emp.getJob().equals("1")){
                emp.setJob("讲师");
            }else if(emp.getJob().equals("2")){
                emp.setJob("班主任");
            }else{
                emp.setJob("就业指导");
            }
        });
        return emps;
    }
}
