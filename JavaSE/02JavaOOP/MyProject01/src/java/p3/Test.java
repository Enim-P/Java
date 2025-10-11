package p3;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        int num1 = 175;
        int num2 = 27;
        // 调用学生对象的计算方法，对num1和num2根据不同了类型进行技术
        System.out.println(s.calc(num1,num2,"+"));
        System.out.println(s.calc(num1,num2,"-"));
        System.out.println(s.calc(num1,num2,"*"));
        System.out.println(s.calc(num1,num2,"/"));
        System.out.println(s.calc(num1,num2,"%"));
        System.out.println("--------------");
        System.out.println(s.isLeepYear(2000));
        System.out.println(s.isLeepYear(2001));
        System.out.println("--------------");
        s.printSjx(3);
        s.printSjx(5);
        s.printSjx(7);
    }
}
