package com.bing.p6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 学校类
 */
public class School {
    Scanner input = new Scanner(System.in);
    List<Student> students = new ArrayList<>();

    public School(){
        // 判断test16.txt文件是否存在
        if(new File("file/test16.txt").exists()){
            // 返序列化学生集合
            try(ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream("file/test16.txt")
            )){
                students = (ArrayList<Student>)inputStream.readObject();
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    public void menu(){
        System.out.println("**********学生管理系统*********");
        System.out.println("1.添加学生");
        System.out.println("2.查看学生");
        System.out.println("3.退出系统");
        System.out.println("****************************");
        System.out.print("请选择：");
        int no = input.nextInt();
        if(no==1){
            System.out.print("请输入学号：");
            String xh = input.next();
            System.out.print("请输入姓名：");
            String name = input.next();
            System.out.print("请输入年龄：");
            int age = input.nextInt();
            // 创建学生对象
            Student stu = new Student(xh,name,age);
            students.add(stu);
            System.out.println("添加成功！");
        }else if(no==2){
            System.out.println("学号\t\t姓名\t\t年龄");
            students.forEach(s->{
                System.out.println(s.getNo()+"\t\t"+s.getName()+"\t\t"+s.getAge());
            });
        }else{
            System.out.println("成功退出！");
            // 序列化学生集合
            try(ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream("file/test16.txt")
            )){
                // 序列化整个集合
                outputStream.writeObject(students);
                outputStream.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
            return;
        }
        menu();
    }
}
