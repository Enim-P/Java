package one;
/**
 * 测试类5
 * */
public class Test5 {
    public static void main(String[] args) {
        // 在定义变量时，必须要明确数据类型,因为Java是强类型语言
        // 注意：即便到JDK17以后，Java推出了var关键字定义变量，不需要明确类型
        // var关键字只是一种语法糖，在编译的时候就会根据具体数据变量成对应的类型，而不是在运行的时候。
        // 比如js就是弱类型语言，在定义变量的时候不需要明确类型，程序运行到这一行的时候编译器再根据具体的数据推断出类型
        // 总结：强类型语言在编译阶段就需要明确数据类型，而弱类型语言在运行时才推断出类型

        //Java中的数据类型只要分为：引用数据类型 和 基本数据类型
        //常用的基本数据类型包括：
        // 1. 整数类型
        /*
            byte 字节类型，长度为8个bit（8位），8位就是一个字节，最大存储范围：-128~127
            short 短整型  长度为16个bit（16位） 两个字节大小，最大存储范围是 -32768~32767
            int   整型    长度为32位   最大存储范围：-2147483648~2147483647
            long  长整型  长度位64位   最大存储范围：-9，233，372，036，854，775，808 ~ 9，233，372，036，854，775，807
        * */


            byte b = 127;
            short s = 32767;
            int   i = 2147483647;
            //注意：定义long数据需要在数据后面加一个l\L
            long  l = 933372036854775807l;
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println("----------------");
        // 如果long也装不下的数据，后面我们会学习Biginteger类型
        // 2. 浮点数类型
        /*
            float   单精度32位浮点型
            double  双精度64位浮点型
        */
        // 小数数据默认都是double数据，float数据需要在数据的后面加上一个f\F;
        float f = 55.777777f;
        System.out.println(f);
        double d = 55.555555555555;
        System.out.println(d);
        System.out.println("--------------");
        // 总结：整数型默认采用int,浮点型默认采用double

        // 3. 字符型类型 和 字符串类型
        /*
            char   字符类型，长度为16位，2个字节
            String 字符串类型，它是引用类型

        * */
        // 字符型的数据采用单引号括起来，里面是只能存储一个字符（Unicode编码的字符），大小是0 ~ 65535
        // 在计算机领域我们人为的将全球范围内使用的字符编程了一个编码表，这个编码表就是Unicode编码
        // 它将每一个长用的字符对应的一个十进制的数字，比如： A -> 65 , a -> 97
            char c1 = 'a';
            int i1 = (int)c1; // 这里需要使用强制类型转换，将对应的字符转换成Unicode编码对应的整数数据
            char c2 = '你';
            int i2 = (int)c2;
            char c3 = '$';
            int i3 = (int)c3;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println("-----------------");
        // 字符串的数据采用双引号括起来，它本质上是引用类型，现阶段先当成基本类型使用
        String s1 = "Hello";
        String s2 = "你好";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("-----------------");

        // 3. 布尔类型
        /*
            布尔类型用于表示真或假，只有两种值 true 和 fales ,true表示真 false表示假
            这种类型的数据，通常用于条件判断
        * */
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1);
        System.out.println(b2);
    }
}
