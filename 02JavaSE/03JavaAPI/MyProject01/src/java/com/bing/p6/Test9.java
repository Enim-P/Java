package com.bing.p6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test9 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s1 = "abc";
        // 判断s1不为null时，添加到集合中
        if(s1!=null){
            list.add(s1);
        }
        System.out.println(list);
        System.out.println("----------------");
        String s2 = "cba";
        // 将字符串转为Optional类型
        Optional<String> optional = Optional.ofNullable(s2);
        // ifPresent方法，会先判断值是否不为null，在执行操作
        optional.ifPresent(System.out::println);
        optional.ifPresent(v->{
            list.add(v);
        });
        System.out.println(list);
        // 上面的案例看上去好像是多此一举，你这样想，很多数据是调用其他方法返回的，你是不知道这方法返回的是不是null
        System.out.println("----------------");
        String s3 = null;
        Optional<String> optional2 = Optional.ofNullable(s3);
        // 如果Optional包装的值是null，强行获取会发生异常
        //System.out.println(optional2.get());
        // orElse方法，在获取包装值的时候，如果是null，返回指定的other值
        System.out.println(optional2.orElse("哈哈"));
        System.out.println("----------------");
        String s4 = "A";
        Optional<String> optional3 = Optional.ofNullable(s4);
        // 也支持过滤操作
        System.out.println(optional3.filter(s->s.equals("B")).orElse("B"));
        // 也支持映射操作
        System.out.println(optional3.map(s->s+"BC").get());
    }
}
