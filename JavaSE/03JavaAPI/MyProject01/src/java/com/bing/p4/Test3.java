package com.bing.p4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 练习1
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 使用匿名类，初始化集合中的元素
        // 从jdk9开始,<>运算符中才可以省略数据类型
        List<String> names = new ArrayList<String>(){{
            this.add("张三");
            this.add("李四");
            this.add("王五");
            this.add("赵六");
        }};
        while (true){
            System.out.println("1.查看学生");
            System.out.println("2.添加学生");
            System.out.println("3.修改学生");
            System.out.println("4.删除学生");
            System.out.println("0.退出");
            System.out.print("请选择：");
            int no = input.nextInt();
            if(no==1){
                System.out.println(names);
            }else if(no==2){
                //姓名不能重复
                System.out.print("请输入姓名：");
                String name = input.next();
                if(names.contains(name)){
                    System.out.println("该姓名已经存储！");
                }else{
                    names.add(name);
                    System.out.println("添加成功！");
                }
            }else if(no==3){
                //输入原始姓名，再输入新的姓名，通过indexOf查找位置
                //这里的修改，是先删除当前位置的姓名，再插入新的姓名
                System.out.print("请输入需要修改的姓名：");
                String name = input.next();
                // 查找该姓名在集合中的位置
                int index = names.indexOf(name);
                if(index==-1){
                    System.out.println("该姓名不存在！");
                }else{
                    System.out.print("请输入将修改后的姓名：");
                    String name2 = input.next();
                    names.remove(index);  //先删除之前的姓名
                    names.add(index,name2);   //再插入新的姓名
                    System.out.println("修改成功！");
                }
            }else if(no==4){
                //输入姓名将该姓名从数组中删除
                System.out.print("请输入姓名：");
                String name = input.next();
                if(names.contains(name)){
                    // remove方法，是方法重载
                    // 传索引根据索引删除元素，传值根据值删除第一个元素
                    names.remove(name);
                    System.out.println("删除成功！");
                }else{
                    System.out.println("该姓名不存在！");
                }
            }else{
                System.out.println("成功退出！");
                break;
            }
        }
    }
}
