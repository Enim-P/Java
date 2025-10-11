package com.bing.school.p2;
// import只能放在package的下面
//java.lang包不需要手动导入，编译器自动回帮我们导入
//import java.lang.*;
// 导入com.bing.school.p1包下面的Student类
//import com.bing.school.p1.Student;
//import com.bing.school.p1.Teacher;
//*表示导入com.bing.school.p1包里面的所有类
import com.bing.school.p1.*;
// 静态导入（直接导入类的静态成员）
//import static com.bing.school.p1.School.sayHi;

public class Test {
    public static void main(String[] args) {
        // Student类导入到当前类之后，才能创建Student对象
        Student student = new Student();
        // 只能访问不同包里面类的公共成员
        student.sex = "男";
        // 创建老师对象
        Teacher teacher = new Teacher();
        // sayHi();
        School.sayHi();
    }
}
