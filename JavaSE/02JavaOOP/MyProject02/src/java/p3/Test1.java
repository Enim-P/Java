package p3;

public class Test1 {
    public static void main(String[] args) {
        String s1 = "a";
        s1 = "b";
        s1 = "c";
        s1 += "d";
        s1 += "e";
        // 注意：只要字符串的内容发生变化，就会重新创建一个堆空间进行存储，然后将最的堆的空间地址返回
        // 所以上面的字符串在内存中产生了5个堆空间，只保存了最后一个堆空间的地址
        // 字符串的的值如果反复发生变化，其实是很浪费内存空间的，但是不要慌java有自己的垃圾回收机制
        // 但是回收不是立刻的，需要等待，而等待的过程也是一种损耗。
        System.out.println(s1);
        System.out.println("------------------");
        // 当前我们的字符串内容需要反复更新时，使用增强版字符串StringBuilder 或 StringBuffer
        // 注意：StringBuilder必须要new
        StringBuilder s2 = new StringBuilder("abcd");
        System.out.println(s2);
        //append方法，用于追加内容
        s2.append("你好");
        System.out.println(s2);
        s2.append("哈哈");
        System.out.println(s2);
        //insert方法，用于插入内容
        s2.insert(4,"在干嘛");
        System.out.println(s2);
        //delete方法，用于删除内容
        s2.delete(1,3);
        System.out.println(s2);
        // 无论如何更新s2，s2在内存中始终使用的是第一次创建的堆空间
        System.out.println("------------------");
        // StringBuilder对象，通过toString()方法，将内容转为字符串类型
        String s3 = s2.toString();
        System.out.println(s3);
    }
}
