package com.bing.util;

import com.bing.pojo.Student;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析XML
 */
public class ParseXML {
    // 解析指定的xml文件，并将结果以集合的方式返回
    public static List<Student> parse() throws DocumentException {
        // 创建方法需要返回的学生集合
        List<Student> students = new ArrayList<>();
        // 创建解析器
        SAXReader saxReader = new SAXReader();
        // 获取文档对象
        Document document = saxReader.read(ParseXML.class.getClassLoader().getResourceAsStream("stus.xml"));
        // 获取根节点对象
        Element rootElement = document.getRootElement();
        // 获取根节点下面的所有student节点
        List<Element> elements = rootElement.elements("student");
        // 遍历所有的student节点
        elements.forEach(element -> {
            // 获取no属性的值
            String no = element.attribute("no").getValue();
            // 获取name元素的值
            String name = element.element("name").getText();
            // 获取age元素的值
            int age = Integer.valueOf(element.element("age").getText());
            // 获取sex元素的值
            String sex = element.element("sex").getText();
            // 获取score元素的value属性的值
            double score = Double.valueOf(element.element("score").attribute("value").getValue());

            // 创建学生对象
            Student student = new Student(no,name,age,sex,score);
            // 并将学生对象添加到学生集合中
            students.add(student);
        });

        // 返回学生集合
        return students;
    }
}
