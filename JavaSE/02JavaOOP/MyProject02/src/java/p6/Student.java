package p6;

/**
 * 学生类
 */
public class Student {
    //学号
    int no;
    //姓名
    String name;
    //年龄
    int age;
    //性别
    String sex;
    //成绩
    double score;
    //无参构造
    Student(){

    }
    //带参构造
    Student(int no,String name,int age,String sex,double score){
        this.no = no;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
    }
}
