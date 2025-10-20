package com.bing.test;

import com.bing.pojo.Grade;
import com.bing.pojo.Student;
import com.bing.service.IAdminService;
import com.bing.service.IGradeService;
import com.bing.service.IResultService;
import com.bing.service.IStudentService;
import com.bing.service.impl.AdminService;
import com.bing.service.impl.GradeService;
import com.bing.service.impl.ResultService;
import com.bing.service.impl.StudentService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    // 创建年级业务逻辑类对象
    IGradeService gradeService = new GradeService();
    // 创建成绩业务逻辑类对象
    IResultService resultService = new ResultService();

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
    public void addStudent(){
        System.out.println("**************添加学生信息****************");
        System.out.print("请输入学号：");
        String studentNo = input.next();
        // 判断学号是否存在
        if(studentService.selectStudentByNo(studentNo)!=null){
            System.out.println("您输入的学号已经存在！请重新输入！！！");
            return;
        }
        System.out.print("请输入密码：");
        String loginPwd = input.next();
        System.out.print("请输入姓名：");
        String studentName = input.next();
        System.out.print("请输入性别：");
        String sex = input.next();
        List<Grade> grades = gradeService.selectAll();
        System.out.println("年级信息如下：");
        System.out.println("年级编号\t年级名称");
        grades.forEach(g->{
            System.out.println(g.getGradeId()+"\t"+g.getGradeName());
        });
        System.out.print("请输入年级编号：");
        int gradeId = input.nextInt();
        System.out.print("请输入电话：");
        String phone = input.next();
        System.out.print("请输入地址：");
        String address = input.next();
        LocalDateTime bornDate = LocalDateTime.now();
        System.out.print("请输入邮箱：");
        String email = input.next();
        System.out.print("请输入身份证：");
        String identityCard = input.next();
        // 创建学生对象，设置相关属性
        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        student.setStudentName(studentName);
        student.setSex(sex);
        student.setGradeId(gradeId);
        student.setPhone(phone);
        student.setAddress(address);
        student.setBornDate(bornDate);
        student.setEmail(email);
        student.setIdentityCard(identityCard);
        // 判断是否添加成功
        if(studentService.insertStudent(student)>0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
    }
    // 修改学生
    public void updateStudent(){
        System.out.println("**************修改学生信息****************");
        System.out.print("请输入需要修改的学生的学号：");
        String studentNo = input.next();
        Student student = studentService.selectStudentByNo(studentNo);
        if(student==null){
            System.out.println("您输入的学生不存在！");
            return;
        }
        System.out.println("学生信息如下：");
        System.out.println("学号\t密码\t姓名\t性别\t年级\t电话\t地址\t生日\t邮箱\t身份证");
        System.out.println(student.getStudentNo()+"\t"+
                student.getLoginPwd()+"\t"+
                student.getStudentName()+"\t"+
                student.getSex()+"\t"+
                student.getGrade().getGradeName()+"\t"+
                student.getPhone()+"\t"+
                student.getAddress()+"\t"+
                student.getBornDate()+"\t"+
                student.getEmail()+"\t"+
                student.getIdentityCard());
        System.out.println("*******************************************");
        System.out.print("请输修改后的密码：");
        student.setLoginPwd(input.next());
        System.out.print("请输修改后的姓名：");
        student.setStudentName(input.next());
        System.out.print("请输修改后的性别：");
        student.setSex(input.next());
        System.out.print("请输修改后的电话：");
        student.setPhone(input.next());
        System.out.print("请输修改后的地址：");
        student.setAddress(input.next());
        if(studentService.updateStudent(student)>0){
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
    }
    // 删除学生
    public void deleteStudent(){
        System.out.println("**************删除学生信息****************");
        System.out.print("请输入需要删除的学生的学号：");
        String studentNo = input.next();
        // 判断该学生有没有成绩
        int count = resultService.resultCountByStudentNo(studentNo);
        if(count>0){
            System.out.print("当前学生存在成绩数据，是否确定删除（y/n）:");
            String isDel = input.next();
            if(isDel.equals("n")){
                System.out.println("成功撤销删除操作！！！");
                return;
            }
            // 删除成绩
            resultService.deleteResultByStudentNo(studentNo);
        }
        // 删除学生
        if(studentService.deleteStudent(studentNo)>0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }

    }
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
        List<Grade> grades = gradeService.selectAll();
        System.out.println("年级信息如下：");
        System.out.println("年级编号\t年级名称");
        grades.forEach(g->{
            System.out.println(g.getGradeId()+"\t"+g.getGradeName());
        });
        System.out.print("请输入年级编号：");
        int gradeId = input.nextInt();
        // 根据年级编号查询学生
        List<Student> students = studentService.selectByGrade(gradeId);
        System.out.println("学号\t\t姓名\t\t性别\t\t年级\t\t电话");
        students.forEach(s->{
            System.out.println(s.getStudentNo()+"\t"+
                    s.getStudentName()+"\t"+
                    s.getSex()+"\t"+
                    s.getGrade().getGradeName()+"\t"+
                    s.getPhone());
        });

    }
    // 根据姓名查询学生
    public void selectStudentByName(){
        System.out.println("**************根据姓名查询学生信息****************");
        // 提示用户输入学生的姓名（根据输入的学生姓名进行模糊查询）
        System.out.print("请输入需要查找的学生姓名：");
        String studentName = input.next();
        List<Student> students = studentService.selectByName(studentName);
        System.out.println("学号\t\t姓名\t\t性别\t\t年级\t\t电话");
        students.forEach(s->{
            System.out.println(s.getStudentNo()+"\t"+
                    s.getStudentName()+"\t"+
                    s.getSex()+"\t"+
                    s.getGrade().getGradeName()+"\t"+
                    s.getPhone());
        });
    }
    // 根据年级和姓名查询学生
    public void selectstudentByGradeAndName(){
        System.out.println("**************根据年级和姓名查询学生信息****************");
        // 先输入年级编号，再输入学姓名，同时根据年级编号和学生的姓名模糊查询
        List<Grade> grades = gradeService.selectAll();
        System.out.println("年级信息如下：");
        System.out.println("年级编号\t年级名称");
        grades.forEach(g->{
            System.out.println(g.getGradeId()+"\t"+g.getGradeName());
        });
        System.out.print("请输入年级编号：");
        int gradeId = input.nextInt();
        System.out.print("请输入需要查找的学生姓名：");
        String studentName = input.next();
        List<Student> students = studentService.selectByGradeAndName(gradeId,studentName);
        System.out.println("学号\t\t姓名\t\t性别\t\t年级\t\t电话");
        students.forEach(s->{
            System.out.println(s.getStudentNo()+"\t"+
                    s.getStudentName()+"\t"+
                    s.getSex()+"\t"+
                    s.getGrade().getGradeName()+"\t"+
                    s.getPhone());
        });
    }
}
