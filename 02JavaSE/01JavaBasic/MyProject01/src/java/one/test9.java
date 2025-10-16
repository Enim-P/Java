package one;
/**
 * 测试9
 * */

public class test9 {
    public static void main(String[] args) {
        // 三目运算符，也叫三元表达式
        // 如果变量的数据类型相同，可以同时定义
        int a = 5, b = 7;
        // 判断？前面的表达式，如果表达式返回true，返回？后面的值，否则返回：后面的值
        String str = a > b ? "a大于b" : "a不大于b";
        System.out.println(str);
    }
}
