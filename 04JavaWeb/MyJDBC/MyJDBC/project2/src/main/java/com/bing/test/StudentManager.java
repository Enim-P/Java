package com.bing.test;

import com.bing.pojo.Student;
import com.bing.service.IAdminService;
import com.bing.service.IStudentService;
import com.bing.service.impl.AdminService;
import com.bing.service.impl.StudentService;

import java.util.List;
import java.util.Scanner;

/**
 * UI层
 */
public class StudentManager {
    Scanner input = new Scanner(System.in);
    // 创建管理员业务逻辑类对象
    IAdminService adminService = new AdminService();
    // 创建学生业务逻辑类对象
    IStudentService studentService = new StudentService();
    /**
     * 登录入口
     */
    public void loginUI(){
        System.out.println("**************登录系统***************");
        System.out.print("请输入账号：");
        String loginId = input.nextLine();
        System.out.print("请输入密码：");
        String loginPwd = input.nextLine();
        if(adminService.login(loginId,loginPwd)){
            System.out.println("登录成功！");
            menu();   //调用菜单方法
        }else{
            System.out.println("登录失败！登录名或密码错误！");
        }
    }

    /**
     * 菜单方法
     */
    public void menu(){
        System.out.println("****************学生管理系统****************");
        System.out.println("1.添加学生");
        System.out.println("2.修改学生");
        System.out.println("3.删除学生");
        System.out.println("4.查询全部学生");
        System.out.println("5.查询指定年级的学生");
        System.out.println("6.根据学生姓名查询学生");
        System.out.println("7.根据年级和学生姓名查询学生");
        System.out.println("0.退出系统");
        System.out.print("请选择：");
        int no = input.nextInt();
        switch (no){
            case 1:
                addStudent();
                break;
            case 2:
                updateStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                selectAllStudent();
                break;
            case 5:
                selectStudentByGrade();
                break;
            case 6:
                selectStudentByName();
                break;
            case 7:
                selectstudentByGradeAndName();
                break;
            default:
                System.out.println("成功退出！！！");
                return;  //退出递归
        }
        menu();  //递归调用
    }

    // 添加学生
    public void addStudent(){}
    // 修改学生
    public void updateStudent(){}
    // 删除学生
    public void deleteStudent(){}
    // 查询全部学生
    public void selectAllStudent(){
        System.out.println("**************查询全部学生信息****************");
        System.out.println("学号\t\t姓名\t\t性别\t\t年级\t\t电话");
        List<Student> students = studentService.selectAll();
        students.forEach(s->{
            System.out.println(s.getStudentNo()+"\t"+
                    s.getStudentName()+"\t"+
                    s.getSex()+"\t"+
                    s.getGrade().getGradeName()+"\t"+
                    s.getPhone());
        });
    }
    // 根据年级查询学生
    public void selectStudentByGrade(){
        System.out.println("**************根据年级查询学生信息****************");
        // 先把有哪些年级显示出来
        // 然后再提示用户输入年级编号

    }
    // 根据姓名查询学生
    public void selectStudentByName(){
        System.out.println("**************根据姓名查询学生信息****************");
        // 提示用户输入学生的姓名（根据输入的学生姓名进行模糊查询）

    }
    // 根据年级和姓名查询学生
    public void selectstudentByGradeAndName(){
        System.out.println("**************根据年级和姓名查询学生信息****************");
        // 先输入年级编号，再输入学姓名，同时根据年级编号和学生的姓名模糊查询

    }
}
