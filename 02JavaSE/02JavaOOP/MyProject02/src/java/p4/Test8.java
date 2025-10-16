package p4;

public class Test8 {
    public static void main(String[] args) {
        // 创建一个学生对象
        Student s = new Student();
        //调用添加成绩的方法
        s.addScore(86);
        s.addScore(73);
        s.addScore(59);
        //调用查看成绩的方法
        s.show();
    }
}
