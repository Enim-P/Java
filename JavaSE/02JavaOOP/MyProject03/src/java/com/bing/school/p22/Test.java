package com.bing.school.p22;

/*
对象设计（面向对象、多态运用）
设计一个Person抽象类，包含吃饭运动学习三种行为，分为工人、学生、老师三种职业。
设计一个接口考试，只有老师和学生会考试。
设计一个方法，模拟让人类进入考场，要求只有会考试的人才能进入，并且考试。
*/
public class Test {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom();
        //学生可以参加考试
        examRoom.kaoShi(new Student());
        //老师可以参加考试
        examRoom.kaoShi(new Teacher());
        //员工不能参加考试，因为他没有实现考试接口
        //examRoom.kaoShi(new Employee());
        System.out.println("----------------");
        examRoom.kaoShi(new Exam() {
            @Override
            public void exam() {
                System.out.println("我也能来考试....");
            }
        });
        examRoom.kaoShi(()->{
            System.out.println("他能来，我也能来考试....");
        });
    }
}
