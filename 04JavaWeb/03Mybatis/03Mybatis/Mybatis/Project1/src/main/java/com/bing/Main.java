package com.bing;

import com.bing.pojo.Student;
import com.bing.util.ParseXML;
import org.dom4j.DocumentException;

import java.util.List;

// 如何手动解析XML文件
public class Main {
    public static void main(String[] args) throws DocumentException {
        List<Student> students = ParseXML.parse();
        students.forEach(s->{
            System.out.println(s);
        });
    }
}
