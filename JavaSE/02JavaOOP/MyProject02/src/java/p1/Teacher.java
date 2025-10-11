package p1;

public class Teacher {
    // 静态属性,这里可以直接调用静态方法，将静态方法的返回值赋值给num
    static int num = getNum();
    String name;
    Teacher(){
        System.out.println("构造对象...");
    }

    // 该静态方法返回一个数字
    static int getNum(){
        System.out.println("静态方法执行...");
        return 100;
    }

    public static void main(String[] args) {
        // 访问Teacher类的num属性
        //System.out.println(Teacher.num);

        // 当类被访问的时候：首先会初始化类的静态成员，然后才是初始化实例成员，再然后才是调用构造函数
        Teacher t = new Teacher();
        //System.out.println(t.num);
    }
}
