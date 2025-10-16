package p1;

public class Test {
    public static void main(String[] args) {
        //创建了两个对象
        Student s1 = new Student();
        Student s2 = new Student();
        s1.name = "张三";
        s2.name = "李四";
        System.out.println(s1.name);
        System.out.println(s2.name);
        // 通过类操作类的静态成员（因为静态成员本来就是属于类的）
        Student.address = "南京";
        System.out.println(Student.address);
        System.out.println(s1.address);
        System.out.println(s2.address);
        System.out.println("--------------");
        s2.address = "北京";
        System.out.println(Student.address);
        System.out.println(s1.address);
        System.out.println(s2.address);
        // 通常情况下，我们操作静态成员直接使用类去访问，不要使用对象
        Student.sayHi();
    }
}
