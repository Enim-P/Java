package com.bing.school.p4;

/**
 * 学生类
 */
public class Student {
    //学号
    private int no;
    //姓名
    private String name;
    //年龄
    private int age;
    //性别
    private String  sex;
    //年龄
    private double score;

    // 由于成员变量的访问权限是私有的，为了能获取到值，要给每个成员变量封装一个get方法
    public int getNo(){
        return this.no;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getSex(){
        return this.sex;
    }
    public double getScore(){
        return this.score;
    }

    // 由于成员变量的访问权限是私有的，操作成员变量的唯一途径只能是通过方法传递参数实现
    public void setNo(int no){
        this.no = no;
    }

    public void setName(String name){
        if(name.length()>=2 && name.length()<=4){
            this.name = name;
        }else{
            System.out.println("姓名不规范...");
            this.name = "不详";
        }
    }

    public void setAge(int age) {
        //通过方法给成员变量赋值的意义在于，在方法可以写保护
        if(age>=0 && age<=100){
            this.age = age;
        }else{
            System.out.println("年龄超出范围...");
            this.age = 18;
        }
    }

    public void setSex(String sex){
        if(sex=="男" || sex=="女"){
            this.sex = sex;
        }else{
            System.out.println("性别只能是男或女...");
            this.sex = "男";
        }
    }

    public void setScore(double score) {
        if(score>=0 && score<=100){
            this.score = score;
        }else{
            System.out.println("成绩只能是0-100之间");
            this.score = 0;
        }
    }

    //自我介绍的方法
    public void sayHi(){
        System.out.println(String.format("大家好！我叫%s，学号是%s，今年%s岁，性别是%s，今天考了%s分",
                name,no,age,sex,score));
    }

}
