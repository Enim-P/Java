package com.bing.controller;

import com.bing.pojo.Emp;
import com.bing.pojo.Result;
import com.bing.service.EmpService;
import com.bing.service.impl.EmpServiceImplA;
import com.bing.service.impl.EmpServiceImplB;
import com.one.Student;
import com.two.Teacher;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller3 {
    // 注入员工业务逻辑层对象
    // 使用@Autowired注解 或 @Resource注解注入对象
    // Spring框架会从它的容器中找到EmpService接口的实现类创建好对象给我
    // 但是当EmpService接口存在多个实现类时，Spring就不确定到底创建哪个了
    @Autowired
    EmpService empService;

    // 如果一个接口类型注册了多个实现类
    // 使用@Autowired注入时，需要结合@Qualifier注解根据bean对象名称，指定具体的bean。
    /*@Autowired
    @Qualifier("empServiceImplA")
    EmpService empService;*/

    //@Resource注解，在注入对象时，可以传递bean的名称参数
    /*@Resource(name = "empServiceImplB")
    EmpService empService;*/

    @Autowired
    Student student;
    @Autowired
    Teacher teacher;

    /*
        依赖注入的两个注解：
        @Autowired：默认按照类型自动装配，结合@Qualifier注解根据名称自动装配
        @Resource：默认安装名称自动装配，通过传递参数可以知道具体的名称
        @Autowired是spring框架提供的注解，@Resource是jdk提供的注解
        @Primary注意：用于设置同种类型的唯一Bean对象，只适用于自动装配，手动根据bean名称查找不受影响
    */


    @GetMapping("/stu")
    public String getStudent(){
        student.setName("张三");
        student.setAge(20);
        return student.toString();
    }

    @GetMapping("/tea")
    public String getTeacher(){
        student.setName("李四");
        student.setAge(30);
        return student.toString();
    }

    // 未使用分层思想
    @GetMapping("/empList1")
    public Result empList1() throws DocumentException {
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
        //三、响应结果
        return Result.success(emps);
    }

    //使用分层思想
    @GetMapping("/empList2")
    public Result empList2() throws DocumentException {
        List<Emp> emps = empService.listEmp();
        return Result.success(emps);
    }
}
