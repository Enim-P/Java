package com.bing.p6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test6 {
    public static void main(String[] args) {
        Random random = new Random();
        // 随机数对象的ints方法，返回的也是一个stream流，只不过它是具体的IntStream流
        int[] nums = random.ints(-100,100)
                .limit(10)
                .toArray();
        System.out.println(Arrays.toString(nums));
        System.out.println("----------------");
        random.ints(-100,100)
                .limit(10)   //返回十个随机数
                .filter(i->i<0)   //过滤出小于0的随机数
                .sorted()  //默认升序
                .forEach(System.out::println);
        System.out.println("----------------");
        // 生成一个Int统计对象
        IntSummaryStatistics statistics = random.ints(0, 100)
                .limit(100)
                .summaryStatistics();
        System.out.println(statistics.getCount());
        System.out.println(statistics.getSum());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getAverage());
        System.out.println("----------------");
        List<Integer> list = new LinkedList<Integer>(){{
            this.add(55);
            this.add(27);
            this.add(12);
            this.add(33);
            this.add(68);
            this.add(9);
            this.add(27);
            this.add(12);
            this.add(33);
            this.add(55);
            this.add(48);
            this.add(39);
            this.add(22);
            this.add(9);
            this.add(68);
            this.add(12);
            this.add(39);
            this.add(27);
        }};
        IntSummaryStatistics statistics1 = list.stream()
                .distinct()  //先去重
                .mapToInt(i->i)  // 将Stream转为IntStream流
                .summaryStatistics();
        System.out.println(statistics1.getAverage());
        System.out.println(statistics1.getSum());
    }
}
