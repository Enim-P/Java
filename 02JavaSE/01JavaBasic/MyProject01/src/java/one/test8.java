package one;
/**
 * 测试类8
 * */

public class test8 {
    public static void main(String[] args) {
        // 2. 关系运算符，也叫比较运算符， > >= < <= !=
        int a = 5;
        int b = 4;
        int c = 5;
        // 关系运算符表达式的返回结果时布尔值
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= c);
        System.out.println(a <= c);
        System.out.println(a != b);
        System.out.println(a == b);
        System.out.println("---------------------------");
        // 3. 逻辑运算符， && || !
        // && 与运算符，要求运算符两边都返回true，表达式才返回true
        // || 或运算符，要求运算符两边只要有一边返回true，整个表达式就返回true
        // ！ 非运算符， 就是将表达式的结果取反，比如：原先是true，取反就是false
        System.out.println(a > b && a < c);
        System.out.println(a == c && b < c);
        System.out.println(a > c || b < c);
        System.out.println(!(a > b) || b > c);
        System.out.println("---------------------------");
        boolean d = a > b && a-2 > b || a*2-b < b &&(c/2-2)>1 || !(b-c==a);
        System.out.println(a > b && a-2 > b || a*2-b < b &&(c/2-2)>1 || !(b-c==a));
        // 运算符的优先级: （）-> ! -> 算数 -> && -> ||
    }
}
