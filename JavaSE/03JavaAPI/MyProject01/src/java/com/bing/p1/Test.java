package com.bing.p1;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 创建一个学生对象
        // 在创建学生对象的时候，明确泛型的具体类型
        Student<Integer> s1 = new Student<Integer>(1001,"张三",100);
        System.out.println(s1);
        // 后面的<>中的类型，可以省略，因为前面在定义类型时，已经明确
        Student<String> s2 = new Student<>(1002,"李四","优秀");
        System.out.println(s2);

        // 获取成绩时，它就是Integer类型，无需拆箱
        Integer score1 = s1.score;
        System.out.println(score1);

        // 获取成绩时，它就是String类型，无需拆箱
        String score2 = s2.score;
        System.out.println(score2);
        System.out.println("------------------------");
        Teacher teacher = new Teacher();
        // 调用方法时，根据传递的实参，确定泛型的具体类型
        String ret1 = teacher.test1("你好");
        Integer ret2 = teacher.test1(100);
        System.out.println(ret1);
        System.out.println(ret2);
        System.out.println("------------------------");
        // 在创建泛型类时，?通配符表示任意类型，其实就是Object类型
        // 直接使用通配符?和直接指定泛型类型为Object效果是一样的
        Student<?> s3 = new Student<>(1003,"王五","OK");
        // 设置?通配符的类型上限为Number类型（extends关键字是确定泛型的上限）
        // ?的范围是：只能是Number及其子类类型
        Student<? extends Number> s4 = new Student<>(1004,"小明",100.5);
        // super关键字是确定泛型的下限
        // ?的范围是：只能是Integer及其父类类型
        Student<? super Integer> s5 = new Student<>(1005,"小芳",100);

        // 注意：由于成绩的使用了通配符?定义类型，在接收的时候只能使用Object类型
        Object ret3 = s3.getScore();
        System.out.println("------------------------");
        Student2<Integer> stu1 = new Student2<>(1001,"小明",100);
        System.out.println(stu1);
        Student2<Double> stu2 = new Student2<>(1002,"小王",55.55);
        System.out.println(stu2);
        // 这里会报错，因为String类型不是Number类型的子类
        //Student2<String> stu3 = new Student2<String>(1003,"小刘","优秀");
    }
}
