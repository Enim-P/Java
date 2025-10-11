package one;
/**
 * 测试6
 * */
public class test6 {
    public static void main(String[] args) {
        // 隐式类型转换，也叫自动类型转换
        byte b = 127;
        //由于short的存储空间比byte大，所以byte可以自动转为short
        short s = b ;
        // int比short大
        int i = s;
        // long比int大
        long l = i;
        // 总结： 小类型可以自动转为大类型

        int i2 = 100;
        System.out.println(i2);
        double d = i2;
        System.out.println(d);
        // 这里int是32位，float也是32位
        // 注意：由于浮点型要计算精度，所以在内存中他的实际使用空间要比long还要大
        float f1 = i2;
        System.out.println(f1);
        long l2 = 200l;
        float f2 = l2;
        System.out.println(f2);

        // 自动类型转换规则如下：byte -> short -> int -> long -> float -> double
        // 注意：char类型也能转为int
        char c1 = 'a';
        int i3 = c1;
        System.out.println("----------------");

        //显示类型转换，也叫强制类型转换
        int i4 = 100;
        // 强制转换的规则是（）
        byte b2 = (byte)i4;
        System.out.println(b2);
        int i5 = 200;
        // 强制类型转换时，如果大空间里面存储的数据，超过了小空间里面存储的大小，数据会发生错误
        byte b3 = (byte) i5;
        System.out.println(b3);

    }
}
