package com.bing.dao.impl;

import com.bing.dao.EmpDao;
import com.bing.pojo.Emp;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工数据访问层实现类
 */
//@Component  // 交个Spring容器管理
// 通常数据访问层的类使用@Repository注解（就是通过注解名称能够语义化区分）
// 由于数据访问现在大部分都是采用Mybatis框架开发，所以该注解不常见
@Repository
public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Emp> listEmp() throws DocumentException {
        //一、加载xml文件里面的员工信息
        //员工集合
        List<Emp> emps = new ArrayList<>();
        //1.获取xml文件的解析器
        SAXReader saxReader = new SAXReader();
        //2.解析指定的xml文件，返回返回一个文档对象
        Document document = saxReader.read(this.getClass().getClassLoader().getResourceAsStream("data/emp.xml"));
        //3.获取根节点
        Element rootElement = document.getRootElement();
        //4.通过根节点拿到四个子节点
        List<Element> elements = rootElement.elements("emp");
        //5.遍历所有的子节点
        elements.forEach(element -> {
            //获取name
            String name = element.element("name").getText();
            //获取age
            String age = element.element("age").getText();
            //获取image
            String image = element.element("image").getText();
            //获取gender
            String gender = element.element("gender").getText();
            //获取job
            String job = element.element("job").getText();
            //根据拿到的数据，创建对应的员工对象
            Emp emp = new Emp(name,Integer.valueOf(age),image,gender,job);
            emps.add(emp);
        });
        return emps;
    }
}
