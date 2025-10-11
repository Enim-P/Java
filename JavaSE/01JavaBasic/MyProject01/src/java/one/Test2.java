package one;

/**
 * 测试类2
 */
public class    Test2 {
    //main方法的快捷键：输入main 直接回车
    public static void main(String[] args) {
        //sout回车是输出语句的快捷键方法
        //println()方法，输出内容后换行
        //print()方法，输出内容不换行
        System.out.println();
        //Ctrl + D  表示向下复制
        System.out.println("Word");

        System.out.print("你好");
        System.out.print("世界");

        //注意：这里不会另起一行（因为前面使用的print它不换行）
        System.out.println("哈哈哈哈");
        System.out.println("-------------------");
        // 单行注释的快捷键：Ctrl + /
        //多行注释的快捷键：Ctrl + Shift + /
        /*
        * 转义字符：带有特殊含义字符
        * \t:制表符
        * \n:换行符
        * */
        //取消转义字符的方式是: \\(在转义字符前面加入 \ )
        System.out.println("Hello\tWord");
        System.out.println("Hello\nWord");
        System.out.println("Hello\\nWord");
        System.out.println("Hello\\tWord");

    }
}
