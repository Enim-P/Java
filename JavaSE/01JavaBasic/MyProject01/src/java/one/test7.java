package one;
/**
 * 测试7
 * */
public class test7 {
    public static void main(String[] args) {
        // 运算符
        // 1. 赋值运算符=，用于将 ‘=’ 右边的结果赋值给左边的变量
        int a = 100;
        // 算数运算符：+ - * / %(取余)
        int b = 7;
        int c = 4;
        int d = b + c;
        int e = b - c;
        // 两个int数据相除结果还是int,不保留小数
        int f = b / c;
        int g = b * c;
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        double h = 7;
        double i = 4;
        double j =  h / i ;
        System.out.println(j);
        // %运算符表示取余，两个数相除，取余数
        int k = b % c;
        System.out.println(k);
        // 案例：求出12345中各个位数之和，就是1+2+3+4+5，就是有一个五位数，求出他的各个位数之和
        int money = 12345;
        // 要先拿到money的万位数， 千位数， 百位数， 十位数，个位数，再相加
        int v = money / 10000;
        System.out.println(v);
        int n = (money- v*10000) / 1000;
        System.out.println(n);
        int m = (money - (v*10000 + n *1000)) / 100;
        System.out.println(m);
        int l = (money - (v*10000 + n * 1000 + m*100) ) / 10;
        System.out.println(l);
        int w = (money - (v * 10000 + n * 1000 + m * 100 + l * 10)) / 1;
        int o = v + n + m + l + w;
        System.out.println(o);
        System.out.println("------------------");
        String str = "hello";
        // 字符串也可以使用+运算符进行拼接，在一个+表达式中，字符串后面的所有数据都当成字符串处理
        System.out.println(v+n+str+m+l);
        // （）里面的表达式先执行
        System.out.println(v+n+str+m+l);
        System.out.println("----------------");
        // ++ 和 -- 运算符，分别表示自增和自减
        int lin = 5 ;
        lin ++;
        System.out.println(lin);
        ++lin;
        // ++在前和在后，对于变量而言都自增1
        System.out.println(lin);
        lin--;
        System.out.println(lin);
        --lin;
        // --在前和在后对于变量而言都自减
        System.out.println(lin);
        System.out.println("----------------");
        int min = 5;
        System.out.println(m++); // ++在后，是先返回结果，然后自身再加一
        System.out.println(m);
        System.out.println(++m); // ++在前，是自身先加一，再返回结果
        System.out.println(m);
        System.out.println("----------------");
        int nin = 5;
        int oin = nin++ + ++nin - --nin + nin-- + nin ;
        System.out.println(oin);
        System.out.println("----------------");
        int pin = 5;
        // 算数运算符扩展 ； += -= *= /= %=
        pin += 5; //相当于 pin = pin + 5
        System.out.println(pin);
    }
}
