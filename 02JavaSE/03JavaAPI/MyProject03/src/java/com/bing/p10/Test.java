package com.bing.p10;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        ORM orm = new ORM();
        Student student = new Student("1001","王杰","男",22);
        Car car = new Car("苏A1001","保时捷",200);
        // 返回查询语句
        String sql1 = orm.select(student);
        String sql2 = orm.select(car);
        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println("------------------------");
        // 返回新增语句
        String sql3 = orm.insert(student);
        String sql4 = orm.insert(car);
        System.out.println(sql3);
        System.out.println(sql4);
        System.out.println("------------------------");
        // 返回修改语句
        String sql5 = orm.update(student);
        String sql6 = orm.update(car);
        System.out.println(sql5);
        System.out.println(sql6);
        System.out.println("------------------------");
        // 返回删除语句
        String sql7 = orm.delete(student);
        String sql8 = orm.delete(car);
        System.out.println(sql7);
        System.out.println(sql8);
    }
}
