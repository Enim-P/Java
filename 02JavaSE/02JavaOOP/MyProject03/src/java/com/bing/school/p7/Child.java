package com.bing.school.p7;

/**
 * 子类
 */
public class Child extends Parent {
    private String sex;
    private int age;

    public Child(){
        // 这里其实隐式调用了super()
    }

    //子类带参的构造函数
    public Child(int no,String name,String sex,int age){
        // 可以通过调用父类公开的方法，对父类的成员赋值
        /*this.setNo(no);
        this.setName(name);*/
        //这里的super就是调用父类指定的构造函数
        //注意：super一定要放在当前构造函数的第一行，因为在创建子类时，要先创建父类
        //如果没有手动指定super，其实是隐式调用无参的super来创建父类对象
        super(no,name);
        this.sex = sex;
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //@Override注解就表示该方法是重写的方法，该注解可以去掉
    //注意：这里的sayHi方法会重写掉父类中的sayHi方法，在内存中只有一个sayHi方法
    @Override
    public void sayHi() {
        System.out.println("这里是北京，北京欢迎你！");
    }

    @Override
    public String toString() {
        // this是当前类对象，当然this也能点出父类的成员，当前子类和父类成员同名时，就需要使用super来获取父类成员了
        // 这里的super是父类对象，调用父类的toString方法
        System.out.println(super.toString());
        return "Child{" +
                "sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
