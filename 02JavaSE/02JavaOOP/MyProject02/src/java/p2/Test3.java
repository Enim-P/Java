package p2;

public class Test3 {
    public static void main(String[] args) {
        // 定义了一个字符串
        String s1 = "abcdabcdabcd";
        // length方法，返回字符串的长度
        System.out.println(s1.length());
        // indexOf方法，查找指定内容的在原始字符串中第一次出现的位置
        // 注意：字符串的中每个字符的位置，索引从0开始
        System.out.println(s1.indexOf("d"));
        // 如果找不到，返回-1
        System.out.println(s1.indexOf("e"));
        // lastIndexOf方法，查找指定内容在原始字符串中最后一次出现的位置
        System.out.println(s1.lastIndexOf("c"));
        // 如果找不到，返回-1
        System.out.println(s1.lastIndexOf("e"));
        // 截取指定区间的内容，第一个参数是起始位置，第二个参数是结束位置（注意：取不到最后一个位置）
        System.out.println(s1.substring(2,5));
        // 如果只传一个参数，表示从起始位置开始往后全部截取
        System.out.println(s1.substring(2));
        System.out.println("----------");
        String s2 = "aBcD";
        // 将字符串转为小写
        System.out.println(s2.toLowerCase());
        // 将字符串转为大写
        System.out.println(s2.toUpperCase());
        // 注意：字符串的所有方法，都是返回一个字符串的副本，不会改变本身内容
        System.out.println(s2);
        System.out.println("----------");
        String s3 = "  ab  cd  ";
        // 空格也是字符，所以这里的字符串长度为10
        System.out.println(s3.length());
        // trim方法，去掉字符串两端空格，注意：字符串中间的空格无法去除
        System.out.println(s3.trim().length());
        System.out.println("----------");
        String s4 = "abc哈哈def";
        // replace方法，用于替换字符串中指定的字符
        System.out.println(s4.replace('哈','呵'));
    }
}
