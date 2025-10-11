package com.bing.p4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 学校类
 */
public class School {
    Scanner input = new Scanner(System.in);
    List<Student> students = new ArrayList<>();

    public School(){
        // 判断stus.txt文件是否存在
        if(new File("file/stus.txt").exists()){
            // 创建对象时，通过文件流读取学生信息到集合中
            try(BufferedReader reader = new BufferedReader(
                    new FileReader("file/stus.txt")
            )){
                while (true){
                    String line = reader.readLine();   //读取一行
                    // 判断是否读到了结束标记
                    if(line.equals("end")){
                        break;
                    }
                    // 根据分隔符，将数据打散成数组
                    String[] datas = line.split("\\|");
                    // 创建学生对象
                    Student s = new Student(datas[0],datas[1],Integer.valueOf(datas[2]));
                    students.add(s);
                }
            }catch (IOException e){
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
            // 使用文件流持久化存储学生信息
            try(BufferedWriter writer = new BufferedWriter(
                    new FileWriter("file/stus.txt")
            )){
                students.forEach(s->{
                    try {
                        // 每个学生对象写一行
                        writer.write(s.getNo()+"|"+s.getName()+"|"+s.getAge());
                        // 写一行换一行
                        writer.newLine();
                    } catch (IOException e) {
                       e.printStackTrace();
                    }
                });
                // 写一个结束符
                writer.write("end");
                writer.flush();   //刷新写入操作
            }catch (IOException e){
                e.printStackTrace();
            }
            return;
        }
        menu();
    }
}
