package p5;

import java.util.Scanner;

/**
 * 学生类
 */
public class Student {
    Scanner input = new Scanner(System.in);
    //长度为10的课程数组
    String[] subjects = new String[10];
    Student(){
        subjects[0] = "语文";
        subjects[1] = "数学";
        subjects[2] = "英语";
    }
    //查看课程信息的方法
    void show(){
        //打印输出数组中所有的课程信息，注意：为空的信息不要输出
        System.out.print("课程信息包括：");
        for (String s : subjects){
            if(s!=null){
                System.out.print(s+" ");
            }
        }
        System.out.println();
    }
    //添加课程的方法
    void add(){
        //输入需要添加的课程名称，并添加到数组中
        //注意：如果数组满了，要给出相关提示，如果输入的课程名称存在，要给出相关提示
        System.out.print("请输入需要添加的课程名称：");
        String name = input.next();
        for(int i=0;i<subjects.length;i++){
            // 判断数组中是否已经存储需要添加的课程
            if(subjects[i]!=null && subjects[i].equals(name)){
                System.out.println("需要添加的课程已经存在！");
                break;
            }
            if(subjects[i]==null){
                //找一个空的空间，将需要添加的课程添加进去
                subjects[i] = name;
                System.out.println("添加成功！");
                break;
            }
            if(i==subjects.length-1){
                System.out.println("存储空间已经满！无法添加新的课程！");
            }
        }
    }
    //修改课程的方法
    void update(){
        //输入需要修改的课程名称，再输入修改为的课程名称，将之前的课程替换掉
        //注意：需要修改的课程必须要存在，否则要给出相关提示
        //注意：修改为什么的课程，必须要跟其他课程不重复
        System.out.print("请输入需要修改的课程名称：");
        String name1 = input.next();
        System.out.print("请输入修改为什么课程名称：");
        String name2 = input.next();
        int index = -1;   //name1在数组中的位置
        for(int i=0;i<subjects.length;i++){
            // 查找更新的位置
            if(subjects[i]!=null && subjects[i].equals(name1)){
                index = i;
            }
            // 查找新的课程是否已经存在
            if(subjects[i]!=null && subjects[i].equals(name2)){
                System.out.println("更新的课程名称，已经存在！");
                return;
            }
        }
        //判断是否找到了需要更新课程的位置
        if(index!=-1){
            subjects[index] = name2;
            System.out.println("更新课程名称成功！");
        }else{
            System.out.println("需要更新的课程不存在！");
        }
    }
    //删除课程的方法
    void delete(){
        //输入需要删除的课程名称，将该课程在数组中删除掉
        //注意：如果删除的是中间的课程，后面的课程需要往前挪动
        System.out.print("请输入需要删除的课程名称：");
        String name = input.next();
        int index = -1;  //删除的位置
        for(int i=0;i<subjects.length;i++){
            if(subjects[i]!=null && subjects[i].equals(name)){
                index = i;
                subjects[index] = null;
                System.out.println("删除成功！");
                break;
            }
            if(i==subjects.length-1){
                System.out.println("需要删除的课程不存在！");
                return;
            }
        }
        // 调整删除后元素的位置
        for(int i=index;i<subjects.length-1;i++){
            subjects[i] = subjects[i+1];  //我到前面去
            subjects[i+1] = null;     //清掉我自己
        }
    }
    // 菜单方法
    void menu(){
        while(true){
            System.out.println("*************课程管理************");
            System.out.println("1.查看所有课程信息");
            System.out.println("2.添加课程");
            System.out.println("3.修改课程");
            System.out.println("4.删除课程");
            System.out.println("0.退出系统");
            System.out.println("********************************");
            System.out.print("请选择操作：");
            int no = input.nextInt();
            if(no==1){
                show();
            }else if(no==2){
                add();
            }else if(no==3){
                update();
            }else if(no==4){
                delete();
            }else{
                System.out.println("成功退出系统！");
                break;
            }
        }
    }
}
