package com.bing.school.p9;

/**
 * 入口类
 */
public class Main {
    // 入口方法
    public static void main(String[] args) {
        // 创建一个员工数组
        // 子类对象是可以使用父类类型来接收的，这就叫做：向上转型
        Employee[] employees = {
                //创建员工对象
                new Employee(1001,"马云"),
                //创建软件开发工程师对象
                new Engineer(1002,"雷军"),
                //创建测试工程师
                new Test(1003,"李彦宏"),
                //创建项目经理
                new Manager(1004,"马化腾")
        };
        // 循环数组，执行每个员工的工作
        for(Employee employee : employees){
            // 执行员工的工作方法，同一个方法的具体的表现是不同的，这就是多态
            employee.jop();
            // 子类对象可以用父类类型接收，但是不能调用子类特有的方法
            // 这个时候就需要对父类类型接收的对象向下转型了
            // 向下转型之前要先判断该对象，是不是具体的子类类型
            if(employee instanceof Manager){
                // 通过强制类型转换的方式，将父类类型对象转为具体的子类类型对象
                Manager manager = (Manager)employee;
                // 调用项目经理的应酬方法
                manager.social();
            }
        }
        // 多态总结：
        // 同种类型的的多个对象，对同一个行为有不同的表现，这就是多态
    }
}
