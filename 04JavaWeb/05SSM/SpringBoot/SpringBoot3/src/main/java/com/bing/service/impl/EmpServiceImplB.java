package com.bing.service.impl;

import com.bing.dao.EmpDao;
import com.bing.pojo.Emp;
import com.bing.service.EmpService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 这是实现类B
@Service
public class EmpServiceImplB implements EmpService {
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
