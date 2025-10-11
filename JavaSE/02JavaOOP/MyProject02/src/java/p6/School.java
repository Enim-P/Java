package p6;

import java.util.Scanner;

/**
 * 学校类
 */
public class School {
    Scanner input = new Scanner(System.in);
    // 创建一个学生类型的数组，该数组中只能存储学生类型的对象
    Student[] students = new Student[10];
    School(){
        //在数组中初始化几个学生信息
        students[0] = new Student(1001,"小明",20,"女",72.5);
        students[1] = new Student(1002,"小杰",21,"男",86.7);
        students[2] = new Student(1003,"小强",19,"男",55.6);
        students[3] = new Student(1004,"小芳",22,"女",48.9);
    }

    //查看学生
    void show(){
        System.out.println("********查看学生********");
        System.out.println("学号\t\t姓名\t年龄\t性别\t成绩");
        for(Student s : students){
            if(s!=null){
                System.out.println(String.format("%s\t%s\t%s\t%s\t%s",
                        s.no,s.name,s.age,s.sex,s.score));
            }
        }
    }

    // 根据学号查找学生(找不到返回null)
    Student findStudentByNo(int no){
        Student student = null;
        for(Student s : students){
            if(s!=null && s.no==no){
                student = s;
                break;
            }
        }
        return student;
    }

    //添加学生
    void add(){
        System.out.println("********添加学生********");
        System.out.print("请输入学号：");
        int no = input.nextInt();
        // 判断学号是否存在
        if(findStudentByNo(no)!=null){
            System.out.println("该学号已经存在，添加失败！");
            return;
        }
        System.out.print("请输入姓名：");
        String name = input.next();
        System.out.print("请输入年龄：");
        int age = input.nextInt();
        System.out.print("请输入性别：");
        String sex = input.next();
        System.out.print("请输入成绩：");
        double score = input.nextDouble();
        //创建学生对象
        Student s = new Student(no,name,age,sex,score);
        //循环数组，找一个空的空间，将学生对象放进去
        for(int i=0;i<students.length;i++){
            if(students[i]==null){
                students[i] = s;
                System.out.println("添加成功！");
                break;
            }
        }
    }

    //修改方法
    void update(){
        System.out.println("********修改学生********");
        //是根据学号修改学生的其他信息
        System.out.print("请输入需要修改的学生学号：");
        int no = input.nextInt();
        //根据学号查找该学生对象
        Student s = findStudentByNo(no);
        if(s==null){
            System.out.println("学号不存在！修改失败！");
            return;
        }
        System.out.println(String.format("当前学生的信息为：学号：%s 姓名：%s 年龄：%s 性别：%s 成绩：%s",
                s.no,s.name,s.age,s.sex,s.score));
        System.out.print("请输入修改的姓名：");
        s.name = input.next();
        System.out.print("请输入修改的年龄：");
        s.age = input.nextInt();
        System.out.print("请输入修改的性别：");
        s.sex = input.next();
        System.out.print("请输入修改的成绩：");
        s.score = input.nextDouble();
        System.out.println("修改成功！");
    }

    //删除方法
    void delete(){
        System.out.println("********删除学生********");
        System.out.print("请输入需要删除的学生学号：");
        int no = input.nextInt();
        if(findStudentByNo(no)==null){
            System.out.println("学号不存在！删除失败！");
            return;
        }
        //学生删除后，后面的学生需要往前挪动位置
        int index = -1;  //删除的的学生索引
        //第一个for是找到位置，并删除该位置上的学生对象
        for(int i=0;i<students.length;i++){
            if(students[i]!=null && students[i].no==no){
                students[i] = null;
                index = i;
                break;
            }
        }
        //第二个for，用于调整后面学生的位置
        for(int i=index;i<students.length-1;i++){
            students[i] = students[i+1];
            students[i+1] = null;
        }
        System.out.println("删除成功！");
    }

    // 成绩排名
    void sort(){
        System.out.println("********成绩排名********");
        // 将原始数组复制一份出来
        Student[] students2 = new Student[students.length];
        for(int i=0;i<students.length;i++){
            students2[i] = students[i];
        }

        //手写排序算法，根据学生的成绩对数组中的数据排序
        for(int i=0;i<students2.length-1;i++){
            for(int j=0;j<students2.length-1-i;j++){
                if(students2[j]!=null && students2[j+1]!=null && students2[j].score<students2[j+1].score){
                    Student temp = students2[j];
                    students2[j] = students2[j+1];
                    students2[j+1] = temp;
                }
            }
        }

        System.out.println("学号\t\t姓名\t年龄\t性别\t成绩");
        for(Student s : students2){
            if(s!=null){
                System.out.println(String.format("%s\t%s\t%s\t%s\t%s",
                        s.no,s.name,s.age,s.sex,s.score));
            }
        }
    }


    //主菜单方法
    void menu(){
        while(true){
            System.out.println("************学生管理系统***********");
            System.out.println("1.查看学生");
            System.out.println("2.添加学生");
            System.out.println("3.修改学生");
            System.out.println("4.删除学生");
            System.out.println("5.成绩排名");
            System.out.println("0.退出系统");
            System.out.println("*********************************");
            System.out.print("请选择：");
            int no = input.nextInt();
            if(no==1){
                show();  //调用查看学生的方法
            }else if(no==2){
                add();   //调用添加学生的方法
            }else if(no==3){
                update();  //调用修改学生的方法
            }else if(no==4){
                delete();  //调用删除学生的方法
            }else if(no==5){
                sort();    //调用排序成绩的方法
            }else{
                System.out.println("成功退出系统！");
                break;
            }
        }
    }

}
