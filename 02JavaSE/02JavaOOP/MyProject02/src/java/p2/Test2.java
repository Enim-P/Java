package p2;

public class Test2 {
    public static void main(String[] args) {
        String name = "张杰";
        int age = 20;
        String sex = "男";
        double score = 66.6;
        String str1 = "姓名："+name+"，年龄："+age+"，性别："+sex+"，成绩："+score;
        System.out.println(str1);
        // String的format方法，用于格式化字符串
        // format方法的第一个参数是格式化的文本，里面通过%s %d等等定义占位符
        // format方法的第二个参数往后都是占位符的填充值
        // 注意：拼接表达式中只要出现了一个String，整个表达式都会转为String
        // 所以字符串通过格式化拼接时占位符我们统一使用%s
        String str2 = String.format("姓名：%s，年龄：%s，性别：%s，成绩：%s",name,age,sex,score);
        System.out.println(str2);
        System.out.println("----------------------------");
        // 可在输出语句中直接使用String.format，因为String.format方法，返回的就是格式化后的字符串
        System.out.println(String.format("姓名：%s，年龄：%s，性别：%s，成绩：%s",name,age,sex,score));
    }
}
